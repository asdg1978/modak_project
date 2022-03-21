package com.modak.fl.controller;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.modak.fl.exception.ExceptionService;
import com.modak.fl.model.BaseModel;
import com.modak.fl.service.ServiceFriend;
import com.modak.fl.service.ServiceGeneric;
import com.modak.fl.service.ServiceLesson;
import com.modak.fl.service.ServiceUser;
import com.modak.fl.utils.Constants;

import io.swagger.annotations.ApiOperation;

public abstract class RESTControllerGeneric < T extends BaseModel > {

  final public Logger logger = Logger.getLogger(this.getClass());

  @Autowired
  public HttpServletRequest request;

  @Autowired
  public HttpServletResponse response;

  @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
  private ServiceGeneric service;

  @Autowired
  private ServiceUser serviceUser;

  @Autowired
  private ServiceFriend serviceFriend;

  @Autowired
  private ServiceLesson serviceLesson;



  @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
  Map < String,
  ServiceGeneric > serviceMap;

  @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
  private void loadServices() {
    serviceMap = new HashMap < String, ServiceGeneric > ();
    serviceMap.put(Constants.ENTITY_USER, this.serviceUser);
    serviceMap.put(Constants.ENTITY_FRIEND, this.serviceFriend);
    serviceMap.put(Constants.ENTITY_LESSON, this.serviceLesson);

  }

  private void findService(T request) {
    //if (this.serviceMap == null) {
      loadServices();
    //s}
    this.service = serviceMap.get(getDomainClass().getName());
  }

  @SuppressWarnings("unchecked")
  public Class < T > getDomainClass() {
    ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
    return (Class < T > ) thisType.getActualTypeArguments()[0];
  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Creacioin de una unidad", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
  protected ResponseEntity < BaseModel > create(@RequestBody T request, @RequestHeader HttpHeaders httpHeaders) throws ExceptionService {
    findService(request);
    request.setId((Long) service.save(request));
    return ResponseEntity.ok((BaseModel) request);
  }

  @ApiOperation(value = "Elimina una unidad", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
  @DeleteMapping("/delete/")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@RequestBody T request, @RequestHeader HttpHeaders headers) throws ExceptionService {
    findService(request);
    service.delete(request);
  }

  @ApiOperation(value = "Modificar una unidad", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
  @PutMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public void update(@RequestBody T request, @RequestHeader HttpHeaders httpHeaders) throws ExceptionService {
    findService(request);
    service.update(request);
  }

  @SuppressWarnings(Constants.SuppressWarnings_Unchecked)
  @ApiOperation(value = "Obtiene una unidad mediante un id", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
  @GetMapping("/id/")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity < BaseModel > getById(@RequestBody T request, @RequestHeader HttpHeaders headers) throws ExceptionService {
    findService(request);
    return ResponseEntity.ok((BaseModel) service.getById(request));
  }


}