package ru.javawebinar.restaurantvoting.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.restaurantvoting.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Vote Controller")
@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v WHERE v.localDate=:date ORDER BY v.userId")
    List<Vote> getAllByLocalDate(LocalDate date);

    @Query("SELECT v FROM Vote v ORDER BY v.localDate, v.userId")
    List<Vote> getAll();

    @Modifying
    @Transactional
    @Query("UPDATE Vote v SET v.restId = :restId WHERE v.localDate=:localDate AND v.userId=:userId")
    void update(int userId, int restId, LocalDate localDate);

    @Query("SELECT v.restId FROM Vote v WHERE v.localDate=:date")
    List<Integer> getAllOnlyIdsByLocalDate(LocalDate date);

    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(int id);
}
