package hm.springapi.controller;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.User;

import java.util.List;

@Getter
@Builder
public class UserResponse {

    private List<User> users;
}