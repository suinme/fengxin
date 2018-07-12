package me.zurex.fengxin.web.util;

import me.zurex.fengxin.web.base.ApiResponse;
import me.zurex.fengxin.web.base.ApiResponseStatus;
import me.zurex.fengxin.web.base.BaseStatus;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 */
public class ApiResponseBuilder {
    public static ApiResponse buildSuccessResponse(Object result){
        return new ApiResponse(BaseStatus.OK, result);
    }

    public static ApiResponse buildErrorResponse(ApiResponseStatus status, Object result){
        return new ApiResponse(status, result);
    }
}
