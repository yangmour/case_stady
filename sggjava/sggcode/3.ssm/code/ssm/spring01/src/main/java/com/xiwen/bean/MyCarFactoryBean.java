package com.xiwen.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/07 -15:13
 * @Version: 1.0
 */
public class MyCarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setName("汽车");
        car.setColour("绿");
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
}
