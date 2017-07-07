package com.example.onetomany.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.onetomany.model.Child;
import com.example.onetomany.model.Parent;
import com.example.onetomany.repo.ChildRepo;
import com.example.onetomany.repo.ParentRepo;

@Controller
public class OneToOneController {
	private final ParentRepo pr;
	private final ChildRepo cr;
	
	@Autowired
	OneToOneController(ParentRepo pr,ChildRepo cr){
		this.pr = pr;
		this.cr = cr;
	}
	
	@RequestMapping("/otm")
	@ResponseBody
	public List<Parent> otm(){
		List<Parent> list = pr.findAll(); 
		System.out.println(list.size());
		Parent p = pr.findOne((long)2);
		List<Child> cl = p.getChild();
		System.out.println(cl.size());
		for(Child ct : cl ){
			System.out.println(ct.getId());
		}
		
		return list;
	}
	
	
	@RequestMapping("/otms")
	@ResponseBody
	public List<Parent> otmSave(){
		Parent p = new Parent();
		p.setName("test");	
		//em.persist(p);
		pr.save(p);
		
		
		Child c = new Child();
		c.setName("child1");
		c.setParent(p);		
		cr.save(c);
		//em.persist(c);
		
		Child c1 = new Child();
		c1.setName("child1");
		c1.setParent(p);
		cr.save(c1);
		//em.persist(c1);
		
		//return pr.findAll();
		return null;
	}
	
	@RequestMapping("/otmm")
	@ResponseBody
	public List<Parent> otmMod(){
		cr.delete((long)2);
		
		return pr.findAll(); 
	}
	
	
	
	
}
