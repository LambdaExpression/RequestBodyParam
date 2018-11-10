package org.tcat.expand.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tcat.expand.demo.controller.vo.Value3;
import org.tcat.expand.parent.annotation.RequestBodyParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin
 * @date 2018/11/9
 */
@RestController
@RequestMapping
public class TestController {

    @PostMapping(value = "test1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

    @PostMapping(value = "test2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object test2(@RequestBody Value3 value3) {
        return value3;
    }

}
