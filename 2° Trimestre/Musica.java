import java.time.Duration;
import java.util.Objects;

public class Musica {

	// Attributes

	private final String titulo;
	private String interprete;
	private Duration duracao;
	private int repeticoes;

	// Constructor

	public Musica(String titulo, String interprete, Duration duracao, int repeticoes) {
		Objects.requireNonNull(titulo, "titulo nao pode ser nulo");
		Objects.requireNonNull(interprete, "interprete nao pode ser nulo");
		Objects.requireNonNull(duracao, "duracao nao pode ser nulo");
		this.titulo = titulo;
		this.interprete = interprete;

		if (duracao.isZero() || repeticoes < 0) {
			throw new IllegalArgumentException(
					"duracao nao pode ser igual ou menor que zero e repeticoes nao podem ser menor que 0");

		} else {
			this.duracao = duracao;
			this.repeticoes = repeticoes;
		}
	}

	// Methods

	public String getTitutlo() {
		return this.titulo;
	}

	public String getInterprete() {
		return this.interprete;
	}

	public Duration getDuracao() {
		return this.duracao;
	}

	public int getRepeticoes() {
		return this.repeticoes;
	}

	public void reproduz() {
		this.repeticoes = this.repeticoes + 1;
	}

	@Override
	public String toString() {
		int min = this.duracao.toMinutesPart();
		int sec = this.duracao.toSecondsPart();
		String duracText = String.format("%d:%02d", min, sec);

		return "Musica: " + this.titulo + " (" + duracText + ") - " + this.interprete + " [" + this.repeticoes
				+ " tocadas]";

	}
}