
public class Acesso {

	public String placa;
	public int dia, mes, ano;
	public int horaEntrada, minutosEntrada;
	public int horaSaida, minutosSaida;

	public Acesso() {
	}

	public Acesso(int dia, int mes, int ano, int horaEntrada, int minutosEntrada) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.horaEntrada = horaEntrada;
		this.minutosEntrada = minutosEntrada;
	}

	public float calcularValor() {
		int quantidadeHoras = horaSaida - horaEntrada;
		int quantidadeMinutos;

		if (horaSaida == horaEntrada) {
			quantidadeMinutos = minutosSaida - minutosEntrada;
		} else if (horaSaida > horaEntrada && minutosEntrada == minutosSaida) {
			quantidadeMinutos = 0;
		} else if (horaSaida > horaEntrada && minutosEntrada > minutosSaida) {
			quantidadeMinutos = minutosSaida - minutosEntrada;
		} else if (horaSaida > horaEntrada && minutosSaida < minutosEntrada) {
			quantidadeMinutos = minutosSaida + (60 - minutosEntrada);
			quantidadeHoras = horaSaida - horaEntrada - 1;
		} else {
			quantidadeHoras = 0;
			quantidadeMinutos = 0;
		}

		PagamentoEstacionamento pagamento = new PagamentoEstacionamento(quantidadeHoras, quantidadeMinutos);

		return pagamento.obterValorTotal();
	}

	public void setHoraSaida(int horaSaida) {
		this.horaSaida = horaSaida;
	}

	public void setMinutosSaida(int minutosSaida) {
		this.minutosSaida = minutosSaida;
	}
}
