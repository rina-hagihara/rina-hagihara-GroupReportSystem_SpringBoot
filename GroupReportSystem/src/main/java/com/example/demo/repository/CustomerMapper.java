package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.customer.model.Customer;

@Mapper
public interface CustomerMapper {

	/** 顧客1件登録 */
	public void insertOne(Customer customer);

	/** 顧客一覧取得 */
	public List<Customer> findMany();

	/** 顧客1件取得 */
	public Customer findOne(int customerId);

	/** 顧客1件更新 */
	public void updateOne(Customer customer);

	/** 顧客1件削除 */
	public void deleteOne(int customerId);

}