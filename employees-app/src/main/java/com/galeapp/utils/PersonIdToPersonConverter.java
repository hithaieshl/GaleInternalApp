package com.galeapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.galeapp.model.Person;
import com.galeapp.service.PersonService;

public class PersonIdToPersonConverter implements Converter<String, Person> {

		@Autowired
		PersonService personService;

		@Override
		public Person convert(final String personIdStr) {
		    return personService.getPersonById(Integer.parseInt(personIdStr));
		}

	
}
