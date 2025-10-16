package com.example.listycity;

import org.junit.Test;

import static org.junit.Assert.*;
public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity(){
        CityList cityList = mockCityList();
        City city1 = cityList.getCities().get(0);
        City city2 = mockCity();
        City city3 = new City("Vanoucver", "British Columbia");

        assertTrue(cityList.hasCity(city1));
        assertTrue(cityList.hasCity(city2));
        assertFalse(cityList.hasCity(city3));
    }
    @Test
    public void testDeleteCity(){
        CityList cityList1 = mockCityList();
        City city1 = cityList1.getCities().get(0);
        cityList1.deleteCity(city1);
        assertEquals(0, cityList1.getCities().size());

        CityList cityList2 = mockCityList();
        City city2 = mockCity();
        cityList2.deleteCity(city2);
        assertEquals(0, cityList1.getCities().size());


        CityList cityList3 = mockCityList();
        City city3 = new City("Edmonton", "London");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList3.deleteCity(city3);
        });

    }
    @Test
    public void testCountCity(){
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Winnipeg", "Saskatchewan"));
        assertEquals(2, cityList.countCities());

        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(3, cityList.countCities());
    }

}
