package me.zurex.fengxin.util;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zurex
 * @date 2018/6/20
 * Make life more fun
 */
@Component
public class JWTUtils {
    /** 过期时间5分钟 */
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    private static final String CLAIM = "uid";

    /**
     * 生成签名,5min后过期
     *
     * @param username 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public String sign(String username, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return  Jwts.builder()
                .claim(CLAIM, username)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public boolean verify(String token, String username, String secret) {
        try {

            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return claimsJws.getBody().getExpiration().after(new Date());
        } catch (SignatureException exception) {
            return false;
        }
    }

    public void getClaims(String token, String username, String secret)
    throws  SignatureException
    {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }

}
