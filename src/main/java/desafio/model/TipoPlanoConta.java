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
	
	public String getTipoPlanoConta() {
		return tipoPlanoConta;
	}
	public void setTipoPlanoConta(String tipoPlanoConta) {
		this.tipoPlanoConta = tipoPlanoConta;
	}
}
