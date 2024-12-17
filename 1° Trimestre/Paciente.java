//Integrantes: Amanda Rost e Joao Pedro dos Santos     		Turma: 201 INFO

public class Paciente {
	// atributos
	private String nome;
	private char sexo;
	private double peso;
	private int idade;
	private double altura;

	// construtores

	public Paciente(String nome, char genero) {
		this.nome = nome;
		this.setSexo(genero);
	}

	public Paciente(String nome, char genero, double kg, int tempoVida, double metro) {
		this(nome, genero);
		this.peso = this.ifNum(kg);
		this.setIdade(tempoVida);
		this.setAltura(metro);
	}

	// metodos pedidos

	public void engorda(double valor) {
		ifNum(valor);

		this.peso = this.peso + valor;
	}

	public void emagrece(double valor) {
		ifNum(valor);

		this.peso = this.peso - valor;

		if (this.peso < 0)
			this.peso = 0;
	}

	public double getImc() {
		return this.peso / (this.altura * this.altura);
	}

	public double getPercentualGordura() {
		int sexoInt;

		if (this.sexo == 'M')
			sexoInt = 0;

		else
			sexoInt = 1;

		return (1.20 * this.getImc()) + (0.23 * this.idade) - (sexoInt * 10.8) - 5.4;
	}

	public String getImcStatus() {
		String StatusIMC = "Voce está muito mal";

		if (this.getImc() < 18.5)
			StatusIMC = "Magreza";

		else if (this.getImc() <= 18.5 || this.getImc() < 24.9)
			StatusIMC = "Regular";

		else if (this.getImc() <= 24.9 || this.getImc() < 30)
			StatusIMC = "Sobrepeso";

		else if (this.getImc() >= 30)
			StatusIMC = "Obesidade";

		return StatusIMC;
	}

	public String paraString() {
		if (this.sexo == '0')
			this.sexo = 'M';

		else if (this.sexo == '1')
			this.sexo = 'F';
		return "\n Nome: " + this.nome + "\n Sexo: " + this.sexo + "\n Altura: " + this.altura + "\n Peso: " + this.peso
				+ "\n Idade: " + this.idade + "\n IMC: " + this.getImc() + "\n Status do IMC: " + this.getImcStatus()
				+ "\n Percentual de gordura: " + this.getPercentualGordura();
	}

	// getters dos atributos

	public String getNome() {
		return this.nome;
	}

	public char getSexo() {
		return this.sexo;
	}

	public double getPeso() {
		return this.peso;
	}

	public int getIdade() {
		return this.idade;
	}

	public double getAltura() {
		return this.altura;
	}
	// setters dos atributos

	public void setSexo(char let) {
		if (let == 'M' || let == 'F')
			this.sexo = let;
	}

	public void setIdade(int num) {
		this.ifNum(num);

		this.idade = num;
	}

	public void setAltura(double num) {
		this.ifNum(num);
		this.altura = num;
	}

	// metodo para meu uso

	private double ifNum(double num) {
		if (num > 0)
			return num;
		else
			return num = 0;
	}
}
