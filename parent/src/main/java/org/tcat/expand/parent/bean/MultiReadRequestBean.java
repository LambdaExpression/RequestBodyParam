package org.tcat.expand.parent.bean;

import javax.servlet.ServletRequest;

/**
 * @author lin
 * @date 2018/11/9
 */
public interface MultiReadRequestBean {

    boolean filter(ServletRequest request);

}
