package com.bjsxt.yanbing.dao;

import java.util.List;

import com.bjsxt.pojo.Product;

public interface ProductDao {

	List<Product> selAllProduct();
	List<Product> selAllProduct(int start, int size);
	int selProductCount();

	List<Product> selById(int start, int size, int id, int operator);
	int selCountById(int id, int operator);

	List<Product> selByProName(int start, int size, String value, int operator);
	int selCountByProName(String value, int operator);

	List<Product> selBySupName(int start, int size, String value, int operator);
	int selCountBySupName(String value, int operator);

	boolean insProduct(Product p);

	public boolean delById(int id);

	public Product selById(int id);
}
