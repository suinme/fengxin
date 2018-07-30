package me.zurex.fengxin.domain.user.entity;


import me.zurex.fengxin.domain.user.Constellation;
import me.zurex.fengxin.domain.user.Gender;

import javax.persistence.*;

/**
 * @author zurex
 * @date 2018/6/18
 * 用户资料
 * Make life more fun
 */
@Table(name = "user_profile")
@Entity
public class UserProfileModel {
    @Id
    @GeneratedValue
    private long id;
    /** 用户id */
    private String userId;
    /** 用户省份 */
    private String provice;
    /** 用户城市 */
    private String city;
    /** 性别 */
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.MALE;
    /** 星座 */
    @Enumerated(EnumType.STRING)
    private Constellation constellation;
    /** 年龄 */
    private int age = 18;

    private String profession;

    public UserProfileModel() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
