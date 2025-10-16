package com.example.listycity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    /**
     * This returns a boolean of whether or not a city exists in the CityList
     * @param city
     * This is the candidate city to find
     * @return
     * Return true if city is in the list, false if not.
     */
    public boolean hasCity(City city){
        for (City c : this.cities){
            if (c.equals(city)){
                return true;
            }
        }
        return false;
    }
    /**
     * This deletes the city if it exists in the list. Otherwise throws an IllegalArgumentException.
     * @param city
     * This is the candidate city to delete
     */
    public void deleteCity(City city){
        if (hasCity(city)){
            cities.remove(city);
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    /**
     * This returns the number of cities in the CityList
     * @return
     * Return the amount of cities in the CityList
     */
    public int countCities(){
        return cities.size();
    }

}