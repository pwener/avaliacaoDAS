
public class PagamentoEstacionamento {
	public static final float VALOR_FRACAO = (float) 2.0;
	public static final float VALOR_HORA = (float) 7.0;
	public static final float VALOR_DIARIA = (float) 30.0;

	public int quantidadeHoras;
	public int quantidadeMinutos;

	/**
	 * Não faz sentido existir pagamento sem horas e minutos,
	 * por isso essa composição.
	 * 
	 * @param horas utilizadas no estacionamento
	 * @param minutos utilizados no estacionamento
	 */
	public PagamentoEstacionamento(int horas, int minutos) {
		this.quantidadeHoras = horas;
		this.quantidadeMinutos = minutos;
	}

	public float calcularValorPorHora() {
		float valorEmHoras = quantidadeHoras * VALOR_HORA;
		return valorEmHoras;
	}

	public float calculaValorPorMinuto() {
		float valorEmMinutos = (float) (Math.ceil(quantidadeMinutos / 15.0) * VALOR_FRACAO);

		return valorEmMinutos;
	}

	/**
	 * Obtem calculo do valor total do estacionamento
	 * 
	 */
	public float obterValorTotal() {
		float valorTotal = 0;

		if (quantidadeHoras >= 9) {
			valorTotal = VALOR_DIARIA;
		} else {
			valorTotal = calcularValorPorHora() + calculaValorPorMinuto();
		}

		return valorTotal;
	}
}
