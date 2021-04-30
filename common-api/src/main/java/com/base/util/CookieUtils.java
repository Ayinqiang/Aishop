package com.base.util;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author ppMaster
 * @Date 2021-4-29
 * @Description: Cookie相关操作工具包
 */
@Slf4j
public class CookieUtils {

    //日志工具
    private static final Logger LOGGER = LoggerFactory.getLogger(CookieUtils.class);

    private CookieUtils() {
    }

    /**
     *
     * @param request 请求对象
     * @param response 响应对象
     * @param name cookie名字
     * @param value cookie value
     * @param path cookie 作用 path
     * @param domain cookie 作用域
     * @param maxAge Cookie失效的时间，单位秒。如果为整数，则该Cookie在maxAge秒后失效。
     *               如果为负数，该Cookie为临时Cookie，
     *               关闭浏览器即失效，浏览器也不会以任何形式保存该Cookie。如果为0，表示删除该Cookie。默认为-1。
     * @param secure 该Cookie是否仅被使用安全协议传输。
     *               安全协议。安全协议有HTTPS，SSL等，在网络上传输数据之前先将数据加密。
     *               默认为false。
     */
    public static void addCookie(HttpServletRequest request,
                                 HttpServletResponse response,
                                 String name,
                                 String value,
                                 String path,
                                 String domain,
                                 Boolean secure,
                                 Integer maxAge) {
        //判断 为不能为空值是否为空
        Assert.notNull(response, "HttpServletResponse不允许为null");
        Assert.notNull(request, "HttpServletRequest不允许为null");
        Assert.notNull(name, "Cookies 字段 name 不允许为null");

        //cookie生成
        try{
            name = URLEncoder.encode(name,"UTF-8");
            value = URLEncoder.encode(value,"UTF-8");
            Cookie cookie = new Cookie(name,value);
            //cookie需求定制化
            if(maxAge !=null) cookie.setMaxAge(maxAge.intValue());
            if(!Strings.isNotBlank(path)&&!Strings.isNotEmpty(path)) cookie.setPath(path);
            if(!Strings.isNotBlank(domain)&&!Strings.isNotEmpty(domain)) cookie.setDomain(domain);
            if(secure !=null) cookie.setSecure(secure.booleanValue());
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Cookie 添加出现错误");
        }
    }

    //生成Cookie方式一
    public static void addCookie(HttpServletRequest request,
                                 HttpServletResponse response,
                                 String name,
                                 String value,
                                 Integer maxAge){
        addCookie(request,response,name,value,"/",null,false,maxAge);
    }

    //生成Cookie方式二
    public static void addCookie(HttpServletRequest request,
                                 HttpServletResponse response,
                                 String name,
                                 String value
                                 ){
        addCookie(request,response,name,value,"/",null,false,null);
    }

    public static String getCookie(HttpServletRequest request,String name){
        AssertUtils.notNullPrintType(request);
        org.springframework.util.Assert.hasText(name);
        Cookie[] cookies = request.getCookies();
        if(cookies !=null)
            try {
                name = URLEncoder.encode(name,"UTF-8");
                for(Cookie c : cookies){
                    if(c.getName().equals(name)){
                        return URLDecoder.decode(c.getValue(),"UTF-8");
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        return null;
    }

    //删除Cookie
    public static void removeCookie(HttpServletRequest request,
                                    HttpServletResponse response,
                                    String name,
                                    String path,
                                    String domain){
        AssertUtils.notNullPrintType(request);
        AssertUtils.notNullPrintType(response);
        org.springframework.util.Assert.hasText(name);
        try{
            name = URLEncoder.encode(name,"UTF-8");
            Cookie cookie = new Cookie(name,null);
            if(!Strings.isNotEmpty(path)&&!Strings.isNotBlank(path))
                cookie.setPath(path);
            if(!Strings.isNotEmpty(domain)&&!Strings.isNotBlank(domain))
                cookie.setPath(domain);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("删除cookie出错");
        }
    }

    public static void removeCookie(HttpServletRequest request,
                                    HttpServletResponse response,
                                    String name){
        removeCookie(request, response, name, "/", null);
    }
}
