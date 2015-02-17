package jkor.testing_knowledge.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@Component
public class AnnotatedExceptionResolver extends ExceptionHandlerExceptionResolver
{
    public AnnotatedExceptionResolver() {
        setOrder(HIGHEST_PRECEDENCE);
    }
}