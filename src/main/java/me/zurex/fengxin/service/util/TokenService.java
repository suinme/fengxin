package me.zurex.fengxin.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.zurex.fengxin.dao.common.RedisRepository;
import me.zurex.fengxin.domain.BusinessName;
import me.zurex.fengxin.domain.user.entity.UserModel;
import me.zurex.fengxin.service.exception.TokenException;
import me.zurex.fengxin.util.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 */
@Component
public class TokenService {
    @Autowired
    private RedisRepository redisRepository;

    @Autowired
    private JWTUtils jwtUtils;

    private ObjectMapper objectMapper = new ObjectMapper();

    public String buildToken(UserModel userModel, int expire) throws TokenException{
        String token = jwtUtils.sign(String.valueOf(userModel.getId()), null);
        try {
            String user = objectMapper.writeValueAsString(userModel);
            redisRepository.saveStringIfAbsentWithExpire(BusinessName.TOKEN, token, user, expire);
        }catch (JsonProcessingException e){
            throw new TokenException(e);
        }
        return token;
    }

    public boolean checkToken(String id, String token){
        String target = redisRepository.getStringValue(BusinessName.TOKEN, token);
        if (StringUtils.equals(id, target)){
            return true;
        }
        return false;
    }

    public UserModel getUserByToken(String token) throws TokenException{
        String user = redisRepository.getStringValue(BusinessName.TOKEN, token);
        try {
            UserModel userModel = objectMapper.readValue(user, UserModel.class);
            return userModel;
        }catch (IOException e){
            throw new TokenException(e);
        }
    }
}
