package com.modak.fl.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.modak.fl.dao.DAOUser;
import com.modak.fl.exception.ExceptionDAO;
import com.modak.fl.exception.ExceptionService;
import com.modak.fl.model.User;
import com.modak.fl.security.UserDetailsImpl;

/**
 *
 */
@Service
public class ServiceUser extends ServiceGeneric < User > implements UserDetailsService {

	@Autowired
	DAOUser daoUser;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {

			User u = daoUser.findByUsername(username);
			return UserDetailsImpl.build(u);
		} catch (ExceptionDAO e) {
			logger.error("ERROR - Operation:findByUsername - Entity:"+super.getDomainClass()+" - "+" - code: "+e.getErrorCode()+" - message"+e.getErrorMessage());
            throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
	}

	public boolean existsByUsername(String username) throws UsernameNotFoundException {
		try {
			return daoUser.existsByUsername(username);

		} catch (ExceptionDAO e) {
			logger.error("ERROR - Operation:findByUsername - Entity:"+super.getDomainClass()+" - "+" - code: "+e.getErrorCode()+" - message"+e.getErrorMessage());
            throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
	}

	public Serializable save(final User o) throws ExceptionService {
        try {
            return this.daoUser.save(o);
        } catch (ExceptionDAO e) {
        	logger.error("ERROR - Operation:save - Entity:User -  code:"+e.getErrorCode()+" - message"+e.getErrorMessage());
            throw new ExceptionService(e);
        }
    }


}
