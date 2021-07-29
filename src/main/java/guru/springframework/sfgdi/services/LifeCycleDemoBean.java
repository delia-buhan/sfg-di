package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {


    public LifeCycleDemoBean() {
        System.out.println("S1. constructor ## I'm in the LifeCycleBean Constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("E2. destroy## The Lifecycle bean has been terminated");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("S7. afterPropertiesSet ## The LifeCycleBean has its properties set!");

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("S3. setBeanFactory ## Bean Factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("S2. setBeanName ## My Bean Name is: " + name);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("S4. setApplicationContext ## Application context has been set");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("S6. postConstruct ## The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("E1. preDestroy ## The Predestroy annotated method has been called");
    }

    public void beforeInit(){
        System.out.println("S5. beforeInit ## - Before Init - Called by Bean Post Processor");
    }

    public void afterInit(){
        System.out.println("S8. afterInit ## - After init called by Bean Post Processor");
    }
}
