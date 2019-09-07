package com.qiannian.tbserver.controller;


import com.qiannian.entity.Product;
import com.qiannian.tbserver.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductContrller {

    @Autowired
    private IProductService productService;

    @GetMapping("getById/{id}")
    public Product getProduct(@PathVariable("id") String id){

        return productService.getProduct();
    }
}
