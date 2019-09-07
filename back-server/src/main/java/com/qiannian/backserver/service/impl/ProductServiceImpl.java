package com.qiannian.backserver.service.impl;


import com.qiannian.backserver.service.IProductService;
import com.qiannian.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

        public Product getProduct(){

            Product product = new Product();
            product.setId(1);
            product.setProductName("iphonexsmax");
            return product;
        }

}
