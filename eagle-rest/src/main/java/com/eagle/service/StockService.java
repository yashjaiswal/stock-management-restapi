package com.eagle.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eagle.entity.Stock;

@Service
@Transactional
@Repository
public class StockService {

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Stock> getAllStocks(){
		
		Session session = sessionFactory.getCurrentSession();
		Query<Stock> query = session.createQuery("from Stock");
		return query.getResultList();
	}
	
	public List<Stock> getStockSingleBrand(int brandId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Stock> query = session.createQuery("from Stock where brandId="+brandId);
		return query.getResultList();
	}
}
