package springHib;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import springHib.dao.CarDao;
import springHib.entities.Car;

/**
 * Created by User on 2/13/2018.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@Transactional
public class DaoTest {

    @Autowired
    private CarDao carDao;

    @Test
    public void testCar() {
        Car car = new Car();
        car.setBrand("BMV");
        car.setModel("X6");
        carDao.save(car);

        Car foundCar = carDao.findByNameAndModel("X6", "BMV");
        System.out.println(car);
        System.out.println(foundCar);
        Assert.assertEquals(car.getBrand(), foundCar.getBrand());
    }
}
