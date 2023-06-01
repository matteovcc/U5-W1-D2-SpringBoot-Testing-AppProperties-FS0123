package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Tavolo {
	private long id;
	private int numeroMaxCoperti;
	private stato stato;

	public enum stato {
		occupato, libero
	}

}
