package me.zurex.fengxin.service.user;

import me.zurex.fengxin.dao.user.UserRepository;
import me.zurex.fengxin.domain.user.entity.UserModel;
import me.zurex.fengxin.service.common.CaptchaService;
import me.zurex.fengxin.service.common.SmsService;
import me.zurex.fengxin.service.exception.InvalidCaptchaException;
import me.zurex.fengxin.service.exception.TokenException;
import me.zurex.fengxin.service.user.dto.LoginResponse;
import me.zurex.fengxin.service.util.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 */
@Service
public class SignUpService {

    @Autowired
    CaptchaService captchaService;

    @Autowired
    SmsService smsService;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository userRepository;

    /**
     * 发送验证码给指定的手机用户
     * @param deviceId
     * @param phoneNumber
     */
    public void sendCaptchaByPhoneNumber(String deviceId, String phoneNumber, String areaCode){
        String captcha = captchaService.getNumberCaptchaByUid(
                buildUid(deviceId, phoneNumber)
        );
        if (!CaptchaService.INVALID_CAPTCHA.equals(captcha)){
            smsService.sendCaptchaByPhoneNumber(captcha, phoneNumber);
        }
    }

    /**
     * 快速登陆模块
     * 如果用户未注册，将会自动注册
     * @param deviceId 设备ID
     * @param phoneNumber 手机号码
     * @param areaCode 手机区号
     * @param captcha 验证码
     * @return
     * @throws InvalidCaptchaException
     */
    public LoginResponse quickLogin(
            String deviceId,
            String phoneNumber,
            String areaCode,
            String captcha
    ) throws InvalidCaptchaException, TokenException
    {
        boolean valid = captchaService.checkCaptcha(
                buildUid(deviceId, phoneNumber),
                captcha
        );
        if (valid){
            UserModel userModel = userRepository.findByPhoneNumberAndPhoneAreaCode(phoneNumber, areaCode);
            // 自动注册
            if (null == userModel){
                userModel = new UserModel(phoneNumber, areaCode);
                userModel = userRepository.save(userModel);
            }
            String token = tokenService.buildToken(userModel, 0);
            return new LoginResponse(userModel.getNickName(), userModel.getId(), token);
        }
        throw new InvalidCaptchaException(captcha+" is invalid");
    }

    private String buildUid(String deviceId, String phoneNumber){
        return deviceId + "_" + phoneNumber;
    }

}
