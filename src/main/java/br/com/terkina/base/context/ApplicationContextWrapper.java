package br.com.terkina.base.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
public class ApplicationContextWrapper {

    @Getter @Setter
    private static ApplicationContext applicationContext;

    @Autowired
    public ApplicationContextWrapper(ApplicationContext applicationContext) {
        setApplicationContext(applicationContext);
    }
}