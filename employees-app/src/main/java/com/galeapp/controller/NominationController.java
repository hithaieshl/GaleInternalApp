package com.galeapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.galeapp.model.Nomination;
import com.galeapp.model.Person;
import com.galeapp.service.NominateService;
import com.galeapp.service.PersonService;
import com.galeapp.views.nominateView;


@Controller
public class NominationController {
	
    private NominateService nominateService;
    private PersonService personService;
    
	@Autowired(required=true)
    @Qualifier(value="nominateService")
    public void setPersonService(NominateService ns){
        this.nominateService = ns;
    }
	
	@Autowired(required=true)
    @Qualifier(value="personService")
    public void setPersonService(PersonService ps){
        this.personService = ps;
    }

	@RequestMapping(value = "/nominate", method = RequestMethod.GET)
    public String listPersons(Model model) {
       model.addAttribute("nominateView", new nominateView());

		
        return "nominationForm";
    }
	
	@RequestMapping(value = "/nominations", method = RequestMethod.GET)
    public String listNominations(Model model) {
		
       model.addAttribute("nominateView", new nominateView());
       
       List<Nomination> nominationList = this.nominateService.listNominations();
       List<nominateView> nominationsViewList = new ArrayList<nominateView>();
       for(Nomination n : nominationList)
       {
    	   nominateView nv = new nominateView();
    	   nv.setId(n.getId());
    	   nv.setNomineePerson(this.personService.getPersonById(Integer.parseInt(n.getNomineePersonId())));
    	   nv.setCoreValue(n.getCoreValue());
    	   nv.setComments(n.getComments());
    	   nominationsViewList.add(nv);
       }
       model.addAttribute("nominationsViewList", nominationsViewList);
		
        return "nominations";
    }
	
	@RequestMapping(value= "/nominate/create", method = RequestMethod.POST)
    public String createNomination(WebRequest webRequest){
        
		Map<String, String[]> params = webRequest.getParameterMap();
		
		String[] actionArr = params.get("action");
		if(actionArr != null && actionArr[0] != null && !actionArr[0].equalsIgnoreCase("cancel"))
		{
			
			String[] idArr = params.get("id");
			int nominateId = 0;
			if(idArr != null & idArr[0] != null)
			{
				nominateId = Integer.parseInt(idArr[0]);
			}
			if(nominateId == 0)
			{
				Nomination n = new Nomination();
			    populateNomination(webRequest, n);
			    //new nomination, call create
				this.nominateService.createNomination(n);
			}
			else
			{
				Nomination n = this.nominateService.getNominationById(nominateId);
				populateNomination(webRequest, n);
				//existing person, call update
				this.nominateService.updateNomination(n);
			}
		}
        return "redirect:/nominations";
         
    }
	
	private Nomination populateNomination(WebRequest webRequest, Nomination n)
	{
		Map<String, String[]> params = webRequest.getParameterMap();
		String[] nomineePersonIdArr = params.get("nomineePersonId");
		
		if(nomineePersonIdArr != null && nomineePersonIdArr[0] != null)
		{
			n.setNomineePersonId(nomineePersonIdArr[0]);
		}
				
		String[] coreValueArr = params.get("coreValue");
		if(coreValueArr != null && coreValueArr[0] != null)
		{
			n.setCoreValue(coreValueArr[0]);
		}
		
		String[] commentsArr = params.get("comments");
		if(commentsArr != null && commentsArr[0] != null)
		{
			n.setComments(commentsArr[0]);
		}
		
		String[] actionArr = params.get("action");
		if(actionArr != null && actionArr[0] != null)
		{
			if(actionArr[0].equalsIgnoreCase("submit"))
			{
				n.setSubmitted(true);
			}
		}
		
		n.setNominatorPersonId("1");
		
		return n;
	}
	
	@ModelAttribute("coreValuesMap")
	public Map<String,String> getCoreValue()
	{
		Map<String,String> coreValuesMap = new HashMap<String,String>();
		coreValuesMap.put("India", "India");
		coreValuesMap.put("Australia", "Australia");
		coreValuesMap.put("England", "England");
		return coreValuesMap;
	}
	
	@ModelAttribute("personsMap") 
	 public Map<String,String> populatePersonsList() {
	        Map<String,String> personsMap = new HashMap<String,String>();
	        List<Person> personServiceList = this.personService.listPersons();
	        for(Person p : personServiceList)
	        {
	        	personsMap.put(Integer.toString(p.getId()), p.getName());
	        }
             
	        return personsMap;
	    }
	
	@RequestMapping("/nominate/remove/{id}")
    public String removeNomination(@PathVariable("id") int id){
         
        this.nominateService.removeNomination(id);
        return "redirect:/nominations";
    }
  
    @RequestMapping("/nominate/edit/{id}")
    public String editNomination(@PathVariable("id") int id, Model model){
        model.addAttribute("nomination", this.nominateService.getNominationById(id));
        return "nominationForm";
    }
}
