import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;

public class Playlist {
	// atributos
	private final String titulo;
	private ArrayList<Musica> listMusica;

	// contrutor
	public Playlist(String titulo) {
		Objects.requireNonNull(titulo, "Titulo nao pode ser nulo !!!");
		this.titulo = titulo;
		this.listMusica = new ArrayList();
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void addMusica(Musica mus) {
		Objects.requireNonNull(mus, "Precisa ter uma musica");
		this.listMusica.add(mus);
	}

	public Musica getMusica(int pos) {
		return this.listMusica.get(pos);
	}

	public Musica removeMusica(int pos) {
		return this.listMusica.remove(pos);
	}

	public String tocaMusica(int pos) {
		this.listMusica.get(pos).reproduz();
		return this.listMusica.get(pos).getTitutlo();
	}

	public String tocaMusica() {
		int pos = (int) Math.random() * this.listMusica.size();
		this.listMusica.get(pos).reproduz();
		return this.listMusica.get(pos).getTitutlo();
	}

	public Duration getDuracao() {
		Duration soma = Duration.ofSeconds(0);
		int cont = 0;
		do {
			soma = this.listMusica.get(cont).getDuracao().plus(soma);
			cont = cont + 1;
		} while (cont < this.listMusica.size());
		return soma;
	}

	@Override
	public String toString() {
		int min = (int) getDuracao().toMinutes();
		int sec =  getDuracao().toSecondsPart();
		String tempTot = String.format("%dmim%02ds", min, sec);
		String tempTotcomHor = String.format("%02h%02dmim%02ds", min, sec);
		String musicas = "";
		int cont = 0;
		do {
			musicas = musicas + "[" + cont  + "] " + this.listMusica.get(cont) + "\n"; 
			cont++;
		} while (cont < this.listMusica.size());
		int tamanho = this.listMusica.size();
		return "Titulo da Playlist: " + this.titulo + "\nNumero de musicas: " + tamanho + "\nTempo de duracao: "
				+ tempTot + " (" + tempTotcomHor + ")" +"\nMusicas da playlist: \n" + musicas;
	}
	
}
