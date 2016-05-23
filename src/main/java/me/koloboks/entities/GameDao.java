package me.koloboks.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kirill Maloyaroslavtsev on 23.05.16.
 */
@Transactional
public interface GameDao extends CrudRepository<Game, Long> {
    Game getGameByUser(User user);
}
