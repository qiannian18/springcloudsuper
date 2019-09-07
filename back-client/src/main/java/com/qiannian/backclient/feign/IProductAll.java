package com.qiannian.backclient.feign;


import com.qiannian.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="PRODUCT-SERVER" )
public interface IProductAll {

    @GetMapping("product/getById/{id}")
    Product getProduct(@PathVariable("id") Integer id);
}
