package com.eagle.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eagle.entity.Category;

@Service
@Transactional
@Repository
public class CategoryService {

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Category> getAllCategories(){
		
		Session session = sessionFactory.getCurrentSession();
	Query<Category> query = session.createQuery("from Category");
		return query.getResultList();
	}
	
	public Category getCategory(int categoryId) {
Session session = sessionFactory.getCurrentSession();
		
		Category category = session.get(Category.class, categoryId);
		return category;
	}
}
