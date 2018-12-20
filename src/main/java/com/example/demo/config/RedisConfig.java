package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {



    @Bean("forObject")
    RedisTemplate createRedisTemplate(RedisConnectionFactory factory) {

        /*
         *RedisTemplate是Spring提供用于操作redis数据库的一个类。
         *RedisTemplate默认的序列化类是JdkSerializationRedisSerializer（被序列化的对象必须实现Serializable接口）
         */

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //JdkSerializationRedisSerializer redisSerializer = new JdkSerializationRedisSerializer();
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer=new GenericJackson2JsonRedisSerializer();
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();

        template.setConnectionFactory(factory);
        template.setKeySerializer(stringSerializer);
        //template.setValueSerializer(redisSerializer);
        template.setValueSerializer(genericJackson2JsonRedisSerializer);
        return template;
    }

}
