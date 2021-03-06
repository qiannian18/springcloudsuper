package com.qiannian.backserver.controller;

import com.qiannian.backserver.service.IProductService;
import com.qiannian.entity.Product;
import com.qiannian.pojo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TB")
public class ProductContrller {

    @Autowired
    private IProductService productService;
    @GetMapping("getProductAll")
    public Product getProduct(){

        return productService.getProduct();
    }
}
