package com.eagle.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eagle.entity.Bill;

@Transactional
@Repository
@Service
public class BillService {



	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Bill> getAllBills(){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Bill> query = session.createQuery("from Bill", Bill.class);
		List allBills = query.getResultList();
		
		return allBills;
	}
	
	public Bill getBill(int billId) {

		Session session = sessionFactory.getCurrentSession();
		
		Bill bill = session.get(Bill.class, billId);
		return bill;
	}




}
