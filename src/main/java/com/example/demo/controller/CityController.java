package com.example.demo.controller;


import com.example.demo.domain.CityDomain;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}",method = RequestMethod.GET)
    public CityDomain findOneCity(@PathVariable("id") Long id){
        return cityService.findCityById(id);
    }


    @RequestMapping(value = "/api/city/add", method = RequestMethod.POST)
    public void createCity(@RequestBody CityDomain city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city/update", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody CityDomain city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.PUT)
    public void deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
    }
}
