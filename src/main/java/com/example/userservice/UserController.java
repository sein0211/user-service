package com.example.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate template;

    @GetMapping("/user/ribbon/{data}")
    public String invokePaymentService(@PathVariable int data) {
        return template.getForObject("http://ORDER-SERVICE/order/" + data, String.class);
    }

    @GetMapping("/user/info")
    public String info(@Value("${server.port}") String port) {
        return "User 서비스의 기본 동작 Port: {" + port + "}";
    }
}
