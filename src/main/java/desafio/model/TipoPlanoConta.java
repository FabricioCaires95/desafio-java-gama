package desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tab_plano_conta")
public class TipoPlanoConta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="plano_conta")
	private String finalidade;
	
	public TipoPlanoConta(){
		
	}
	
	public TipoPlanoConta(String finalidade){
		this.finalidade = finalidade;
	}
	
	public String getFinalidade() {
		return finalidade;
	}
	
	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}
}
