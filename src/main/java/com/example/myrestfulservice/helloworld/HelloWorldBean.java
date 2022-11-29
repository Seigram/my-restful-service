package com.example.myrestfulservice.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok set get auto
@Data
@AllArgsConstructor//auto contrctor
@NoArgsConstructor
public class HelloWorldBean {
    private String message; //lombok getter setter
}
