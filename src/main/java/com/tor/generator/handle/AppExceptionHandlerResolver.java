package com.tor.generator.handle;

import com.peas.cloud.exception.AppException;
import com.peas.cloud.util.KeepJsonUtil;
import com.peas.cloud.util.WebUtil;
import com.peas.cloud.web.JsonResponse;
import com.peas.cloud.web.ResponseHeader;
import com.peas.cloud.web.ResponseHelper;
import com.peas.cloud.web.StandardResponseHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


/**
 * Created by soya on 2017/9/15.
 * 统一异常处理
 */
@Component
public class AppExceptionHandlerResolver implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(com.peas.cloud.handle.AppExceptionHandlerResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        JsonResponse jsonResponse = null;
        if (null != ex) {
            logger.error(ex.getMessage(),ex);
            if (ex instanceof AppException) {
                AppException appException = (AppException)ex;
                ResponseHeader responseHeader = null;
                if (appException.getResponseHeader() != null) {
                    responseHeader = appException.getResponseHeader();
                } else {
                    responseHeader = StandardResponseHeader.ERROR;
                }
                jsonResponse = WebUtil.errorJsonResponseCustomMsg(appException.getMessage(),responseHeader);
            }else if (ex instanceof SQLException
                    || ex instanceof NullPointerException){
                //数据库异常，直接返回系统错误，不然返回一堆英文提示，客户又看不懂
                jsonResponse = WebUtil.errorJsonResponse(StandardResponseHeader.ERROR.getDescription());
            } else {
                jsonResponse = WebUtil.errorJsonResponse(ex.getMessage());
            }
        }else {
            jsonResponse = WebUtil.errorJsonResponse(StandardResponseHeader.ERROR);
        }
        String resultJson = KeepJsonUtil.beanToJson(jsonResponse);
        logger.info(" \n返回客户端json :{} ", resultJson);
        ResponseHelper.writeText(response, resultJson);
        return new ModelAndView();
    }
}
