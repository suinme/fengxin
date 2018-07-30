package me.zurex.fengxin.domain.user;

/**
 * @author zurex
 * @date 2018/7/26
 * Make life more fun
 */
public enum Constellation {
    AQUARIUS("水瓶座"),
    CANCER("巨蟹座"),
    ;

    private String name;

    Constellation(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
