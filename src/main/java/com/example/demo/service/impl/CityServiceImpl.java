package com.example.demo.service.impl;


import com.example.demo.domain.CityDomain;
import com.example.demo.mapper.CityMapper;
import com.example.demo.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CityServiceImpl implements CityService {
    private static final Logger LOGGER= LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取城市逻辑：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
    public CityDomain findCityById(Long id){
        //从缓存中获取城市信息
        String key="city_"+id;
        ValueOperations<String,CityDomain> operations=redisTemplate.opsForValue();

        //缓存存在
        boolean hasKey=redisTemplate.hasKey(key);
        if (hasKey){

            CityDomain cityDomain=operations.get(key);

            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> "+cityMapper.toString());
            return cityDomain;
        }
        //从数据库获取城市信息
        LOGGER.info("CityServiceImpl.updateCity() : 从数据库中获取的城市 >> ");
        CityDomain city=cityMapper.findById(id);

        //插入缓存
        operations.set(key,city);
        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());


        return city;
    }

    @Override
    public Long saveCity(CityDomain city){
        return cityMapper.addCity(city);
    }
    /**
     * 更新城市逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
    @Override
    public Long updateCity(CityDomain city){
        Long ret=cityMapper.updateCity(city);

        //缓存存在，删除缓存
        String key="city_"+city.getId();
        boolean haskey=redisTemplate.hasKey(key);
        if(haskey){
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
        }

        return ret;
    }

    @Override
    public Long deleteCity(Long id) {
        Long ret=cityMapper.deleteCity(id);

        //缓存存在，删除缓存
        String key="city_"+id;
        boolean haskey=redisTemplate.hasKey(key);
        if (haskey){
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
        }
        return ret;
    }
}
