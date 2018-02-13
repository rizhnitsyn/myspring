package springHib.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import springHib.entities.Car;

import java.util.List;

/**
 * Created by User on 2/13/2018.
 */
@Repository
public class CarDaoImpl extends BaseDaoImpl<Car> implements CarDao {

    @Override
    public Car findByNameAndModel(String model, String brand) {
        Session session = getSessionFactory().getCurrentSession();
        List<Car> car = session.createQuery("select c from Car c where c.brand = :brand and c.model = :model", Car.class)
                .setParameter("brand", brand)
                .setParameter("model", model)
                .getResultList();

        return !car.isEmpty() ? car.get(0) : null;
    }
}
