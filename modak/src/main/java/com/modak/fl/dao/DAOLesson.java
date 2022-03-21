package com.modak.fl.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.modak.fl.model.Lesson;

@Repository
public class DAOLesson extends DAOGeneric<Lesson>{

	public DAOLesson(SessionFactory sessionFactory) {
        super(sessionFactory);
    }




}
