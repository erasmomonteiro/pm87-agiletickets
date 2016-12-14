package br.com.caelum.agiletickets.models;

public enum TipoDeEspetaculo {
	
	CINEMA(0.05, 0.10, false),
	SHOW(0.05, 0.10, false),
	TEATRO(0.0, 0.0, false),
	BALLET(0.50, 0.20, true),
	ORQUESTRA(0.50, 0.20, true);
	
	private double taxaOcupacaoTarifa;
	private double tarifaAdicionalTempo;
	private boolean isCalculaPeriodo;
	
	private TipoDeEspetaculo(double taxaOcupacao, double tarifaAdicionalTempo, boolean isCalculaPeriodo) {
		this.taxaOcupacaoTarifa = taxaOcupacao;
		this.tarifaAdicionalTempo = tarifaAdicionalTempo;
		this.isCalculaPeriodo = isCalculaPeriodo;
	}
	
	public double getTaxaOcupacaoTarifa() {
		return taxaOcupacaoTarifa;
	}
	
	public double getTarifaAdicionalTempo(){
		return tarifaAdicionalTempo;
	}
	
	public boolean isCalculaPeriodo(){
		return isCalculaPeriodo;
	}
}
