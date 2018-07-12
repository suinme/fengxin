package me.zurex.fengxin.service.common;

import org.springframework.stereotype.Service;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 *
 * 提供所有短信类服务
 */
@Service
public class SmsService {

    /**
     * 根据手机号码发送指定的包含验证码的短信到用户
     * @param captcha 验证码
     * @param phoneNumber 手机号码
     * @return
     */
    public boolean sendCaptchaByPhoneNumber(String captcha, String phoneNumber){
        // TODO 发送短信的真实逻辑
        return true;
    }
}
