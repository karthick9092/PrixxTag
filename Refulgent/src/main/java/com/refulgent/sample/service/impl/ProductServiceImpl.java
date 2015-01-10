package com.refulgent.sample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refulgent.entity.Product;
import com.refulgent.sample.model.ProductBean;
import com.refulgent.sample.repo.ProductRepository;
import com.refulgent.sample.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductBean> retrieveAll() {
		// TODO Auto-generated method stub
		List<Product> productList = null;
		List<ProductBean> productBeanList = null;
		try {
			productList = productRepository.findAll();
			if (productList != null && productList.size() != 0) {
				productBeanList = new ArrayList<>();
				for (Product product : productList) {
					ProductBean productBean = new ProductBean();
					BeanUtils.copyProperties(product, productBean);
					productBeanList.add(productBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productBeanList;
	}
		
}
