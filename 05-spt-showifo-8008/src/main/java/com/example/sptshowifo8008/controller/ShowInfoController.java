package com.example.sptshowifo8008.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

/**
 * date： 2023/11/7
 * time： 07:05
 * author： cris
 * description：
 **/

@RestController
@RequestMapping("/info/")
public class ShowInfoController {

    @GetMapping("/header")
    public String headerHandle(HttpServletRequest request, ServerHttpRequest request1){
        Enumeration<String> headers = request.getHeaders("X-Request-Color");
        StringBuilder sb = new StringBuilder();
        while (headers.hasMoreElements()){
            sb.append(headers.nextElement() + " ");
        }
        return "X-Request-Color:" + sb.toString();
    }

    @GetMapping("/headers")
    public String headersHandle(HttpServletRequest request){
        // 获取所有 header 的 key
        Enumeration<String> headersKey = request.getHeaderNames();
        StringBuilder sb = new StringBuilder();
        while (headersKey.hasMoreElements()){
            String name = headersKey.nextElement();
            sb.append(name + ":");
            Enumeration<String> headersVal = request.getHeaders(name);
            while (headersVal.hasMoreElements()){
                sb.append(headersVal.nextElement() + " ");
            }
        }
        return sb.toString();
    }


    @GetMapping("/time")
    public String timeHandle(){
        return "到达时间" + System.currentTimeMillis();
    }
}
