package me.zurex.fengxin.domain.user.entity;

import javax.persistence.*;


/**
 * @author zurex
 * @date 2018/6/10
 * 用户核心数据
 * Make life more fun
 */
@Table(name = "user")
@Entity
public class UserModel {
    /** 用户id */
    @Id
    @GeneratedValue
    private long id;
    /** 用户昵称 允许重复 */
    private String nickName;
    /** 用户手机号码 */
    private String phoneNumber;
    /** 用户手机号码区号 */
    private String phoneAreaCode;
    /** 用户身份证号码 */
    private String certification;
    private String avatar;
    private String salt;

    public UserModel(){

    }

    public UserModel(String phoneNumber, String phoneAreaCode){
        this.phoneNumber = phoneNumber;
        this.phoneAreaCode = phoneAreaCode;
        this.nickName = "所幸" + phoneNumber.substring(phoneNumber.length()-4);
    }

    public long getId(){
        return id;
    }

    public String getNickName(){
        return nickName;
    }

    public String getAvatar() {
        return null == avatar ? "" : avatar;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }

    public void setPhoneAreaCode(String phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }


    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
