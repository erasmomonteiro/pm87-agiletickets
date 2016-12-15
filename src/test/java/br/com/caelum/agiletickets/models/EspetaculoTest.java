package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	
	@Test
	public void deveriaCriarSessoesPorSemanaQuandoIntervaloMaior(){
		
		Espetaculo robertoEspetaculo = new Espetaculo();
		robertoEspetaculo.setDescricao("");
		robertoEspetaculo.setNome("No Cruzeiro com Roberto");
		LocalDate inicio = new LocalDate(2011, 1, 9);
		LocalDate fim = new LocalDate(2011, 1, 23);
		LocalTime horario = new LocalTime(17, 00);
		
		List<Sessao> listSessao = robertoEspetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		org.junit.Assert.assertEquals(3, listSessao.size());
	}
	
	@Test
	public void deveriaCriarSessoesPorDiaQuandoIntervaloMaior(){
		
		Espetaculo robertoEspetaculo = new Espetaculo();
		robertoEspetaculo.setDescricao("");
		robertoEspetaculo.setNome("No Cruzeiro com Roberto");
		LocalDate inicio = new LocalDate(2011, 1, 10);
		LocalDate fim = new LocalDate(2011, 1, 20);
		LocalTime horario = new LocalTime(17, 00);
		
		List<Sessao> listSessao = robertoEspetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		org.junit.Assert.assertEquals(12, listSessao.size());
	}
	
	@Test
	public void deveriaNaoCriarSessoesQuandoADataIncioEhNulla(){
		
		Espetaculo robertoEspetaculo = new Espetaculo();
		robertoEspetaculo.setDescricao("");
		robertoEspetaculo.setNome("No Cruzeiro com Roberto");
		LocalDate inicio = null;
		LocalDate fim = new LocalDate(2011, 1, 20);
		LocalTime horario = new LocalTime(17, 00);
		
		List<Sessao> listSessao = robertoEspetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		org.junit.Assert.assertEquals(0, listSessao.size());
	}
	
	@Test
	public void deveriaNaoCriarSessoesQuandoADataFimEhNulla(){
		
		Espetaculo robertoEspetaculo = new Espetaculo();
		robertoEspetaculo.setDescricao("");
		robertoEspetaculo.setNome("No Cruzeiro com Roberto");
		LocalDate inicio = new LocalDate(2011, 1, 10);
		LocalDate fim = null;
		LocalTime horario = new LocalTime(17, 00);
		
		List<Sessao> listSessao = robertoEspetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		org.junit.Assert.assertEquals(0, listSessao.size());
	}
	
	@Test
	public void deveriaNaoCriarSessoesQuandoOHorarioEhNullo(){
		
		Espetaculo robertoEspetaculo = new Espetaculo();
		robertoEspetaculo.setDescricao("");
		robertoEspetaculo.setNome("No Cruzeiro com Roberto");
		LocalDate inicio = new LocalDate(2011, 1, 10);
		LocalDate fim = new LocalDate(2011, 1, 20);
		LocalTime horario = null;
		
		List<Sessao> listSessao = robertoEspetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		org.junit.Assert.assertEquals(0, listSessao.size());
	}
	
}
