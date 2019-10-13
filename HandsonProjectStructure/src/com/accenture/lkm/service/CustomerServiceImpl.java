package com.accenture.lkm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.business.bean.CustomerTypeBean;
import com.accenture.lkm.dao.CustomerDAOWrapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAOWrapper customerDAOWrapper;

	@Override
	public List<CustomerBean> getCustomerDetails(Date startDate, Date endDate) {
		return customerDAOWrapper.getCustomerDetails(startDate, endDate);
	}

	@Override
	public Integer addCustomer(CustomerBean customerBean) {
		int id = 0;
		CustomerTypeBean customerTypeBean = customerDAOWrapper.getCustomerTypeDetails(customerBean.getCustomerType());
		Double bill = customerBean.getBill();
		if (bill > customerTypeBean.getMinimumBill() && bill < customerTypeBean.getMaximumBill()) {
			id = customerDAOWrapper.addCustomer(customerBean);
		}
		return id;
	}

	@Override
	public Map<String, String> getCustomerTypes() {
		List<String> lists = customerDAOWrapper.getCustomerTypes();
		System.out.println(lists);
		Map<String, String> map = new HashMap<String, String>();
		for (String string : lists) {
			System.out.println(string);
			if (string.charAt(0) == 'P') {
				map.put(string, "Platinum");
			} else if (string.charAt(0) == 'G') {
				map.put(string, "Gold");
			} else if (string.charAt(0) == 'S') {
				map.put(string, "Silver");
			}
		}
		System.out.println("**************Map******" + map);
		return map;
	}

}
