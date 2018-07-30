package me.zurex.fengxin.service.exception;

/**
 * @author zurex
 * @date 2018/7/24
 * Make life more fun
 */
public class TokenException extends Exception {
    public TokenException(String message){
        super(message);
    }

    public TokenException(Exception e){
        super(e);
    }
}
