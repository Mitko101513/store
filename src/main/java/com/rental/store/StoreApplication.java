package com.rental.store;

import com.rental.store.service.RentService;
import com.rental.store.service.impl.RentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "com.rental.store")
public class StoreApplication{

	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(StoreApplication.class, args);
		int createdBeans = applicationContext.getBeanDefinitionCount();
		System.out.println(createdBeans);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Object rentService = appContext.getBean("myRent");
//		String[] beans = appContext.getBeanDefinitionNames();
//		int createdBeans = appContext.getBeanDefinitionCount();
//		System.out.println(createdBeans);
//		Arrays.sort(beans);
//		for (String bean : beans) {
//			System.out.println(bean);
//		}
//	}
}
