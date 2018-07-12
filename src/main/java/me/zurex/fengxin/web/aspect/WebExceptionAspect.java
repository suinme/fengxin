package me.zurex.fengxin.web.aspect;

import me.zurex.fengxin.web.base.ApiResponse;
import me.zurex.fengxin.web.base.BaseStatus;
import me.zurex.fengxin.web.util.ApiResponseBuilder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 */
@Aspect
public class WebExceptionAspect {
    private static final Logger LOG = LoggerFactory.getLogger(WebExceptionAspect.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void webPointcut() {}

    /**
     * 拦截web层异常，记录异常日志，并返回友好信息到前端
     * 目前只拦截Exception，是否要拦截Error需再做考虑
     *
     * @param e 异常对象
     */
    @AfterThrowing(pointcut = "webPointcut()", throwing = "e")
    public ApiResponse handleThrowing(Exception e) {
        LOG.error(ExceptionUtils.getStackTrace(e));
        return ApiResponseBuilder.buildErrorResponse(BaseStatus.ERROR, e.getMessage());
    }
}
