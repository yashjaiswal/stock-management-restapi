package com.eagle.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eagle.entity.Distributor;

@Service
@Repository
@Transactional
public class DistributorService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Distributor> getAllDistributors(){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Distributor> query = session.createQuery("from Distributor", Distributor.class);
		List allDistributors = query.getResultList();
		
		return allDistributors;
	}
	
	public Distributor getDistributor(int distributorId) {

		Session session = sessionFactory.getCurrentSession();
		
		Distributor distributor = session.get(Distributor.class, distributorId);
		return distributor;
	}

}
