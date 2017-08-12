package com.arjun.info.arjuninfo;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@Configuration 
public class MailConfig {

    @Value("${email.host}")
    private String host;

    @Value("${email.port}")
    private Integer port;
    
    @Value("${email.appEmail}")
    private String appEmail;
    
    @Value("${email.password}")
    private String password;
    @Bean
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername("arjundevrana91info");
        javaMailSender.setPassword("ArjunDev@12345");
        javaMailSender.setJavaMailProperties(getMailProperties());

        return javaMailSender;
    }

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.required", "true");
        properties.setProperty("mail.debug", "false");
        return properties;
    }
}
