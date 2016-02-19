package com.galeapp.service;

import java.util.List;

import com.galeapp.model.Nomination;
import com.galeapp.model.Person;

public interface NominateService {
	public void createNomination(Nomination n);
	public List<Nomination> listNominations();
    public void updateNomination(Nomination p);
    public Nomination getNominationById(int id);
    public void removeNomination(int id);
}
