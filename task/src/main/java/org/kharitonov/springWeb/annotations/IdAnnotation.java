package org.kharitonov.springWeb.annotations;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class IdAnnotation {
    private int COUNT = 0;

    public void setFieldId(Object object) {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for(Field field : fields) {
            Id annotation = field.getAnnotation(Id.class);
            if(annotation != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, object, ++COUNT);
            }
        }
    }
}
