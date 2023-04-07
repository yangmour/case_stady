package com.xiwen.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/04/07 -11:26
 * @Version: 1.0
 */
public class CollectionBean {
    int[] arr;
    List<String> strings;
    List<Car> cars;
    Set<String> sets;
    Set<Car> setCars;
    Map<String, String> map;
    Map<String, Car> carMap;
    Properties properties;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public Set<Car> getSetCars() {
        return setCars;
    }

    public void setSetCars(Set<Car> setCars) {
        this.setCars = setCars;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(Map<String, Car> carMap) {
        this.carMap = carMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
