import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
//Esses lidam com a impressao dos menus
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	//funcao criada pra meio q limpar a tela
	//ela na verdade soh empurra tudo pra onde nn podemos ver
	private static void limpaTela() {
		for (int i=0; i<50; i++){
			System.out.println();
		}
	}
	//Introducao do jogo
	private  void inicio() {
		System.out.println("Ola, seja bem vindo ao jogo!");
		System.out.println("Este jogo eh um jogo de cartas virtual " +
						   "simples, tipo RPG de cartas ou Supertrunfo, " + 
						   "inspirado no World of Warcraft.");
		System.out.println("Nele tera a grande batalha dos Humanos x Orcs, quem sera que vai vencer?");
		System.out.println("Facam as suas apostas e se divirtam! ");
	}
	//Menu com as informacoes primarias
	private void imprimir() {
		System.out.println("Escolha as opcoes abaixo para comecar a jogar: ");
		System.out.println("1 - Modo classico");
		System.out.println("2 - Modo Ate a Morte");
		System.out.println("3 - Modo Rodadas 10");
		System.out.println("4 - Modo Golpes Aleatorios");
		System.out.println("5 - Outros Modos (Avancado)");
		System.out.println("6 - Sair ");
	}
	//Menu mais avancado
	private void avancadoImprimir() {
		System.out.println("Escolha as opcoes abaixo para comecar a jogar: ");
		System.out.println("1 - Rodadas");
		System.out.println("2 - Ate a morte");
		System.out.println("3 - Golpes aleatorios");
		System.out.println("4 - Voltar ao menu ");
	}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Esses lidam com a entrada de valores para o menu
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Nesse tem a entrada do numero de vezes que vai ter a rodada na batalha
	private int rodadasNum(Scanner scanf) {
		int rodadas = 0;
		
		do {
			System.out.println("Digite a quantidade de rodadas que tu queres: ");
			rodadas = scanf.nextInt();
		}while(rodadas <= 0 || rodadas >= 100000000);
		
		return rodadas;
	}
	//Nesse tem a entrada para escolher a quantidade de informacao que vai aparecer
	private int informacaoNum(Scanner scanf) {
		int informacao = 0;
		
		do {
			System.out.println("Digite a quantidade de informacao que tu queres: ");
			System.out.println("1 - Mostrar todos os dados");
			System.out.println("2 - Mostar resumidamente tudo");
			System.out.println("3 - So o resultado final");
			informacao = scanf.nextInt();
		}while(informacao <= 0 || informacao > 3);
		
		return informacao;
	}
	//Nesse tem a entrada para escolher como sera determinada a vitoria
	private int vitoriaNum(Scanner scanf) {
		int vitoria = 0;
		
		do {
			System.out.println("Ter como vitoria: ");
			System.out.println("1 - Matar mais inimigos");
			System.out.println("2 - Saldo de vida");
			vitoria = scanf.nextInt();
		}while(vitoria <= 0 || vitoria > 2);
		
		return vitoria;
	}
	//Nesse tem a entrada para escolher como sera determinada a vitoria
		private int quantidadePersonagemNum(Scanner scanf) {
			int quantidade = 0;
			
			do {
				System.out.println("Tu deseja quandos personagens: ");
				quantidade = scanf.nextInt();
			}while(quantidade <= 0 || quantidade >= 100000000);
			
			return quantidade;
		}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Esses lidam com a "Logica" do menu
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	//Esse lida com o menu inicial de escolha do jogo 
	private void principal(Scanner scanf, ArrayList <Orc> o, ArrayList <Humano> h) {
		int opc = 0;
		Batalha batalha = new Batalha();
		do {
				imprimir();
				opc = scanf.nextInt();
				limpaTela();
				criacaoVetor(o,h,1);
				switch(opc) {
				  case 1:
					  batalha.rodadas(o,h,2);
					  scanf.nextLine();
					  scanf.nextLine();
					  limpaTela();
						break;
				  case 2:
					  batalha.morte(o,h,2);
					  scanf.nextLine();
					  scanf.nextLine();
					  limpaTela();
						break;
				  case 3:
					  batalha.rodadas(o,h,10,2,2);
					  scanf.nextLine();
					  scanf.nextLine();
					  limpaTela();
					  	break;
				  case 4:
					  batalha.lutaAleatoria(o,h,2);
					  scanf.nextLine();
					  scanf.nextLine();
					  limpaTela();
					  	break;
				  case 5:
					  avancado(scanf,o,h);
					  scanf.nextLine();
					  limpaTela();
					  	break;
				}
				o.clear();
				h.clear();
		}while(opc != 6);
	}
	//Ja esse lida com o menu um pouco mais avancado de escolha do jogo 
	private void avancado(Scanner scanf, ArrayList <Orc> o, ArrayList <Humano> h) {
		int opc = 0;
		o.clear();
		h.clear();
		do {
				avancadoImprimir();
				opc = scanf.nextInt();
				limpaTela();
				switch(opc) {
				  case 1:
					  rodadasmenu(scanf,o,h);
					  scanf.nextLine();
					  scanf.nextLine();
					  limpaTela();
						break;
				  case 2:
					  morteImp(scanf,o,h);
					  scanf.nextLine();
					  scanf.nextLine();
					  limpaTela();
						break;
				  case 3:
					  lutaAleatoriaImp(scanf,o,h);
					  scanf.nextLine();
					  scanf.nextLine();
					  limpaTela();
						break;
				}
				o.clear();
				h.clear();
		}while(opc != 4);
	}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
