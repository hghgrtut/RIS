package by.bsut.labachetyre.config

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer

class MyAbstractAnnotationConfigDispatcherServletInitializer : AbstractAnnotationConfigDispatcherServletInitializer() {
    protected val rootConfigClasses: Array<Any>? = null
    protected val servletConfigClasses: Array<Any> = arrayOf(SpringWebConfig::class.java)
    protected val servletMappings: Array<String> = arrayOf("/")
}