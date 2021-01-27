package desafio.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tab_transacoes")
public class Transacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "data_transacao", nullable = false)
	private LocalDate date;
	
	@OneToOne
	@JoinColumn(name="conta_user", referencedColumnName = "id")
	private Conta numero;
	
	@Column(name= "valor_transacao", scale = 2)
	private Double valor;
	
	@Column(name="tipo_plano_conta")
	private TipoPlanoConta planoConta;
	
	@OneToOne
	@JoinColumn(name="conta_destino", referencedColumnName="id")
	private Conta numero_destino;
	
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Conta getNumero() {
		return numero;
	}
	public void setNumero(Conta numero) {
		this.numero = numero;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Conta getNumero_destino() {
		return numero_destino;
	}
	public void setNumero_destino(Conta numero_destino) {
		this.numero_destino = numero_destino;
	}
	
}
