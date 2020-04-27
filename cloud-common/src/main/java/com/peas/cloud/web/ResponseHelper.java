package com.peas.cloud.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by niejiuqian on 2017/9/13.
 */
public class ResponseHelper {


    /**
     * 直接输出文本
     * @param response
     * @param resultBody
     */
    public static void writeText(HttpServletResponse response, String resultBody) {
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Pragma", "No-com.pay.common.cache");
        response.setHeader("Cache-Control", "no-com.pay.common.cache");
        response.setHeader("Access-Control-Allow-Origin","*");
        int length = 0;
        try {
            byte[] bytes = resultBody.getBytes("utf-8");
            length = bytes.length;
            response.setHeader("Content-Length", length + "");
            response.setDateHeader("Expires", 0);
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(resultBody);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 直接输出页面
     * @param response
     * @param resultBody
     */
    public static void writeHtml(HttpServletResponse response, String resultBody) {
        response.setContentType("text/html; charset=UTF-8");
        try {
            response.getWriter().write(resultBody);
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
