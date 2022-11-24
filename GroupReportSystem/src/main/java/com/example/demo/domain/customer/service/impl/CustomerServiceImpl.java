package com.example.demo.domain.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.customer.model.Customer;
import com.example.demo.domain.customer.service.CustomerService;
import com.example.demo.repository.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper mapper;

	/** 顧客1件登録 */
	@Override
	public void insertCustomer(Customer customer) {
		mapper.insertOne(customer);
	}

	/** 顧客一覧取得 */
	@Override
	public List<Customer> getCustomerList() {
		return mapper.findMany();
	}

	/** 顧客1件取得 */
	@Override
	public Customer getCustomerDetail(int customerId) {
		return mapper.findOne(customerId);
	}

	/** 顧客1件更新 */
	@Override
	public void updateCustomer(Customer customer) {
		mapper.updateOne(customer);
	}

	/** 顧客1件削除 */
	@Override
	public void deleteCustomer(int customerId) {
		mapper.deleteOne(customerId);
	}
}
