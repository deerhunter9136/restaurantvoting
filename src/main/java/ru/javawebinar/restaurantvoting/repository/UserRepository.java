package ru.javawebinar.restaurantvoting.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.restaurantvoting.model.User;
import ru.javawebinar.restaurantvoting.util.validation.ValidationUtil;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Tag(name = "User Controller")
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = LOWER(:email)")
    Optional<User> findByEmailIgnoreCase(String email);

    @Cacheable(value = "users")
    @Override
    List<User> findAll();

    @Transactional
    @CacheEvict(value = "users", allEntries = true)
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int simpleDelete(int id);

     default void delete(int id) {
        ValidationUtil.checkModification(simpleDelete(id), id);
    }

    @Transactional
    @CacheEvict(value = "users", allEntries = true)
    @Override
    <S extends User> S save(S entity);
}