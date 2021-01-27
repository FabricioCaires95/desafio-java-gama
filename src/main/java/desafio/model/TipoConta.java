package desafio.model;

public enum TipoConta {
	CC ("Conta Corrente"),
	CP ("Conta Poupanca"),
	CS ("Conta Salario");
	
	private String tipoConta;
	TipoConta (String tipoConta){
		this.tipoConta = tipoConta;
	}
}
