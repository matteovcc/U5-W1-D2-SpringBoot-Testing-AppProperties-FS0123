package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import entities.Ordine;
import entities.Ordine.statoOrdine;
import entities.PizzaGiganteDecorator;
import entities.Prodotto;
import entities.ProsciuttoDecorator;

@Component
public class Runner implements CommandLineRunner {
	private double prezzoCoperto = 1.20;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfiguration.class);
//		Prodotto pizzaProsciutto = (Prodotto) ctx.getBean("prosciutto");
//		Prodotto pizzaGigante = (Prodotto) ctx.getBean("pizzagigante");
//		Ordine ordine = new Ordine(1231344242L, statoOrdine.inCorso, 2, 13.30);
//
//		List<Prodotto> prodottiOrdinati = new ArrayList<>();
//		prodottiOrdinati.add(pizzaGigante);
//		prodottiOrdinati.add(pizzaProsciutto);
//		ordine.setProdottiOrdinati(prodottiOrdinati);
//
//		Map<Prodotto, String> note = new HashMap<>();
//		note.put(pizzaGigante, "senza glutine");
//		note.put(pizzaProsciutto, "cotta bene");
//		ordine.setNote(note);
//
//		Double totaleconto = ordine.getNumeroCoperti() * prezzoCoperto;
//		ordine.setImportoOrdine(totaleconto);
//
//		System.out.println("Ordine effettuato all' ora : " + ordine.getOraOrdine() + ". totale coperti: "
//				+ ordine.getNumeroCoperti() + " hanno ordinato: " + ordine.getNote() + " per un totale euro: "
//				+ ordine.getImportoOrdine());

		Prodotto margherita = (Prodotto) ctx.getBean("pizza");
		System.out.println(margherita.getPrice());
		Prodotto pizzaconprosciutto = new ProsciuttoDecorator("", 0, "", margherita);
		Prodotto pizzaGigante = new PizzaGiganteDecorator(margherita, null, 0, null);
		System.out.println(pizzaconprosciutto.getPrice());
		System.out.println(pizzaGigante.getPrice());
		Ordine ordine = new Ordine(1231344242L, statoOrdine.inCorso, 1, 13.30);

		List<Prodotto> prodottiOrdinati = new ArrayList<>();
		prodottiOrdinati.add(pizzaconprosciutto);
		prodottiOrdinati.add(pizzaGigante);
		ordine.setProdottiOrdinati(prodottiOrdinati);

		Map<Prodotto, String> note = new HashMap<>();
		note.put(pizzaconprosciutto, "senza glutine");
		note.put(pizzaGigante, "ben cotta");
		ordine.setNote(note);

		Double totaleconto = pizzaconprosciutto.getPrice() + pizzaGigante.getPrice()
				+ ordine.getNumeroCoperti() * prezzoCoperto;
		ordine.setImportoOrdine(totaleconto);

		System.out.println("Ordine effettuato all' ora : " + ordine.getOraOrdine() + ". totale coperti: "
				+ ordine.getNumeroCoperti() + " hanno ordinato: " + ordine.getNote() + " per un totale euro: "
				+ ordine.getImportoOrdine());

	}

}
