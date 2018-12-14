package com.bjsxt.yanbing.service;

import java.util.List;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Product;
import com.bjsxt.pojo.Supplier;

public interface ProductService {
	Pagination<Product> selAllProduct(int page, int rows, String column,
			String operator, String srchVal);

	public List<Supplier> selAllSupplier();

	public boolean insProduct(Product p);

	public boolean delById(int id);

	public List<Product> selAllProduct();

	public Product selById(int id);
}
