package com.cruds.posdemo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cruds.posdemo.entity.FormBeanTax;
import com.cruds.posdemo.entity.Tax;
import com.cruds.posdemo.entity.User;
import com.cruds.posdemo.service.TaxService;
import com.cruds.posdemo.service.UserService;


@Controller
public class HomeController {
	@Autowired
	UserService ser;
	
	@Autowired
	TaxService taxser;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ModelAndView showStudentForm()
	{
		ModelAndView mv = new ModelAndView("users", "user", new User());
		mv.addObject("USERLIST", ser.getAllUser());
		return mv;		
	}
	
	@RequestMapping(value="/createuser", method = RequestMethod.POST)
	public String createUserPage(@ModelAttribute("user") User user)
	{
		ser.create(user);
		return "redirect:home.html";
	}
	
	@RequestMapping(value="/taxes", method=RequestMethod.GET)
	public ModelAndView addTaxesget()
	{
		ModelAndView mv = new ModelAndView("taxes", "taxes", new Tax());
		mv.addObject("TAXLIST", taxser.getAllTax());
		return mv;		
	}
	
	@RequestMapping(value="/addTax", method = RequestMethod.POST)
	public String addTaxespost(@RequestParam("taxname") String taxname,@RequestParam("taxrate") Double taxrate )
	{
		LocalDate startDate = LocalDate.now();	
		Tax tax=new Tax(taxname,taxrate,startDate);
		taxser.addTax(tax);
		return "redirect:home.html";
	}
	
	

}
