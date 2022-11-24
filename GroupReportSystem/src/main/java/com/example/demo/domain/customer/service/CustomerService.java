package com.example.demo.domain.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.customer.model.Customer;

@Service
public interface CustomerService {

	/** 顧客1件登録 */
	public void insertCustomer(Customer customer);

	/** 顧客一覧取得 */
	public List<Customer> getCustomerList();

	/** 顧客1件取得 */
	public Customer getCustomerDetail(int customerId);

	/** 顧客1件更新 */
	public void updateCustomer(Customer customer);

	/** 顧客1件削除 */
	public void deleteCustomer(int customerId);
}
