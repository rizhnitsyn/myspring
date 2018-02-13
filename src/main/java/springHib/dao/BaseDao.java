package springHib.dao;

import springHib.entities.BaseEntity;

/**
 * Created by User on 2/13/2018.
 */
public interface BaseDao<T extends BaseEntity> {

    void save(T entity);
}
