package desafio.model;

public enum TipoPlanoConta {
	ENERG ("Energia"),
	MERC ("Mercado"),
	AGUA ("Agua"),
	OUTROS ("Outros");
	
	private String tipoPlanoConta;
	TipoPlanoConta(String tipoConta){
		this.tipoPlanoConta = tipoConta;
	}
}
