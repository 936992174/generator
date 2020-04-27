package com.peas.cloud.handle;
import com.peas.cloud.web.MyRequestWrapper;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by niejiuqian on 2017/10/19.
 */
public class RequestBodyReadFilter implements Filter {
    private static String[] CONTENT_TYPES = {"multipart/form-data"};
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!isPass(request)){
            MyRequestWrapper requestWrapper = new MyRequestWrapper((HttpServletRequest) request);
            chain.doFilter(requestWrapper, response);
        }else {
            chain.doFilter(request,response);
        }
    }

    private boolean isPass(ServletRequest request){
        //如果是urule服务器后台的请求，走chain.doFilter(request,response);
        //if(request.get){} return true;
        StringBuffer requestURL = ((HttpServletRequest) request).getRequestURL();
        if(!StringUtils.isEmpty(requestURL)){
            if(requestURL.toString().contains("/urule/")){
                return true;
            }
        }
        String contentType = request.getContentType();
        if (StringUtils.isEmpty(contentType)){ return false; }
        for (int i = 0; i < CONTENT_TYPES.length; i++) {
            String type = CONTENT_TYPES[i];
            if (contentType.contains(type)) {return true;}
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
