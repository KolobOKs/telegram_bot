package me.koloboks.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kirill Maloyaroslavtsev on 24.05.16.
 */
@Transactional
public interface AttemptDao extends CrudRepository<Attempt, Long> {

}
