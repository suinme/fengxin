package me.zurex.fengxin.service.user.dto;

/**
 * @author zurex
 * @date 2018/6/18
 * Make life more fun
 */
public class LoginResponse {
    private String nickName;
    private String userId;
    private String token;

    public LoginResponse(String nickName, String userId, String token) {
        this.nickName = nickName;
        this.userId = userId;
        this.token = token;
    }

    public String getNickName() {
        return nickName;
    }

    public String getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }
}
