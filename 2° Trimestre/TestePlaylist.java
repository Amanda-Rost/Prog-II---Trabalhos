//Dupla: Amanda Rost e Anna Borges - 201 INFO
import java.time.Duration;

public class TestePlaylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String titulo = "Era uma vez", interprete = "Kell Smith";
		Duration duracao = Duration.ofSeconds(225);
		int rep = 358;
		Musica mus = new Musica(titulo, interprete, duracao, rep); 
		
		String titulo2 = "Trem bala", interprete2 = "Ana";
		Duration duracao2 = Duration.ofSeconds(240);
		int rep2 = 35;
		Musica mus2 = new Musica(titulo2, interprete2, duracao2, rep2); 
		
		Playlist pla = new Playlist("Bons momentos!!!");
		
		System.out.println(pla.getTitulo().equals("Bons momentos!!!"));
		pla.addMusica(mus);
		System.out.println(pla.tocaMusica().equals(titulo));
		pla.addMusica(mus2);
		pla.addMusica(mus);
		System.out.println(pla.getMusica(0).equals(mus));
		System.out.println(pla.getMusica(1).equals(mus2));
		System.out.println(pla.getMusica(2).equals(mus));
		System.out.println(pla.removeMusica(2).equals(mus));
		System.out.println(pla.tocaMusica(0).equals(titulo));
		
		System.out.println(pla.getDuracao().equals(duracao.plus(duracao2)));
		System.out.println(pla.toString().equals("Titulo da Playlist: Bons momentos!!!\r\n"
				+ "Numero de musicas: 2\r\n"
				+ "Tempo de duracao: 7mim45s\r\n"
				+ "Musicas da playlist: \r\n"
				+ "[0] Musica: Era uma vez (3:45) - Kell Smith [360 tocadas]\r\n"
				+ "[1] Musica: Trem bala (4:00) - Ana [35 tocadas]"));
		System.out.println(pla.toString());
	}

}
