//Integrantes: Amanda Rost e Joao Pedro dos Santos    	 Turma: 201 INFO 

public class TestaPaciente {
	public static void main(String args[]) {
		Paciente p = new Paciente("Amanda", 'F', 57, 16, 1.52);

		/*
		 * o construtor com 2 parametros esta dentro do construtor com 5 parametro, por
		 * isso testando o de 5 testo o de 2, também é o teste dos getteres, dos
		 * setteres de todos os atributos e do ifNum
		 */

		System.out.println("TESTE DOS CONSTRUTORES");
		System.out.println(p.getNome().equals("Aline"));// false
		System.out.println(p.getNome().equals("Amanda"));// true
		System.out.println(p.getSexo() == '1');// false
		System.out.println(p.getSexo() == 'F');// true
		System.out.println(p.getSexo() == 'f');// false
		System.out.println(p.getPeso() == 57);// true
		System.out.println(p.getPeso() == 60);// false
		System.out.println(p.getIdade() == 15);// false
		System.out.println(p.getIdade() == 16);// true
		System.out.println(p.getAltura() == 1.95);// false
		System.out.println(p.getAltura() == 1.52);// true

		// TESTE DO engorda(double)

		p.engorda(3);
		System.out.println(p.getPeso() == 60);// true
		System.out.println(p.getPeso() == 57);// false
		p.engorda(40);
		System.out.println(p.getPeso() == -1);// false
		System.out.println(p.getPeso() == 100);// true

		// TESTE DO emagrece(double)

		p.emagrece(58);
		System.out.println(p.getPeso() == 100);// false
		System.out.println(p.getPeso() == 42);// true
		p.emagrece(43);
		System.out.println(p.getPeso() == -1);// true
		System.out.println(p.getPeso() == 0);// false

		// TESTE DO getImc()
		System.out.println(p.getImc() == 0);// true
		p.engorda(58);
		System.out.println(p.getImc() == 25.10387811634349);// true
		System.out.println(p.getImc() == 24.1038781163);// false

		// TESTE DO getPercentualGordura()

		System.out.println(p.getPercentualGordura() == 17.60465373961219);// true
		System.out.println(p.getPercentualGordura() == 17.88888);// false

		// TESTE DO paraString()

		System.out.println(p.paraString()
				.equals("\n Nome: " + p.getNome() + "\n Sexo: " + p.getSexo() + "\n Altura: " + p.getAltura()
						+ "\n Peso: " + p.getPeso() + "\n Idade: " + p.getIdade() + "\n IMC: " + p.getImc()
						+ "\n Percentual de gordura: " + p.getPercentualGordura()));// true
		System.out.println(
				p.paraString().equals("\n Nome: " + "Alice" + "\n Sexo: " + 'M' + "\n Altura: " + 1.53 + "\n Peso: " + 0
						+ "\n Idade: " + 15 + "\n IMC: " + 24.1038781163 + "\n Percentual de gordura: " + 17.88888));// false

		// TESTE DO getImcStatus()

		System.out.println(p.getImcStatus().equals("Sobrepeso"));// true
		System.out.println(p.getImcStatus().equals("Regular"));// false

	}
}
