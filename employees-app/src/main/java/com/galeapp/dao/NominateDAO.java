package com.galeapp.dao;

import java.util.List;

import com.galeapp.model.Nomination;
import com.galeapp.model.Person;

public interface NominateDAO {
	
	public void createNomination(Nomination n);
	public List<Nomination> listNominations();
    public void updateNomination(Nomination n);
    public Nomination getNominationById(int id);
    public void removeNomination(int id);
}
