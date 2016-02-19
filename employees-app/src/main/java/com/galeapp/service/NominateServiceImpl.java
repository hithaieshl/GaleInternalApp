package com.galeapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galeapp.dao.NominateDAO;
import com.galeapp.model.Nomination;
import com.galeapp.model.Person;

@Service
public class NominateServiceImpl implements NominateService{
	
	private NominateDAO nominateDAO;
	 
    public void setNominateDAO(NominateDAO nominateDAO) { 
        this.nominateDAO = nominateDAO;
    }
    
	@Override
    @Transactional
    public void createNomination(Nomination n) {
        this.nominateDAO.createNomination(n);
    }
    
    @Override
    @Transactional
    public void updateNomination(Nomination n) {
        this.nominateDAO.updateNomination(n);
    }
    
    @Override
    @Transactional
    public List<Nomination> listNominations() {
        return this.nominateDAO.listNominations();
    }
 
    @Override
    @Transactional
    public Nomination getNominationById(int id) {
        return this.nominateDAO.getNominationById(id);
    }
 
    @Override
    @Transactional
    public void removeNomination(int id) {
        this.nominateDAO.removeNomination(id);
    }
}
