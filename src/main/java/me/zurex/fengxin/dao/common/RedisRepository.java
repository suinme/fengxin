package me.zurex.fengxin.dao.common;

import me.zurex.fengxin.domain.BusinessName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 */
@Repository
public class RedisRepository {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String buildKey(BusinessName name, String id){
        return name.toString()+"_"+id;
    }

    public Boolean saveStringIfAbsent(BusinessName name, String key, String value){
        return  stringRedisTemplate.opsForValue().setIfAbsent(
                buildKey(name, key),
                value
        );
    }

    public Boolean saveStringIfAbsentWithExpire(BusinessName name, String key, String value, int expire){
        key = buildKey(name, key);
        Boolean absent = stringRedisTemplate.opsForValue().setIfAbsent(
                key,
                value
        );
        /* TODO 一旦启用代码数据就会被清除
        if (absent){
            stringRedisTemplate.opsForValue().set(
                    key,
                    value,
                    expire,
                    TimeUnit.MICROSECONDS
            );
        }
        */
        return absent;
    }

    public void saveStringValue(BusinessName name, String key, String value){
        stringRedisTemplate.opsForValue().set(
                buildKey(name, key),
                value
        );
    }

    public void saveStringValueWitExpire(BusinessName name, String key, String value, int expire){
        stringRedisTemplate.opsForValue().set(
                buildKey(name, key),
                value,
                expire,
                TimeUnit.MICROSECONDS
        );
    }

    public String getStringValue(BusinessName name, String key){
        key = buildKey(name, key);
        return stringRedisTemplate.opsForValue().get(key);
    }
}
