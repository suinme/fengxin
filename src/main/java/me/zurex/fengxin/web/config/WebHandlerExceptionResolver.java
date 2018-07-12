package me.zurex.fengxin.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.zurex.fengxin.web.base.ApiResponse;
import me.zurex.fengxin.web.base.BaseStatus;
import me.zurex.fengxin.web.util.ApiResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 */
@Component
public class WebHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {


        // 视图显示专门的错误页
        ModelAndView modelAndView = new ModelAndView();
        /*  使用response返回    */
        //设置状态码
        response.setStatus(HttpStatus.OK.value());
        //设置ContentType
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        //避免乱码
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            ApiResponse result = ApiResponseBuilder.buildErrorResponse(BaseStatus.ERROR, ex.getMessage());
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(result));
        } catch (IOException e) {
            //L.error("与客户端通讯异常:"+ e.getMessage(), e);
        }
        return modelAndView;
    }
}
