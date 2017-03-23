package com.llhao.spring.entity;

/**
 * Created by llhao on 2017/3/23.
 */
public class City {
    private double lat;
    private double lng;
    private String name;
    private City parent;

    public City() {
    }

    public City(String name, double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getParent() {
        return parent;
    }

    public void setParent(City parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        City c = this;
        StringBuilder builder = new StringBuilder();
        while(c.getParent()!=null){
            builder.append(c.getName()+":");
            c = c.getParent();
        }
        return builder.toString();
    }
}
