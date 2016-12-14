package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class CalculadoraDePrecos {
	
	private final static int TEMPO_CALCULO = 60; // Tempo minimo em minutos para iniciar calculo por duracao
	private final static double TARIFA_ADICIONAL_TEMPO = 0.10; // Porcentagem adicional por duracao
	
	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco = calcularPrecoEspetaculo(sessao);
		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	/**
	 * 
	 * @param sessao
	 * @param tarifaAdicional
	 * @return
	 */
	private static BigDecimal calcularPrecoEspetaculo(Sessao sessao) {
		BigDecimal preco;
		
		double taxaOcupacaoTarifa = sessao.getEspetaculo().getTipo().getTaxaOcupacaoTarifa();
		double tarifaAdicional = sessao.getEspetaculo().getTipo().getTarifaAdicionalTempo();
		boolean isCalculaPeriodo = sessao.getEspetaculo().getTipo().isCalculaPeriodo();
		
		if(sessao.obterTaxaOcupacao() <= taxaOcupacaoTarifa) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(tarifaAdicional)));
		} else {
			preco = sessao.getPreco();
		}
		
		if(isCalculaPeriodo && sessao.getDuracaoEmMinutos() > TEMPO_CALCULO){
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(TARIFA_ADICIONAL_TEMPO)));
		}
		return preco;
	}
	
}