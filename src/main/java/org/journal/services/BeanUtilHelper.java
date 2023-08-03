package org.journal.services;


import org.springframework.beans.BeanUtils;

public class BeanUtilHelper extends BeanUtils {

    public static void copyPropertiesIgnoreNull(Object source, Object destination){
       // BeanUtilHelper beanUtilHelper = new BeanUtilHelper();
        BeanUtilHelper.copyProperties(destination, source);
    }
}
