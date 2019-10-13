package com.accenture.lkm.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.service.CustomerService;

@Controller
public class CustomerContoller {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "loadCustomerForm", method = RequestMethod.GET)
	ModelAndView loadCustomerForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CreateCustomer");
		modelAndView.addObject("customerObj", new CustomerBean());
		return modelAndView;
	}

	@RequestMapping(value = "saveCustomer", method = RequestMethod.POST)
	
	ModelAndView saveCustomer(@ModelAttribute("customerObj") CustomerBean customerBean) {
		ModelAndView view = new ModelAndView();
		System.out.println("*********Save Customer*******");
		int id = customerService.addCustomer(customerBean);
		view.setViewName("CreateCustomer");
		view.addObject("message",
				"Hi " + customerBean.getCustomerName() + ", Your Details Have Been Saved with CustomerId" + id);
		return view;
	}

	@ModelAttribute("customerType")
	Map<String, String> populateCustomerType() {
		System.out.println("*************populate************");
		System.out.println(customerService.getCustomerTypes());
		return customerService.getCustomerTypes();
	}

	// Error Handler:
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}

}