//Esses lidam com a chamada do jogo
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Esse chama o as luatas aleatorias
	// Na luta aleatoria ele nao faz o combate pelos [(1-1),(2-2),(3-3)], mas sim n-n
	private void lutaAleatoriaImp(Scanner scanf, ArrayList <Orc> o, ArrayList <Humano> h) {
		Batalha batalha = new Batalha();
		criacaoVetor(o,h,criacaoVetorNum(scanf),quantidadePersonagemNum(scanf));
		
		batalha.lutaAleatoria(o,h,informacaoNum(scanf));
	}
	//Esse chama a luta ate a morte
	private void morteImp(Scanner scanf, ArrayList <Orc> o, ArrayList <Humano> h) {
		Batalha batalha = new Batalha();
		criacaoVetor(o,h,criacaoVetorNum(scanf),quantidadePersonagemNum(scanf));
		
		batalha.morte(o,h,informacaoNum(scanf));
	}
	//Nesse ja eh o mais dinamico do jogo, aonde podemos escolher tanto a quantidade de rodadas
	// e tambem como se dara o resultado
	private void rodadasmenu(Scanner scanf, ArrayList <Orc> o, ArrayList <Humano> h) {
		Batalha batalha = new Batalha();
		criacaoVetor(o,h,criacaoVetorNum(scanf),quantidadePersonagemNum(scanf));
		
		batalha.rodadas(o,h,rodadasNum(scanf),vitoriaNum(scanf),informacaoNum(scanf));
	}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Esses lidam com a criacao e manipulacao do vetor
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Aonde eu obtenho o da criacao do vetor
	private int criacaoVetorNum(Scanner scanf) {
		int vetor = 0;
		
		do {
			System.out.println("A ordenacao do vetor vai ser");
			System.out.println("1 - Padrao");
			System.out.println("2 - Sem repeticao");
			System.out.println("3 - De 0 a 100");
			System.out.println("4 - Oponentes Diferentes");
			vetor = scanf.nextInt();
		}while(vetor <= 0 || vetor > 4);
		
		return vetor;
	}
	
	//Escolhe a opcao da criacao do vetor 
	private void criacaoVetor(ArrayList <Orc> o, ArrayList <Humano> h, int vetor) {
		Sorteio sorteio = new Sorteio();
		switch(vetor) {
		  case 1:
			  sorteio.padrao(o, h);
				break;
		  case 2:
			  sorteio.naoSequencia(o, h);
				break;
		  case 3:
			  sorteio.zeroCem(o, h);
			  	break;
		  case 4:
			  sorteio.diferentes(o, h);
			  break;
		}
	}
	private void criacaoVetor(ArrayList <Orc> o, ArrayList <Humano> h, int vetor, int quantidade) {
		Sorteio sorteio = new Sorteio();	
		switch(vetor) {
			  case 1:
				  sorteio.padrao(o, h, quantidade);
					break;
			  case 2:
				  sorteio.naoSequencia(o, h, quantidade);
					break;
			  case 3:
				  sorteio.zeroCem(o, h, quantidade);
				  	break;
			  case 4:
				  sorteio.diferentes(o, h, quantidade);
				  	break;
			}
	}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
//Lida com o menu do jogo
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//Menu aonde do jogo
	public void menu(ArrayList <Orc> o, ArrayList <Humano> h) {
		Scanner scanf = new Scanner(System.in);
		inicio();
		scanf.nextLine();
		limpaTela();
		principal(scanf,o,h);
		scanf.close();
	}	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
}
