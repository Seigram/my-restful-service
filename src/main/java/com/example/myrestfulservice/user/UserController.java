package com.example.myrestfulservice.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    //spring에서 선언되어 관리되고 있는 인스턴스: Bean
    private UserDaoService service;

    public UserController(UserDaoService service){
        this.service = service;
        //의존성 주입
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build(); //created Response 목적에 맞게 상태코드로 리턴해주는 것이 중요
    }

    @DeleteMapping ("/users/{id}")
    public void deleteUser(@PathVariable int id){
            User user = service.deleteById(id);
            if(user == null){
                throw new UserNotFoundException(String.format("ID[%s] not found",id));
            }
    }




}
