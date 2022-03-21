package com.modak.fl.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.modak.fl.model.Friend;

@Repository
public class DAOFriend extends DAOGeneric<Friend>{

	public DAOFriend(SessionFactory sessionFactory) {
        super(sessionFactory);
    }




}
