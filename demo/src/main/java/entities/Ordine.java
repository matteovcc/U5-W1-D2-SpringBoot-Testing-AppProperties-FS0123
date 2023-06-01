package entities;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Ordine {
	private long id;
	private Tavolo tavolo;
	private List<Prodotto> prodottiOrdinati;
	private Map<Prodotto, String> note;
	private statoOrdine statoOrdine;
	private int numeroCoperti;
	private double oraOrdine;
	private double importoOrdine;

	public enum statoOrdine {
		inCorso, pronto, servito
	}

	public Ordine(long id, entities.Ordine.statoOrdine statoOrdine, int numeroCoperti, double oraOrdine) {
		super();
		this.id = id;
		this.statoOrdine = statoOrdine;
		this.numeroCoperti = numeroCoperti;
		this.oraOrdine = oraOrdine;
	}

}
