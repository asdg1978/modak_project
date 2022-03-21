package com.modak.fl.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.modak.fl.exception.ExceptionDAO;
import com.modak.fl.model.User;

@Repository
public class DAOUser extends DAOGeneric<User>{


	public DAOUser(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

	public User findByUsername(String  userName)throws ExceptionDAO{
	User user = null;
		try{
			  strQuery = "FROM User u  WHERE u.userName = :userName";
			  query = getSession().createQuery(strQuery);
			  query.setParameter("userName", userName);
			  List<User> result =  query.getResultList();
			  if(result!=null && result.size()>0) {
				  user = result.get(0);
			  }
	         }catch(Exception e){
			  throw new ExceptionDAO(e);
		  }
		return user;
	}


	public boolean existsByUsername(String username) throws ExceptionDAO {
		User user = this.findByUsername(username);
		if(user!=null && user.getUserName().equals(username) ){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public Serializable save(final User o) throws ExceptionDAO {
        try {
            return super.save(o);
        } catch (ExceptionDAO e) {
        	//logger.error("ERROR - Operation:save - Entity:User -  code:"+e.getErrorCode()+" - message"+e.getErrorMessage());
            throw new ExceptionDAO(e);
        }
    }


}
