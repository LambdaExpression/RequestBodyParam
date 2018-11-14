# RequestBodyParam : get body param

[![Build Status](https://travis-ci.com/LambdaExpression/RequestBodyParam.svg?branch=master)](https://travis-ci.com/LambdaExpression/RequestBodyParam)
[![Maintainability](https://api.codeclimate.com/v1/badges/e547270d7828998c6f38/maintainability)](https://codeclimate.com/github/LambdaExpression/RequestBodyParam/maintainability)

[English](## I.Mvn Package)
[中文](## I.打包)

RequestBodyParam is to solve the problem of defining Dto (or String receiving parsing) when using @RequestBody. Based on the logic of RequestBody, RequestBodyParam is written to support reading the parameters under body.
## I.Mvn Package

git clone code，run
```shell
mvn clean source:jar install

```

## II.Spring Boot Quick Start

#### 1.Add Dependency

**Note:** RequestBodyParam requires Java 8 or later.

If your application is build in maven, just add the following code in pom.xml.

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

#### 2.Add Configurer

Add @EnableRequestBodyParam tag injection service

```java

@Component
@EnableRequestBodyParam
public class RequestBodyParamConfigurer {

}

```

#### 3.Use On Controller

Controller param add @RequestBodyParam tag

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

#### 4.Test
run project

```shell
[root@centos ~]# curl -H "Content-type:application/json;charset=UTF-8" -X POST -d '{"value1":123,"value2":"test"}' http://127.0.0.1:8080/test1
{"value2":"test","value1":123}
```


## III.Spring MVC Quick Start

#### 1.maven Add Dependency
             
**Note:** RequestBodyParam requires Java 8 or later.
             
If your application is build in maven, just add the following code in pom.xml.


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

#### 2.Update web.xml

add cn.kknotes.open.filter.MultiReadRequestFilter filter
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

#### 3.Update applicationContext.xml

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

#### 4.Use On Controller
       
Controller param add @RequestBodyParam tag

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

#### 5.Test

run project

```shell
[root@centos ~]# curl -H "Content-type:application/json;charset=UTF-8" -X POST -d '{"value1":123,"value2":"test"}' http://127.0.0.1:8080/test1
{"value2":"test","value1":123}
```

## IV.Advanced

@RequestBodyParam(value="name",request=false) provide an additional three labels

name|action
---|---
value|alias
name|same value, alias
request|whether the body param parameter is required. The default is true , an exception is thrown when the argument is empty; set to false if body param is allowed to be empty



--------------

RequestBodyParam 是为了解决使用 @RequestBody 时，必须定义 Dto （或 String 接收解析） 的问题，基于 RequestBody 的逻辑，写了 RequestBodyParam 以支持读取 body 下的参数

## I.打包

先 git clone 项目，运行
```shell
mvn clean source:jar install

```

## II.spring-boot 快速使用

#### 1.maven 引入jar包

**注意：** RequestBodyParam需要Java 8或更高版本。

如果您的应用程序是在maven中构建的，只需在pom.xml中添加以下代码即可。

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


## III.spring-mvc 快速使用

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

## IV.进阶使用

@RequestBodyParam(value="name",request=false) 提供额外的三个标签

参数名|作用
---|---
value|别名
name|同value，别名
request|是否必须要 body param 参数。默认为 true ，参数为空时抛出异常；如果允许 body param 为空，请设置为 false


