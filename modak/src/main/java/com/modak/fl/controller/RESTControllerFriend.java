package com.modak.fl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modak.fl.model.Friend;

import io.swagger.annotations.Api;

@Api(value = "/api/friend")
@RestController
@RequestMapping(value = "/fried")
public class RESTControllerFriend extends RESTControllerGeneric<Friend>{






}
