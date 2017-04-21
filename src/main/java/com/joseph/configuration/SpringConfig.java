//package com.joseph.configuration;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.format.datetime.DateFormatter;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//import org.thymeleaf.templatemode.TemplateMode;
//
///**
// * Created by joseph on 4/8/17.
// * Email: developergitch@outlook.com
// */
//@Configuration
//@ComponentScan(basePackages = "com.joseph.web")
//@EnableWebMvc
//public class SpringConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware{
//    private ApplicationContext applicationContext;
//    public SpringConfig(){
//        super();
//    }
//
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        super.configureDefaultServletHandling(configurer);
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext=applicationContext;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        super.addResourceHandlers(registry);
//        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
//        registry.addResourceHandler("/semantic/**").addResourceLocations("/semantic/dist/");
//        registry.addResourceHandler("/semantic/**").addResourceLocations("/semantic/*");
//    }
//    @Bean
//    public ResourceBundleMessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("Messages");
//        return messageSource;
//    }
//    @Override
//    public void addFormatters(final FormatterRegistry registry) {
//        super.addFormatters(registry);
//        registry.addFormatter(dateFormatter());
//    }
//    @Bean
//    public DateFormatter dateFormatter() {
//        return new DateFormatter();
//    }
//    @Bean
//    public SpringResourceTemplateResolver templateResolver(){
//    // SpringResourceTemplateResolver automatically integrates with Spring's own
//    // resource resolution infrastructure, which is highly recommended.
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(this.applicationContext);
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix(".html");
//    // HTML is the default value, added here for the sake of clarity.
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//    // Template cache is true by default. Set to false if you want
//    // templates to be automatically updated when modified.
//        templateResolver.setCacheable(true);
//        return templateResolver;
//    }
//    @Bean
//    public SpringTemplateEngine templateEngine(){
//    // SpringTemplateEngine automatically applies SpringStandardDialect and
//    // enables Spring's own MessageSource message resolution mechanisms.
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//    // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
//    // speed up execution in most scenarios, but might be incompatible
//    // with specific cases when expressions in one template are reused
//    // across different data types, so this flag is "false" by default
//    // for safer backwards compatibility.
//        templateEngine.setEnableSpringELCompiler(true);
//        return templateEngine;
//    }
//    @Bean
//    public ThymeleafViewResolver viewResolver(){
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        return viewResolver;
//    }
//
//}
