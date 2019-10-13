package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.business.bean.CustomerTypeBean;
import com.accenture.lkm.entity.CustomerEntity;
import com.accenture.lkm.entity.CustomerTypeEntity;

@Repository
@Transactional(value = "txManager")
public class CustomerDAOWrapper {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private CustomerTypeDAO customerTypeDAO;

	@PersistenceContext
	 EntityManager entityManager;

	public List<CustomerBean> getCustomerDetails(Date startDate, Date endDate) {
		List<CustomerBean> beans = new ArrayList<CustomerBean>();
		List<CustomerEntity> entities = customerDAO.getCustomerDetails(startDate, endDate);
		if (entities != null) {
			for (CustomerEntity customerEntity : entities) {
				CustomerBean bean = new CustomerBean();
				bean = convertEntityToBean(customerEntity);
				beans.add(bean);
			}
		}
		return beans;
	}

	public List<String> getCustomerTypes() {
		List<String> strings=customerTypeDAO.getCustomerTypes();
		return strings;
	}

	public CustomerTypeBean getCustomerTypeDetails(String customerType) {
		CustomerTypeEntity customerTypeEntity = entityManager.find(CustomerTypeEntity.class, customerType);
		return convertEntityToBean(customerTypeEntity);
	}

	public Integer addCustomer(CustomerBean customerBean) {
		CustomerEntity entity=convertBeanToEntity(customerBean);
		entityManager.persist(entity);
		return entity.getCustomerId();

	}

	public static CustomerTypeBean convertEntityToBean(CustomerTypeEntity entity) {
		CustomerTypeBean customerTypeBean = new CustomerTypeBean();
		BeanUtils.copyProperties(entity, customerTypeBean);
		return customerTypeBean;
	}

	public static CustomerTypeEntity convertBeanToEntity(CustomerTypeBean bean) {
		CustomerTypeEntity entity = new CustomerTypeEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}

	public static CustomerBean convertEntityToBean(CustomerEntity entity) {
		CustomerBean customerBean = new CustomerBean();
		BeanUtils.copyProperties(entity, customerBean);
		return customerBean;
	}

	public static CustomerEntity convertBeanToEntity(CustomerBean bean) {
		CustomerEntity entity = new CustomerEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
}
