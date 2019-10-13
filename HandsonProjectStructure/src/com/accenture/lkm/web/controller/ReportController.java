package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.business.bean.DateRangeBean;
import com.accenture.lkm.service.CustomerService;

@Controller
public class ReportController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "loadReportPage", method = RequestMethod.GET)
	ModelAndView loadReportPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CustomerDetails");
		modelAndView.addObject("dateRangeBean", new DateRangeBean());
		return modelAndView;
	}

	@RequestMapping(value = "getCustomerRecords", method = RequestMethod.POST)
	ModelAndView getCustomerRecords(@ModelAttribute("dateRangeBean") DateRangeBean dateRangeBean) {
		System.out.println("**************Get Customer Records******");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CustomerDetails");
		List<CustomerBean> beans = customerService.getCustomerDetails(dateRangeBean.getFromDate(),
				dateRangeBean.getToDate());
		System.out.println(beans);
		modelAndView.addObject("customer", beans);
		return modelAndView;
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
}
