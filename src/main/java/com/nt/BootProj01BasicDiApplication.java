package com.nt;

import java.io.PrintStream;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01BasicDiApplication {
	
	//pre-defined class as spring beean using @Bean method
	@Bean(name="ldt")
	public LocalDateTime createLDT() {
		System.out.println("BootProj01BasicDIApplicatiion.createLDT()");
		return LocalDateTime.now();
	}

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj01BasicDiApplication.class, args);
		// get Target spring bean class obj ref
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke the b method
		String result=generator.showWishMessage("raja");
		System.out.println("result:::"+result);
		//close the con
		((ConfigurableApplicationContext) ctx).close();
	}

}
