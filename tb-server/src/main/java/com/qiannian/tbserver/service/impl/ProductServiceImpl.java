package com.qiannian.tbserver.service.impl;


import com.qiannian.entity.Product;
import com.qiannian.tbserver.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

        public Product getProduct(){

            Product product = new Product();
            product.setId(2);
            product.setProductName("iphonexsmaxsssss");
            return product;
        }

}
