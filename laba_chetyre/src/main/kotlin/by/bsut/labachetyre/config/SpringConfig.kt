package by.bsut.labachetyre.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import by.bsut.labachetyre.annotations.IdAnnotation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfig {

    @Bean(name = "objectMapper")
    fun objectMapper(): ObjectMapper = JsonMapper.builder().addModule(JavaTimeModule()).build()

    @Bean(name = "idAnnotationImpl")
    fun idAnnotation(): IdAnnotation = IdAnnotation()
}