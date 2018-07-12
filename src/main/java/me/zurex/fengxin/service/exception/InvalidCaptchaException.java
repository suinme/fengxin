package me.zurex.fengxin.service.exception;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 */
public class InvalidCaptchaException extends Exception {
    public InvalidCaptchaException(String message){
        super(message);
    }
}
