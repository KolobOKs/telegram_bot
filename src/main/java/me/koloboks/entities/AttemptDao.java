package me.koloboks.entities;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kirill Maloyaroslavtsev on 24.05.16.
 */
@Transactional
public interface AttemptDao extends CrudRepository<Attempt, Long> {

    @Query(value="select g from Attempt g where g.game=:game order by g.id")
    Attempt[] getAttemptsForGame(@Param("game") Game game);
}
