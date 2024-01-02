package com.byesfi.vthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VirtualThreadDemoApplication {

	Logger log = LoggerFactory.getLogger(VirtualThreadDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VirtualThreadDemoApplication.class, args);
	}


	@GetMapping("/hello/{name}")
	public Greeting hello(@PathVariable("name") String name){
		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		log.info("Rest controller method has been called {} with id {}", Thread.currentThread(), Thread.currentThread().threadId());

		return new Greeting("Hello, " + name + "!");
	}


}

record Greeting(String name){}
