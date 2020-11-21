package hm.springapi.controller;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.User;

@Getter
@Builder
public class UserResponse {

    private List<User> users;
}