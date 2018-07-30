package me.zurex.fengxin.util;

import me.zurex.fengxin.WebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Base64;

import static org.junit.Assert.*;

/**
 * @author zurex
 * @date 2018/7/23
 * Make life more fun
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class JWTUtilsTest {
    @Autowired
    private JWTUtils jwtUtils;

    @Test
    public void sign() throws Exception {
        String userName = "nick_name";
        String secret = "123";
        secret = Base64.getEncoder().encode(secret.getBytes()).toString();
        String token = jwtUtils.sign(userName, secret);
        jwtUtils.getClaims(token, secret);
    }

    @Test
    public void verify() throws Exception {
    }

    @Test
    public void getClaims() throws Exception {
    }

}