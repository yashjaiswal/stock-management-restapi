package com.eagle.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eagle.entity.Purchase;

@Transactional
@Repository
@Service
public class PurchaseService {


	@Autowired
	SessionFactory sessionFactory;

	public List<Purchase> getPurchaseByBill(int billId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Purchase> query = session.createQuery("from Purchase where billId="+billId);
		return query.getResultList();
	}


}
