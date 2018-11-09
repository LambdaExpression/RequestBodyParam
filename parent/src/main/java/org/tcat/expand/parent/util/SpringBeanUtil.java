package org.tcat.expand.parent.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author lin
 * @date 2018/11/9
 */
@Component("springBeanUtil")
public class SpringBeanUtil implements ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(SpringBeanUtil.class);

    private static ApplicationContext ctx = null;

    private static Map<String, Properties> propMap = new HashMap<>(0);

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        SpringBeanUtil.ctx = ctx;
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        return ctx.getBeansOfType(type);
    }

    public static <T> T getBean(String prop) {
        Object obj = ctx.getBean(prop);
        if (logger.isDebugEnabled()) {
            logger.debug("property=[" + prop + "],object=[" + obj + "]");
        }
        return (T) obj;
    }

    public static Properties getProperties(String filepath) {
        if (propMap.containsKey(filepath)) {
            return propMap.get(filepath);
        }

        Resource resource = ctx.getResource(filepath);
        Properties prop = new Properties();
        try {
            prop.load(resource.getInputStream());
            propMap.put(filepath, prop);
            return prop;
        } catch (IOException e) {
            logger.error("can not find the resource file:[" + filepath + "]", e);
            return null;
        }
    }
}
