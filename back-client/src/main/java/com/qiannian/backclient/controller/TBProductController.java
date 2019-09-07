package com.qiannian.backclient.controller;

import com.qiannian.backclient.feign.IProductAll;
import com.qiannian.entity.Product;
import com.qiannian.pojo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("TB")
public class TBProductController {

    @Autowired
    private IProductAll productAll;

    @GetMapping("/getById/{id}")
    @ResponseBody
    public ResultBean  getTBProductAll(@PathVariable("id") Integer id) {
        Product product = productAll.getProduct(id);

        return new ResultBean("200",product);
    }
}
