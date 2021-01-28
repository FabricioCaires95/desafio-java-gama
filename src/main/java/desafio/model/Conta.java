package desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_conta")
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "saldo")
	private Double saldo;
	
	@Column(name = "tipo_conta")
	private String tipo_conta;

	@OneToOne
	@JoinColumn(name = "cd_user_login", referencedColumnName = "user")
	private Usuario proprietario;
	
	
	public Usuario getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}
	
	public String getTipo_conta() {
		return tipo_conta;
	}
	
	public void setTipo_conta(String tipo_conta) {
		this.tipo_conta = tipo_conta;
	}
	
	public Conta() {
		
	}
	
	public Conta(String numero, Double saldo, String tipo_conta) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.tipo_conta = tipo_conta;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}
