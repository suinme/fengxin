package me.zurex.fengxin.web.base;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 */
public enum BaseStatus implements ApiResponseStatus{
    OK(){
        @Override
        public int getCode() {
            return 0;
        }

        @Override
        public String getMessage() {
            return "ok";
        }
    },
    ERROR(){
        @Override
        public int getCode() {
            return -1;
        }

        @Override
        public String getMessage() {
            return "error";
        }
    }
}
