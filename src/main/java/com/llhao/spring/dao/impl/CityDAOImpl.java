package com.llhao.spring.dao.impl;

import com.llhao.spring.dao.ICityDAO;
import com.llhao.spring.entity.City;

/**
 * Created by llhao on 2017/3/23.
 */
public class CityDAOImpl implements ICityDAO{

    public void addCity(City city) {
        System.out.println("add city :" +city.getName());
    }
}
