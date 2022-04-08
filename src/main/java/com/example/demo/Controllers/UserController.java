package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private final Map<Integer, UserEntity> entityMap = new HashMap<>();

    @ResponseBody
    @GetMapping("/users")
    public List<UserEntity> findAll() {
        return new ArrayList<>(entityMap.values());
    }

    @ResponseBody
    @GetMapping("/users/{id}/get")
    public UserEntity findUserById(@PathVariable int id) {
        return entityMap.get(id);
    }

    @ResponseBody
    @GetMapping("/users/{id}/remove")
    public UserEntity deleteUserById(@PathVariable int id) {
        return entityMap.remove(id);
    }

    @ResponseBody
    @GetMapping("/user/add")
    public int id(@RequestParam String name, @RequestParam int age) {
        UserEntity entity = new UserEntity(name, age);
        return addToMap(entity);
    }

    private int addToMap(UserEntity entity) {
        int key = entityMap.keySet()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);
        entityMap.put(++key, entity);
        return key;
    }
}