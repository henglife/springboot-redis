package com.example.demo;

import com.example.demo.domain.CityDomain;
import com.example.demo.service.CityService;
import com.example.demo.utils.JsonUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CityTest {
    public static final Long ID=7L;
    public static final Long PROVINCEDID=5L;
    public static final String CITYNAME="云南";
    public static final String DESCRIPTION1="鲜花饼";
    public static final String DESCRIPTION2="bugfix test";

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    CityService cityService;
    RequestBuilder request;
    CityDomain cityDomain=new CityDomain();

    @Test
    public void addCityTest() throws Exception {


        //添加一个城市

        cityDomain.setId(ID);
        cityDomain.setProvinceId(PROVINCEDID);
        cityDomain.setCityName(CITYNAME);
        cityDomain.setDescription(DESCRIPTION1);

        request = post("/api/city/add")
                .content(JsonUtils.toJsonString(cityDomain))
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andDo(print()).andExpect(status().isOk());

        //查询城市
        request = get("/api/city/" + cityDomain.getId());
        mockMvc.perform(request).andDo(print()).andExpect(status().isOk());
        Assert.assertEquals(cityDomain.getProvinceId(), PROVINCEDID);
        Assert.assertEquals(cityDomain.getCityName(), CITYNAME);
        Assert.assertEquals(cityDomain.getDescription(), DESCRIPTION1);


        //修改城市
        cityDomain.setId(ID);
        cityDomain.setProvinceId(PROVINCEDID);
        cityDomain.setCityName(CITYNAME);
        cityDomain.setDescription(DESCRIPTION2);
        request = put("/api/city/update")
                .content(JsonUtils.toJsonString(cityDomain))
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andDo(print()).andExpect(status().isOk());


        //查看修改后的description
        request = get("/api/city/" + cityDomain.getId());
        Assert.assertEquals(cityDomain.getDescription(), DESCRIPTION2);
        mockMvc.perform(request).andDo(print()).andExpect(status().isOk());


    }

}
