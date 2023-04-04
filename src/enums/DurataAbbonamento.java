package enums;

public enum DurataAbbonamento {
	SETTIMANALE(7), MENSILE(30);

	int numeroGiorni;

	DurataAbbonamento(int i) {

		this.numeroGiorni = i;
	}

}
