package com.example.client.controller;

import com.example.client.entity.User;
import com.example.client.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserRepository repository;

  @Value("${user.username}")
  private String username;

  @GetMapping("test")
  public ResponseEntity<String> test() {
    return ResponseEntity.ok().body(username);
  }

  @PostMapping("create")
  public ResponseEntity<User> create(@RequestBody User user){
    return ResponseEntity.ok().body(repository.save(user));
  }
}
