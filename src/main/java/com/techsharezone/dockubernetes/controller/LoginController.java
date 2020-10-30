package com.techsharezone.dockubernetes.controller;

/*
 * @created 29/10/2020 -19:01
 * @project dockubernetes-spring-boot
 * @author  saurabhshcs
 */


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    
    @RequestMapping("/login")
    public  String login(){
        return " You've logged in successfully...";
    }
    
}
