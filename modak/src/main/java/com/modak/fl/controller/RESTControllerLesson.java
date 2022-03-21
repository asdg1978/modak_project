package com.modak.fl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modak.fl.model.Lesson;

import io.swagger.annotations.Api;

@Api(value = "/api/lesson")
@RestController
@RequestMapping(value = "/lesson")
public class RESTControllerLesson extends RESTControllerGeneric<Lesson>{






}
