package me.koloboks.entities;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kirill Maloyaroslavtsev on 23.05.16.
 */
@Transactional
public interface GameDao extends CrudRepository<Game, Long> {
    Game getGameByUser(User user);

    @Query(value="select g from Game g where g.user.id=:userId and g.gameType=1")
    Game getCurrentGame(@Param("userId") long userId);

}
