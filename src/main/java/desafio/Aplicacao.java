package desafio;

import java.time.LocalDate;

import desafio.model.Conta;
import desafio.model.TipoPlanoConta;
import desafio.model.TipoTransacao;
import desafio.model.Transacao;
import desafio.model.Usuario;
import desafio.repository.TipoPlanoContaRepository;
import desafio.service.TransacaoService;
import desafio.service.UsuarioService;

public class Aplicacao {
	public static void main(String[] args) {
		// Adicão do tipo de plano de conta
		TipoPlanoContaRepository tpcRep = new TipoPlanoContaRepository();
		TipoPlanoConta tpc1 = new TipoPlanoConta("Mercado");
		tpcRep.incluir(tpc1);
		TipoPlanoConta tpc2 = new TipoPlanoConta("Energia");
		tpcRep.incluir(tpc2);
		TipoPlanoConta tpc3 = new TipoPlanoConta("Transferencia");
		tpcRep.incluir(tpc3);

		// Adição do usuario
		UsuarioService s = new UsuarioService();
		Usuario u = new Usuario();
		u.setCpf("15945675398");
		u.setNome("Rafa");
		u.setLogin("rafael");
		u.setSenha("xxxxxx");
		u.addConta(new Conta("123", 1000.08, "Conta Corrente"));
		s.incluir(u);

		UsuarioService s2 = new UsuarioService();
		Usuario u2 = new Usuario();
		u2.setCpf("123");
		u2.setNome("Vic");
		u2.setLogin("absasda");
		u2.setSenha("xxxxxx");
		u2.addConta(new Conta("123456", 5000.08, "Conta Corrente"));
		s2.incluir(u2);
		
		// Adição da transação
		TransacaoService ts = new TransacaoService();
		Transacao t = new Transacao();
		t.setDate(LocalDate.now());
		t.setNumero("123");
		t.setTipoPlanoConta("Mercado");
		t.setTipoTrasacao(TipoTransacao.CR);
		t.setValor(12.12);
		ts.transferencia(t);
	}
}
