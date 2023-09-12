package com.example.securingweb.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@RestController
public class LoginController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome.html";
    }

    @GetMapping("/admin")
    public String user() {
        return "admin.html";
    }

    @GetMapping("/basic")
    @CrossOrigin(origins = {"http://localhost:8080"},
            allowCredentials = "true",
            allowedHeaders = {"*"}
    )
    public String basic() {
        return "basic.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/testapi")
    public String testapi() {
        return "success-test-api";
    }


    @PostMapping("/cbo-cookies")
    @CrossOrigin(origins = {"http://localhost:8080"},
            allowCredentials = "true",
            allowedHeaders = {"*"}
    )
    public CboCookies retrieveCbCookies(@RequestHeader final Map<String,String> headers, HttpServletRequest httpServletRequest) {

       final String cookies = headers.get("cookie");

        System.out.println("Cookies found in HTTP Servlet :-->  "+httpServletRequest.getCookies());

        System.out.println("Cookies found in Map :-->  "+cookies);
       if(cookies==null){
           return new CboCookies("No Cookies found");
       }
       final String[] cookiesList = cookies.split(";");
        return new CboCookies(Arrays.toString(cookiesList));

    }
}
