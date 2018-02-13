package springHib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import springHib.entities.BaseEntity;

/**
 * Created by User on 2/13/2018.
 */
public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        this.entityClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    @Override
    public void save(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
