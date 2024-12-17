

import java.util.Objects;
import java.util.Scanner;
import java.time.Duration;
public class SpotiFake {
 
	public static String menu() {
		return "       Menu"
				+ "\n(0) sair \r\n"
				+ "(1) adiciona musica \r\n"
				+ "(2) remover musica \r\n"
				+ "(3) busca musica \r\n"
				+ "(4) toca musica\r\n"
				+ "(5) toca musica random \r\n"
				+ "(6) duracao playlist\r\n"
				+ "(7) infos playlist \n"
				+ "Digite o numero da opcao que queira escolher: ";
	}
	
	public static int duracao (int mim, int seg) {
		return (mim * 60) + seg;
	}
	
	public static void main(String args[]) {
		Scanner tec = new Scanner (System.in);
		Musica mus = null;
		System.out.println("Qual o nome da sua Playlist?");
		String nomePlay = tec.nextLine();
		
		Playlist play = new Playlist(nomePlay);
		
		int resp = 0;
		do {
			System.out.println(menu());
			resp = tec.nextInt();
			
			if(resp == 1) {
				System.out.println("Qual eh o nome da musica?");
				String titulo = tec.nextLine();
				titulo = tec.nextLine();
				System.out.println("Qual eh o interprete?"); 
				String interprete = tec.nextLine();
				
				System.out.println("Quantos minutos tem essa musica?");
				int mim = tec.nextInt();
				
				System.out.println("Quantos segudos tem essa musica?");
				int seg = tec.nextInt();
				int total = duracao(mim,seg);
				Duration duracao = Duration.ofSeconds(total);
				mus = new Musica(titulo, interprete, duracao, 0);
				
				play.addMusica(mus);
			}
			
			if(resp == 2 || resp == 3 || resp == 4 || resp == 5) {
				Objects.requireNonNull(mus, "A playlist precisa ter pelo menos uma musica");
				if(resp == 2) {
					System.out.println("Qual eh a posicao que esta a musica que voce deseja retirar?");
					int posicao = tec.nextInt();
					play.removeMusica(posicao);
				}else if(resp == 3) {
					System.out.println("Qual eh a posicao da musica que voce esta procurando?");
					int posicao = tec.nextInt();
					System.out.println(play.getMusica(posicao));
				}else if(resp == 4) {
					System.out.println("Qual eh a posicao da musica que voce deseja escutar?");
					int posicao = tec.nextInt();
					System.out.println(play.tocaMusica(posicao));
				}else if(resp == 5) 
					System.out.println("Ta tocando: " + play.tocaMusica());
			}else if(resp == 6) {
				int hor = play.getDuracao().toHoursPart();
				int min = play.getDuracao().toMinutesPart();
				int sec = play.getDuracao().toSecondsPart();
				String tempTot = String.format("%02d:%02d:%02d", hor, min, sec);	
				System.out.println("O tempo total da sua playlist eh de: " + tempTot);
			}else if(resp == 7) {
				System.out.println("    Informacoes da Playlist\n" + play.toString());
			}else if (resp == 0) {
				System.out.println("Tem certeza que deseja sair? Sim ou Nao");
				String tex = tec.nextLine();
				tex = tec.nextLine();	
					if(tex.toLowerCase().contentEquals("sim") ) 
						System.out.println("Obrigada por usar o nosso app :D");
					
					else {
						System.out.println("Que bomm que deseja continuar conosco :D");
						resp = 1;
					}
			} else
					throw new IllegalArgumentException("Voce deve escolher uma das opicoes do menu !!!");

		}while (resp != 0);
		
		
	}
}
