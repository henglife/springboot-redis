package com.example.demo.mapper;


import com.example.demo.domain.CityDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper {

    Long  addCity(CityDomain city);

    List<CityDomain> findAllCity();

    CityDomain findById(Long id);

    CityDomain findByName(String cityName);

    Long updateCity(CityDomain city);

    Long deleteCity(Long id);


}
