package com.github.lambdaexpression.demo.controller;

import com.github.lambdaexpression.annotation.RequestBodyParam;
import com.github.lambdaexpression.demo.controller.vo.Value3;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @date 2018/11/9
 */
@RestController
@RequestMapping
public class TestController {

    @PostMapping(value = "test1", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object test1(@RequestBodyParam(name = "value1", required = false) Integer v1
            , @RequestBodyParam(required = false) String value2
            , @RequestBodyParam(required = false) Value3 value3
            , @RequestBodyParam(required = false) String[] value5) {
        Map<String, Object> date = new HashMap<>(4);
        date.put("value1", v1);
        date.put("value2", value2);
        date.put("value3", value3);
        date.put("value5", value5);
        return date;
    }

    @PostMapping(value = "test2", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object test2(@RequestBody Value3 value3) {
        return value3;
    }

    @PostMapping(value = "test3", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object test3(@RequestBodyParam(name = "value1", required = false) Integer v1
            , @RequestBodyParam(required = false) String value2
            , @RequestBodyParam(required = false) Value3 value3
            , @RequestBodyParam(required = false) String[] value5) {
        Map<String, Object> date = new HashMap<>(4);
        date.put("value1", v1);
        date.put("value2", value2);
        date.put("value3", value3);
        date.put("value5", value5);
        return date;
    }


    @RequestMapping(value = "test4/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public Object test4(@PathVariable("id") int id, @RequestBodyParam(name = "value1") Integer v1) {
        Map<String, Object> date = new HashMap<>(4);
        date.put("value1", v1);
        date.put("id", id);
        return date;
    }


}
