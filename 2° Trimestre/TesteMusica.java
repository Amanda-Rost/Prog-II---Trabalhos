
import java.time.Duration;

public class TesteMusica {
	public static void main(String[] args) {
		Musica m;

		String titulo = "Como Tudo Deve Ser";
		String interprete = "Charlie Brown Jr";
		Duration duracao = Duration.ofSeconds(273);
		System.out.println(duracao.equals(duracao));
		int repeticoes = 3;
		m = new Musica(titulo, interprete, duracao, repeticoes);
		System.out.println(m.getTitutlo().equals(titulo));
		System.out.println(m.getInterprete().equals(interprete));
		System.out.println(m.getDuracao().equals(duracao));
		System.out.println(m.getRepeticoes() == 3);
		m.reproduz();
		System.out.println(m.getRepeticoes() == 4);
		System.out.println(m.toString().equals("Musica: Como Tudo Deve Ser (4:33) - Charlie Brown Jr [4 tocadas]"));
	}
}
