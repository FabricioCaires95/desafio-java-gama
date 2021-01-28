package desafio.model;

public enum TipoTransacao {
	CR ("Credito"),
	DB ("Debito");
	
	private String tipoTransacao;
	TipoTransacao(String tipoTransacao){
		this.tipoTransacao = tipoTransacao;
	}
	
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
}
