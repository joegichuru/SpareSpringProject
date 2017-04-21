//package com.joseph.configuration;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
///**
// * Created by joseph on 4/8/17.
// * Email: developergitch@outlook.com
// */
//public class WebappInit implements WebApplicationInitializer{
////
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext configWebApplicationContext=new AnnotationConfigWebApplicationContext();
//        configWebApplicationContext.register(SpringConfig.class);
//        configWebApplicationContext.setServletContext(servletContext);
//        configWebApplicationContext.getResource("app-config.xml");
//        ServletRegistration.Dynamic dispatcher=servletContext.addServlet("dispatcher",new DispatcherServlet());
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
//}
