package com.qiannian.backclient.controller;

import com.qiannian.pojo.ResultBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TB")
public class TBProductController {

    @GetMapping("productAll")
    public ResultBean getTBProductAll(){


        return  new ResultBean();
    }
}
