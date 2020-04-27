package com.peas.cloud.scanner;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Modifier;

/**
 * * Created by Benson on 2018/3/28.
 */
@Component
public class GlobalScanner {

    @PostConstruct
    public void init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AssignableTypeFilter(Scanner.class));
        for (BeanDefinition beanDefinition : scanner.findCandidateComponents("com.peas.**")) {
            Class<? extends Scanner> c = (Class<? extends Scanner>) Class.forName(beanDefinition.getBeanClassName());
            if (Modifier.isAbstract(c.getModifiers())) {
                continue;
            }
            Scanner scanning = c.newInstance();
            scanning.scan();
        }
    }
}
