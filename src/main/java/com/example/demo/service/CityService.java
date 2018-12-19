package com.example.demo.service;

import com.example.demo.domain.CityDomain;

public interface CityService {

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    CityDomain findCityById(Long id);

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long saveCity(CityDomain city);

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    Long updateCity(CityDomain city);

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    Long deleteCity(Long id);
}
