# RequestBodyParam

[![Build Status](https://travis-ci.com/LambdaExpression/RequestBodyParam.svg?branch=master)](https://travis-ci.com/LambdaExpression/RequestBodyParam)
[![Maintainability](https://api.codeclimate.com/v1/badges/e547270d7828998c6f38/maintainability)](https://codeclimate.com/github/LambdaExpression/RequestBodyParam/maintainability)

RequestBodyParam 是为了解决使用 @RequestBody 时，必须定义 Dto （或 String 接收解析） 的问题，基于 RequestBody 的逻辑，写了 RequestBodyParam 以支持读取 body 下的参数

[TOC]

## 打包

先 git clone 项目，运行
```shell
mvn clean source:jar install

```

## spring-boot 快速使用

#### 1.maven 引入jar包

```xml

    <dependencies>
        ...
        <dependency>
            <groupId>cn.kknotes.open</groupId>
            <artifactId>requestBodyParam</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        ...
    </dependencies>


```

#### 2.建立 Configurer

添加 @EnableRequestBodyParam 标签注入服务

```java

@Component
@EnableRequestBodyParam
public class RequestBodyParamConfigurer {

}

```

#### 3.Controller层使用

接口入参添加 @RequestBodyParam 标签
```java

@RestController
@RequestMapping
public class TestController {

    @PostMapping(value = "test1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object test1(@RequestBodyParam Integer value1 , @RequestBodyParam String value2 ) {
        Map<String, Object> date = new HashMap<>(2);
        date.put("value1", v1);
        date.put("value2", value2);
        return date;
    }

}
```

#### 4.调用
启动项目调用

```shell
[root@centos ~]# curl -H "Content-type:application/json;charset=UTF-8" -X POST -d '{"value1":123,"value2":"test"}' http://127.0.0.1:8080/test1
{"value2":"test","value1":123}
```


## spring-mvc 快速使用

#### 1.maven 引入jar包

```xml

    <dependencies>
        ...
        <dependency>
            <groupId>cn.kknotes.open</groupId>
            <artifactId>requestBodyParam</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        ...
    </dependencies>


```

#### 2.添加 web.xml 配置

添加 cn.kknotes.open.filter.MultiReadRequestFilter 拦截器
```xml

    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath*:applicationContext*.xml</param-value>
    </context-param>

    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <filter>
        <filter-name>multiReadRequestFilter</filter-name>
        <filter-class>cn.kknotes.open.filter.MultiReadRequestFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>multiReadRequestFilter</filter-name>
        <url-pattern>*</url-pattern>
    </filter-mapping>

```

#### 3.添加 applicationContext.xml 配置

```xml

    <context:component-scan base-package="cn.kknotes.open"/>

    <bean id="defaultMultiReadRequestBean" class="cn.kknotes.open.bean.DefaultMultiReadRequestBean">
    </bean>

    <mvc:annotation-driven>
        <mvc:argument-resolvers>
            <bean class="cn.kknotes.open.resolver.RequestBodyParamArgumentResolver"/>
        </mvc:argument-resolvers>
    </mvc:annotation-driven>

```

#### 4.Controller层使用

接口入参添加 @RequestBodyParam 标签
```java

    @RequestMapping(value = "test1", produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public Object test1(@RequestBodyParam Integer value1 , @RequestBodyParam String value2 ) {
        Map<String, Object> date = new HashMap<>(4);
        date.put("value1", v1);
        date.put("value2", value2);
        return date;
    }

```

#### 5.调用
启动项目调用

```shell
[root@centos ~]# curl -H "Content-type:application/json;charset=UTF-8" -X POST -d '{"value1":123,"value2":"test"}' http://127.0.0.1:8080/test1
{"value2":"test","value1":123}
```



