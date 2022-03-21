package com.modak.fl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modak.fl.model.User;

import io.swagger.annotations.Api;

@Api(value = "/api/user")
@RestController
@RequestMapping(value = "/api/user")
public class RESTControllerUser extends RESTControllerGeneric<User>{


}
