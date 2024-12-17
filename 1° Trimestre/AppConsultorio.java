//Integrantes: Amanda Rost e Joao Pedro dos Santos   Turma:201 INFO

import java.util.Scanner;

public class AppConsultorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner tec = new Scanner(System.in);

		Paciente p = null;

		int resp, resp2 = 0;
		do {
			System.out.println("        Menu\r\n" + "(0) sair \r\n" + "(1) cadastra paciente");
			System.out.println("\n Qual das opicoes deseja escolher:");
			resp = tec.nextInt();

			if (resp == 1) {
				System.out.println("Preencher com os dados do paciente!!!\n Qual eh o nome?");
				String nom = tec.nextLine();
				nom = tec.nextLine();

				System.out.println("Qual eh o sexo?(digite F para FEMININO e M para MASCULINO)");
				char ger = tec.nextLine().charAt(0);

				System.out.println("Qual eh a altura?");
				double alt = tec.nextDouble();

				System.out.println("Qual eh a idade?");
				int ida = tec.nextInt();

				System.out.println("Qual eh o peso?");
				double pes = tec.nextDouble();

				p = new Paciente(nom, ger, pes, ida, alt);
				resp2 = 0;
			}

			if (resp == 0) {
				System.out.println("Tem certeza que seja sair?");
				String cert = tec.nextLine();
				cert = tec.nextLine();
				if (cert == "Sim" || cert == "SIM" || cert == "sim")
					resp2 = 1;
				else
					resp2 = 0;
			}

		} while (resp2 != 0);

		if (p != null) {
			do {
				System.out.println("\n\n        Menu\r\n" + "(0) sair \r\n" + "(1) cadastra paciente \r\n"
						+ "(2) emagrecer\r\n" + "(3) engordar\r\n" + "(4) valor IMC \r\n"
						+ "(5) valor Percentual de Gordura \r\n" + "(6) infos paciente ");
				System.out.println("\n\n Qual das opcoes deseja escolher:");
				resp = tec.nextInt();

				if (resp == 1) {
					System.out.println("Preencher com os dados do paciente!!!\n Qual eh o nome?");
					String nom = tec.nextLine();
					nom = tec.nextLine();

					System.out.println("Qual eh o sexo?(digite F para FEMININO e M para MASCULINO)");
					char ger = tec.nextLine().charAt(0);

					System.out.println("Qual eh a altura?");
					double alt = tec.nextDouble();

					System.out.println("Qual eh a idade?");
					int ida = tec.nextInt();

					System.out.println("Qual eh o peso?");
					double pes = tec.nextDouble();

					p = new Paciente(nom, ger, pes, ida, alt);
				}

				if (resp == 2) {
					System.out.println("Quanto o paciente emagreceu?");
					double pes = tec.nextDouble();
					p.emagrece(pes);
				}
				if (resp == 3) {
					System.out.println("Quanto o paciente engordou?");
					double pes2 = tec.nextDouble();
					p.engorda(pes2);
				}
				if (resp == 4)
					System.out.println(
							"O valor do IMC do paciente eh: " + p.getImc() + " \n Status do IMC: " + p.getImcStatus());

				if (resp == 5)
					System.out.println("O valor do percentual de gordura eh: " + p.getPercentualGordura());

				if (resp == 6)
					System.out.println("Informacoes do Paciente:" + p.paraString());

			} while (resp != 0);

		} else if (p == null)
			System.out.println("\nVoce nao cadastrou um paciente :(");

		System.out.println("\nMuito obrigado por usar o nosso app S2 S2 S2 !!!");
	}

}
