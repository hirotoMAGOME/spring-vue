package hm.springapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hm.springapi.dao.entity.User;
import hm.springapi.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<UserResponse> findAll() {
        List<User> users = userService.findAll();
        UserResponse userResponse = UserResponse.builder()
                .users(users)
                .build();
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    
}