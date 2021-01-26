package desafio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tab_usuario", uniqueConstraints = @UniqueConstraint(columnNames = {"user"}, name = "uk_user"))
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "user", length = 20)
	private String login;
	
	@Column(name = "pass", length = 100, nullable = false) 
	private String senha;
	
	@Column(length = 50)
	private String nome;
	
	private String cpf;
	
	@OneToMany (cascade = CascadeType.PERSIST, mappedBy = "proprietario")
	private List<Conta> contas = new ArrayList<Conta>();
	
	public List<Conta> getContas() {
		return contas;
	}
	
	public void addConta(Conta conta) {
		conta.setProprietario(this);
		this.contas.add(conta);
	}
	
	public Integer getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
