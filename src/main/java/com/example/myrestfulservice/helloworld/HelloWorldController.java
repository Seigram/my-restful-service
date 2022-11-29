package com.example.myrestfulservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //Get
    // /hello-world (endpoint)
    @GetMapping(path = "/hello-world")
    public String helloWord(){
        return "Hello world";
    }
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello world");//class -> json format
    }
    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

}
