package me.koloboks.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kirill Maloyaroslavtsev on 19.05.16.
 */
@Transactional
public interface PhotoDao extends CrudRepository<Photo,Long> {
    public Photo findByName (String name);
}
