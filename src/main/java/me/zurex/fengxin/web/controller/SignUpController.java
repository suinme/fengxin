package me.zurex.fengxin.web.controller;

import me.zurex.fengxin.service.exception.InvalidCaptchaException;
import me.zurex.fengxin.service.exception.TokenException;
import me.zurex.fengxin.service.user.SignUpService;
import me.zurex.fengxin.web.base.ApiResponse;
import me.zurex.fengxin.web.base.BaseStatus;
import me.zurex.fengxin.web.util.ApiResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zurex
 * @date 2018/6/9
 * Make life more fun
 *
 * 登陆相关模块代码
 */
@RestController
@RequestMapping("/api/signup")
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    /**
     * 向指定的手机号码发送验证码
     * 注意需要防止重复发送，对于同一个id或者同一个phoneNumber
     * 限制为： 1）60s发送一次 2）最多发送5次
     * @param deviceId 设备识别id，用来区分不用的设备
     * @param phoneNumber 手机号码
     * @return
     */
    @RequestMapping("/sendCaptchaByPhoneNumber")
    public ApiResponse sendCaptchaByPhoneNumber(
            @RequestParam String deviceId,
            @RequestParam String phoneNumber,
            @RequestParam String areaCode
    ){
        signUpService.sendCaptchaByPhoneNumber(deviceId, phoneNumber, areaCode);
        return ApiResponseBuilder.buildSuccessResponse("success");
    }

    /**
     * 快速登陆
     * 根据设备识别id，手机号和验证码快速登陆，如果该手机尚未注册，触发快捷注册功能
     * @param deviceId
     * @param phoneNumber
     * @param captcha
     * @return 登陆token
     */
    @RequestMapping("/quick_login")
    public ApiResponse quickLogin(String deviceId, String phoneNumber, String areaCode, String captcha){
        try {
            return ApiResponseBuilder.buildSuccessResponse(
                    signUpService.quickLogin(deviceId, phoneNumber, areaCode, captcha)
            );
        } catch (InvalidCaptchaException e){
            return ApiResponseBuilder.buildErrorResponse(BaseStatus.ERROR, e.getMessage());
        } catch (TokenException e){
            return ApiResponseBuilder.buildErrorResponse(BaseStatus.ERROR, e.getMessage());
        }
    }
}
