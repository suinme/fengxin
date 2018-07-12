package me.zurex.fengxin.service.common;

import me.zurex.fengxin.dao.common.RedisRepository;
import me.zurex.fengxin.domain.BusinessName;
import me.zurex.fengxin.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 *
 * 提供验证码服务
 * 包括但不限于一下形式：
 * 1. 数字验证码 用于短信
 * 2. 图片验证码 用于app
 */
@Service
public class CaptchaService {
    private static final Logger LOG = LoggerFactory.getLogger(CaptchaService.class);
    private static int CAPTCHA_EXPIRE = 600000;
    public static String INVALID_CAPTCHA = "INVALID_CAPTCHA";

    @Autowired
    RedisRepository redisRepository;

    @Autowired
    SmsService smsService;

    /**
     * 通过uid返回对应的验证码
     * @param uid 使用方自定义识别码
     * @return 验证码
     */
    public String getNumberCaptchaByUid(String uid){
        String captcha = getShortCaptchaNumber(uid);
        Boolean isAbsent = redisRepository.saveStringIfAbsentWithExpire(
                BusinessName.CAPTCHA,
                uid,
                captcha,
                CAPTCHA_EXPIRE
        );
        if (isAbsent) {
            return captcha;
        }else {
            return INVALID_CAPTCHA;
        }
    }

    /**
     * 校验验证码是否有效
     * 分为两种情况
     * 1）服务端尚未生成验证码
     * 2）服务端的验证码和用户提交的验证码不匹配
     * @param uid 使用方自定义识别码
     * @param captcha 验证码
     * @return 是否有效
     */
    public boolean checkCaptcha(String uid, String captcha){
        String target = redisRepository.getStringValue(
                BusinessName.CAPTCHA,
                uid
        );
        if (StringUtils.isEmpty(target) || !target.equals(captcha)){
            LOG.warn(String.format(
                    "target captcha is %s, get wrong captcha: %s",
                    target,
                    captcha
            ));
            return false;
        }
        return true;
    }

    private String getShortCaptchaNumber(String uid){
        // TODO 产生一个根据设备id和时间的随机序列
        return "0075";
    }
}
