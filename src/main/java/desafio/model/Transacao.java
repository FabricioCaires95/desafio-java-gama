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
	
	@Column(name = "numero_conta", nullable = false)
	private String numero;
	
	@Column(name= "valor_transacao", scale = 2)
	private Double valor;
	
	@Column(name = "tipo_transacao")
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipoTrasacao;
	
	@Column(name = "tipo_plano_conta")
	private String tipoPlanoConta;
	
	@Column(name = "descricao", length = 50)
	private String descricao;
	
	@Column(name = "numero_conta_destino")
	private String numero_destino;
	
	public Integer getId() {
		return id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getNumero_destino() {
		return numero_destino;
	}
	public void setNumero_destino(String numero_destino) {
		this.numero_destino = numero_destino;
	}
	
	public TipoTransacao getTipoTrasacao() {
		return tipoTrasacao;
	}
	public void setTipoTrasacao(TipoTransacao tipoTrasacao) {
		this.tipoTrasacao = tipoTrasacao;
	}
	public String getTipoPlanoConta() {
		return tipoPlanoConta;
	}
	public void setTipoPlanoConta(String tipoPlanoConta) {
		this.tipoPlanoConta = tipoPlanoConta;
	}
}
