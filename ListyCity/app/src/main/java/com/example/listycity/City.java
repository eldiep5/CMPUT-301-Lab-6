package com.example.listycity;
/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * Constructor of City
     * @param city
     * The city name
     * @param province
     * The province name
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    /**
     * This returns the city name
     * @return
     * Return the city name
     */
    String getCityName(){
        return this.city;
    }
    /**
     * This returns the province name
     * @return
     * Return the province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Comaprison function for City
     * @param o
     * City to be compared
     * @return
     * -1 if this city is less then the given city o, 0 if city is equal to given city, 1 if this city is greater
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
    // https://www.infoworld.com/article/3305792/comparing-java-objects-with-equals-and-hashcode.html
    /**
     * Equals function for City
     * @param o
     * Object to check if equal
     * @return
     * Return true if given object is equal to this city, false otherwise
     */
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City c = (City) o;
        return this.city.equals(c.getCityName())  && this.province.equals(c.getProvinceName());
    }
}