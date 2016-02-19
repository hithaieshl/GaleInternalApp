package com.galeapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.galeapp.model.Nomination;
import com.galeapp.model.Person;

public class NominateDAOImpl implements NominateDAO {

	 private static final Logger logger = LoggerFactory.getLogger(NominateDAOImpl.class);
	 
	    private SessionFactory sessionFactory;
	     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	    
	@Override
    public void createNomination(Nomination n) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(n);
        logger.info("Person saved successfully, Person Details="+n);
    }
	
	@Override
    public void updateNomination(Nomination n) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(n);
        logger.info("Person updated successfully, Person Details="+n);
    }
	
    @SuppressWarnings("unchecked")
    @Override
    public List<Nomination> listNominations() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Nomination> nominationList = session.createQuery("from Nomination").list();
        for(Nomination p : nominationList){
            logger.info("Person List::"+p);
        }
        return nominationList;
    }
    
    @Override
    public Nomination getNominationById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Nomination n = (Nomination) session.load(Nomination.class, new Integer(id));
        logger.info("Person loaded successfully, Person details="+n);
        return n;
    }
 
    @Override
    public void removeNomination(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Nomination n = (Nomination) session.load(Nomination.class, new Integer(id));
        if(null != n){
            session.delete(n);
        }
        logger.info("Person deleted successfully, person details="+n);
    }
}
