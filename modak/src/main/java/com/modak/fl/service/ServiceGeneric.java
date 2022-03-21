package com.modak.fl.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.modak.fl.dao.DAOFriend;
import com.modak.fl.dao.DAOGeneric;
import com.modak.fl.dao.DAOLesson;
import com.modak.fl.dao.DAOUser;
import com.modak.fl.exception.ExceptionDAO;
import com.modak.fl.exception.ExceptionService;
import com.modak.fl.model.BaseModel;
import com.modak.fl.utils.Constants;



/**
 * Representa un servicio generico.
 * @param <T> generica
 */
public abstract class ServiceGeneric < T > {


    @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
    private Map < String, DAOGeneric > daoMap;

    @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
    private DAOGeneric dao;

    @Autowired
    private DAOUser daoUser;

    @Autowired
    private DAOFriend daoFriend;

    @Autowired
    private DAOLesson daoLesson;


    private Class < T > domainClass;

    final public Logger logger = Logger.getLogger(this.getClass());

    @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
    private void loadDaos() {
        this.daoMap = new HashMap < String, DAOGeneric > ();
        this.daoMap.put(Constants.ENTITY_USER, this.daoUser);
        this.daoMap.put(Constants.ENTITY_FRIEND, this.daoFriend);
        this.daoMap.put(Constants.ENTITY_LESSON, this.daoLesson);

    }


    @SuppressWarnings(Constants.SuppressWarnings_Unchecked)
    public T getById(final T entity) throws ExceptionService {
        findDAO();
        try {
            return (T) this.dao.get(((BaseModel) entity).getId());
        } catch (ExceptionDAO e) {
        	logger.error("ERROR - Operation:getById - Entity:"+domainClass+" - "+" - code: "+e.getErrorCode()+" - message"+e.getErrorMessage());
            throw new ExceptionService(e);
        }
    }

    @SuppressWarnings(Constants.SuppressWarnings_Unchecked)
    public List < T > find(final String hql, final Object...params) throws ExceptionService {
        findDAO();
        try {
            return this.dao.find(hql, params);
        } catch (ExceptionDAO e) {
        	logger.error("ERROR - Operation:find - Entity:"+domainClass+" - "+" - code: "+e.getErrorCode()+" - message"+e.getErrorMessage());
            throw new ExceptionService(e);
        }
    }

    @SuppressWarnings(Constants.SuppressWarnings_Unchecked)
    public List < T > list() throws ExceptionService {
        findDAO();
        try {
            return this.dao.list();
        } catch (ExceptionDAO e) {
        	logger.error("ERROR - Operation:list - Entity:"+domainClass+" - "+" - code: "+e.getErrorCode()+" - message"+e.getErrorMessage());
            throw new ExceptionService(e);
        }
    }

    public Serializable save(final Object o) throws ExceptionService {
        findDAO();
        try {
            return this.dao.save(o);
        } catch (ExceptionDAO e) {
        	logger.error("ERROR - Operation:save - Entity:"+domainClass+" - "+" - code: "+e.getErrorCode()+" - message"+e.getErrorMessage());
            throw new ExceptionService(e);
        }
    }

    public void update(final Object o) throws ExceptionService {
        findDAO();
        try {
        	this.dao.update(o);
        } catch (ExceptionDAO e) {
        	logger.error("ERROR - Operation:update - Entity:"+domainClass+" - "+" - code: "+e.getErrorCode()+" - message"+e.getErrorMessage());
        	throw new ExceptionService(e);
        }
    }

    public void delete(final Object o) throws ExceptionService {
        findDAO();
        try {
            this.dao.delete(o);
        } catch (ExceptionDAO e) {
        	logger.error("ERROR - Operation:delete - Entity:"+domainClass+" - "+" - code: "+e.getErrorCode()+" - message"+e.getErrorMessage());
            throw new ExceptionService(e);
        }
    }

    private void findDAO() throws ExceptionService {
      //  if (this.daoMap == null) {
            loadDaos();
            this.dao = this.daoMap.get(getDomainClass().getName());
      //  }
    }

    @SuppressWarnings(Constants.SuppressWarnings_Unchecked)
    public Class < T > getDomainClass() {
        if (this.domainClass == null) {
            final ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            this.domainClass = (Class < T > ) thisType.getActualTypeArguments()[0];
        }
        return this.domainClass;
    }

}
