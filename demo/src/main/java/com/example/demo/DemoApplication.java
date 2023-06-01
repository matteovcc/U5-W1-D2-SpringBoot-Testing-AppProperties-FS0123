package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import entities.Prodotto;
import entities.ProsciuttoDecorator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	public static void configWithConfigurationAnnotation() {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfiguration.class);

		Prodotto pizzaConProsciutto = (Prodotto) ctx.getBean("prosciutto");
		System.out.println("Il prodotto: " + pizzaConProsciutto.getName() + "prezzo: " + pizzaConProsciutto.getPrice()
				+ " info: " + pizzaConProsciutto.getInfo());
		Prodotto pizzaGigante = (Prodotto) ctx.getBean("pizzagigante");
		System.out.println("Prodotto: " + pizzaGigante.getName() + " prezzo: " + pizzaGigante.getPrice() + " "
				+ pizzaGigante.getInfo());

		Prodotto wurstel = (Prodotto) ctx.getBean("wurstel");
		System.out.println(wurstel.getPrice() + " " + wurstel.getName() + " gusto: " + wurstel.getInfo());

		Prodotto wurstelconprosciutto = new ProsciuttoDecorator("", 0, "", wurstel);
		System.out.println(wurstelconprosciutto.getName() + " prezzo :" + wurstelconprosciutto.getPrice() + " info: "
				+ wurstelconprosciutto.getInfo());

		ctx.close();

	}
}
