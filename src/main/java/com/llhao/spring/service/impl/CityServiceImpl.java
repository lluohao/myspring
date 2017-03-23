package com.llhao.spring.service.impl;

import com.llhao.spring.dao.ICityDAO;
import com.llhao.spring.entity.City;
import com.llhao.spring.service.ICityService;

/**
 * Created by llhao on 2017/3/23.
 */
public class CityServiceImpl implements ICityService {
    private ICityDAO cityDAO;
    public void addCity(String name, double lat, double lng) {
        City city = new City(name,lat,lng);
        cityDAO.addCity(city);
    }


}
