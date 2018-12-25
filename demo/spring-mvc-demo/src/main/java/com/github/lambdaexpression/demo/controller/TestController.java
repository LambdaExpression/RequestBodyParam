package com.github.lambdaexpression.demo.controller;

import com.github.lambdaexpression.annotation.RequestBodyParam;
import com.github.lambdaexpression.demo.controller.vo.Value3;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @date 2018/11/9
 */
@Controller
@RequestMapping
public class TestController {

    @RequestMapping(value = "test1", produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public Object test1(@RequestBodyParam(name = "value1", required = false) Integer v1
            , @RequestBodyParam(required = false) Value3 value3
            , @RequestBodyParam(required = false) String[] value5) {
        Map<String, Object> date = new HashMap<>(4);
        date.put("value1", v1);
        date.put("value3", value3);
        date.put("value5", value5);
        return date;
    }

    @RequestMapping(value = "test2", produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public Object test2(@RequestBody Value3 value3) {
        return value3;
    }

    @RequestMapping()
    @ResponseBody
    public String index(){
        return "index";
    }

}
