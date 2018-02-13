package springHib.dao;

import springHib.entities.Car;

/**
 * Created by User on 2/13/2018.
 */
public interface CarDao extends BaseDao<Car> {

    Car findByNameAndModel(String model, String brand);
}
