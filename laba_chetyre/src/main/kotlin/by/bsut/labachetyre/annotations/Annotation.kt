package by.bsut.labachetyre

import java.lang.annotation.Documented

import java.lang.annotation.ElementType


@Retention(RetentionPolicy.RUNTIME)
@Target([java.lang.annotation.ElementType.FIELD])
@Documented
annotation class Id

class IdAnnotation {

    private var COUNT = 0

    fun setFieldId(any: Any) {
        for (field in any::class.java.getDeclaredFields()) {
            if (field.getAnnotation(Id::class.java) != null) {
                field.setAccessible(true)
                ReflectionUtils.setField(field, any, ++COUNT)
            }
        }
    }
}