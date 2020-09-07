package com.eagle.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eagle.entity.Brand;

@Service
@Repository
@Transactional
public class BrandService {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Brand> getAllBrands(){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Brand> query = session.createQuery("from Brand", Brand.class);
		List allBrands = query.getResultList();
		
		return allBrands;
	}
	
	public Brand getBrand(int brandId) {

		Session session = sessionFactory.getCurrentSession();
		
		Brand brand = session.get(Brand.class, brandId);
		return brand;
	}



}
