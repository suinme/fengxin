package me.zurex.fengxin.domain.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author zurex
 * @date 2018/6/10
 * 用户核心数据
 * Make life more fun
 */
@Document(collection = "user")
public class UserModel {
    /** 用户id */
    @Id
    private String id;
    /** 用户昵称 允许重复 */
    private String nickName;
    /** 用户手机号码 */
    private String phoneNumber;
    /** 用户手机号码区号 */
    private String phoneAreaCode;
    /** 用户身份证号码 */
    private String certification;
    /** 用户省份 */
    private String provice;
    /** 用户城市 */
    private String city;
    private String avatar;

    public UserModel(String phoneNumber, String phoneAreaCode){
        this.phoneNumber = phoneNumber;
        this.phoneAreaCode = phoneAreaCode;
        this.nickName = "所幸" + phoneNumber.substring(phoneNumber.length()-4);
    }

    public String getId(){
        return id;
    }

    public String getNickName(){
        return nickName;
    }

    public String getAvatar() {
        return avatar;
    }
}
