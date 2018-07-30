package me.zurex.fengxin.service.exception;

/**
 * @author zurex
 * @date 2018/7/24
 * Make life more fun
 */
public class AuthException extends Exception{
    public AuthException(String message){
        super(message);
    }

    public AuthException(Exception e){
        super(e);
    }
}
