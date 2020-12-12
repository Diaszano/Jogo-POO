import java.util.ArrayList;
import java.util.Random;

public class Batalha {
//Modulo de batalhas
//**************************************************************************************************************************************
	//Esse eh o padrao, aonde se escolhe a quantidade de rodadas e qual a forma de vitoria
	public static void rodadas(ArrayList <Orc> o, ArrayList <Humano> h, int rodadas, int opcVitoria, int informacao) {
		
		boolean resultadoFinalPardida = false;
		boolean resultadoTotal = false;
		boolean resultadoPassoPasso = false;
		
		switch(informacao) {
		  case 1:
			resultadoFinalPardida = true;
			resultadoTotal = true;
			resultadoPassoPasso = true;
				break;
		  case 2:
			resultadoTotal = true;
			resultadoFinalPardida = true;
				break;
		  case 3:
			resultadoTotal = true;
			break;
		}
		
		for(int i = 0; i < o.size(); i++) {
			Orc orc = o.get(i);
			Humano humano = h.get(i);
			
			int j = 0;		
			boolean vencedor = false;
			
			if(resultadoPassoPasso) {
				System.out.println("Luta numero " + (i+1));
				System.out.println();
			}
			if(humano.getInteligencia() != orc.getForca()) {
				while(!vencedor) {
					golpe(orc,humano,resultadoPassoPasso);
					if(orc.getVida() == 0) {
						vencedor = true;
					}else if(humano.getVida() == 0) {
						vencedor = true;
					}
					j++;
					if(j == rodadas || vencedor){
						vencedor = true;
					}
				}
			}
			if(resultadoPassoPasso) {
				System.out.println();
			}
		}
		
		switch(opcVitoria) {
		  case 1:
			  rodadasVivos(o,h,resultadoFinalPardida,resultadoTotal);
			  	break;
		  case 2:
			  rodadasVida(o,h,resultadoFinalPardida,resultadoTotal);
			  	break;
		  case 3:
			  rodadasVivos(o,h,resultadoFinalPardida,resultadoTotal);
			  rodadasVida(o,h,resultadoFinalPardida,resultadoTotal);
			  	break;
		}
	}
	
	public static void rodadas(ArrayList <Orc> o, ArrayList <Humano> h, int informacao) {
		
		boolean resultadoFinalPardida = false;
		boolean resultadoTotal = false;
		boolean resultadoPassoPasso = false;
		
		switch(informacao) {
		  case 1:
			resultadoFinalPardida = true;
			resultadoTotal = true;
			resultadoPassoPasso = true;
				break;
		  case 2:
			resultadoTotal = true;
			resultadoFinalPardida = true;
				break;
		  case 3:
			resultadoTotal = true;
			break;
		}
		
		for(int i = 0; i < o.size(); i++) {
			Orc orc = o.get(i);
			Humano humano = h.get(i);
			
			if(resultadoPassoPasso) {
				System.out.println("Luta numero " + (i+1));
				System.out.println();
			}
			if(humano.getInteligencia() != orc.getForca()) {
					golpe(orc,humano,resultadoPassoPasso);
			}
			if(resultadoPassoPasso) {
				System.out.println();
			}
		}
		
		rodadasVida(o,h,resultadoFinalPardida,resultadoTotal);
	}
	
	//Esse eh aonde tem a luta ate a morte do oponente
	public static void morte(ArrayList <Orc> o, ArrayList <Humano> h, int informacao) {
		
		boolean resultadoFinalPardida = false;
		boolean resultadoTotal = false;
		boolean resultadoPassoPasso = false;
		
		switch(informacao) {
		  case 1:
			resultadoFinalPardida = true;
			resultadoTotal = true;
			resultadoPassoPasso = true;
				break;
		  case 2:
			resultadoTotal = true;
			resultadoFinalPardida = true;
				break;
		  case 3:
			resultadoTotal = true;
			break;
		}
		
		for(int i = 0; i < o.size(); i++) {
			Orc orc = o.get(i);
			Humano humano = h.get(i);
			boolean vencedor = false;
			if(resultadoPassoPasso) {
				System.out.println("Luta numero " + (i+1));
				System.out.println();
			}
			if(humano.getInteligencia() != orc.getForca()) {
				while(!vencedor) {
					golpe(orc,humano,resultadoPassoPasso);
					if(orc.getVida() == 0) {
						vencedor = true;
					}else if(humano.getVida() == 0) {
						vencedor = true;
					}
				}
			}
			if(resultadoPassoPasso) {
				System.out.println();
			}
		}
		rodadasVivos(o,h,resultadoFinalPardida,resultadoTotal);
	}
	//Ja com essa eh aonde tem a luta aleatoria dos poderes
	public static void lutaAleatoria(ArrayList <Orc> o, ArrayList <Humano> h ,int informacao) {
		
		boolean resultadoFinalPardida = false;
		boolean resultadoTotal = false;
		boolean resultadoPassoPasso = false;
		
		switch(informacao) {
		  case 1:
			resultadoFinalPardida = true;
			resultadoTotal = true;
			resultadoPassoPasso = true;
				break;
		  case 2:
			resultadoTotal = true;
			resultadoFinalPardida = true;
				break;
		  case 3:
			resultadoTotal = true;
			break;
		}
		for(int i = 0; i < o.size(); i++) {
			Orc orc = o.get(i);
			Humano humano = h.get(i);
			boolean vencedor = false;
			if(resultadoPassoPasso) {
				System.out.println("Luta numero " + (i+1));
				System.out.println();
			}
			while(!vencedor) {
				
				if(humano.getInteligencia() != orc.getForca()) {	
					golpe(orc,humano,resultadoPassoPasso,false);
				}else {
					golpe(orc,humano,resultadoPassoPasso,true);
				}
				if(orc.getVida() == 0) {
					vencedor = true;
				}else if(humano.getVida() == 0) {
					vencedor = true;
				}
			}
			if(resultadoPassoPasso) {
				System.out.println();
			}
		}
		rodadasVivos(o,h,resultadoFinalPardida,resultadoTotal);
	}
//**************************************************************************************************************************************
//Parte aonde mostra o resultado
//**************************************************************************************************************************************
	//Calcula quem venceu a partida por ter mais pessoas vivas
	private static void rodadasVivos(ArrayList <Orc> o, ArrayList <Humano> h,boolean resultadoFinalPardida,boolean resultadoTotal) {
		Orc orc = o.get(0);
		Humano humano = h.get(0);
		
		for(int i = 0; i < o.size();i++) {
			orc = o.get(i);
			humano = h.get(i);
			if(humano.getVida() > 0) {
				humano.setTotalVivos();
			}
			if(orc.getVida() > 0) {
				orc.setTotalVivos();
			}
			if(resultadoFinalPardida) {
				String resultadoTotalLocal = new String();
				int lifeH = humano.getVida();
				int lifeO = orc.getVida();
				if(lifeH > 0 && lifeO == 0) {
					resultadoTotalLocal ="O " + humano.toString() + " ganhou a batalha com " + String.valueOf(humano.getVida()) +
					" de vida do " + orc.toString();
					
				}else if(lifeH == 0 && lifeO > 0) {
					resultadoTotalLocal ="O " + orc.toString() + " ganhou a batalha com " + String.valueOf(orc.getVida()) +
					" de vida do " + humano.toString();
					
				}else {
					resultadoTotalLocal = "O " + orc.toString() + " que tinha " + String.valueOf(orc.getVida()) + " de vida empatou com o " + 
					humano.toString() + " que tinha " + String.valueOf(humano.getVida()) + " de vida. ";
				}
				System.out.println(resultadoTotalLocal);
			}
		}
		int humanosMortos = o.size() - humano.getTotalVivos();
		int orcsMortos = o.size() - orc.getTotalVivos();
		String resultado = new String();
		if(humanosMortos < orcsMortos ) {
			resultado = "Os Humanos ganharam com " + String.valueOf(humano.getTotalVivos()) + " vivos e mataram " + String.valueOf(orcsMortos) + " Orcs";
		}else if(humanosMortos > orcsMortos) {
			resultado = "Os Orcs ganharam com " + String.valueOf(orc.getTotalVivos()) + " vivos e mataram " + String.valueOf(humanosMortos) + " Humanos";
		}else {
			resultado = "Os Orcs e Humanos emparatam com " + String.valueOf(orc.getTotalVivos()) + " vivos e mataram " + String.valueOf(humanosMortos) + " inimigos";
		}
		if(resultadoTotal) {
			System.out.println(resultado);
		}
	}
	//Calcula quem venceu a partida por ter mais vida ao total
	private static void rodadasVida(ArrayList <Orc> o, ArrayList <Humano> h,boolean resultadoFinalPardida,boolean resultadoTotal) {
		int humanosVida = 0;
		int orcsVida = 0;
		for(int i = 0; i < o.size();i++) {
			Orc orc = o.get(i);
			Humano humano = h.get(i);
			
			int lifeH = humano.getVida();
			int lifeO = orc.getVida();
			
			orc.setTotalVida(orc.getTotalVida() + lifeO);
			humano.setTotalVida(humano.getTotalVida() + lifeH);
			
			if(resultadoFinalPardida) {
				String resultadoTotalLocal = new String();
				
				if(lifeH > lifeO) {
					resultadoTotalLocal ="O " + humano.toString() + " ganhou a batalha com " + String.valueOf(lifeH) +
					" de vida, mas ja o " + orc.toString() + " ficou com "+ String.valueOf(lifeO) + " de vida";
					
				}else if(lifeH < lifeO) {
					resultadoTotalLocal ="O " + orc.toString() + " ganhou a batalha com " + String.valueOf(lifeO) +
					" de vida, mas ja o " + humano.toString() + " ficou com "+ String.valueOf(lifeH) + " de vida";
					
				}else {
					resultadoTotalLocal ="O " + orc.toString() + "tinha a mesma quantidade de vida que o " + humano.toString();
				}
				System.out.println(resultadoTotalLocal);
			}
			humanosVida = humano.getTotalVida();
			orcsVida = orc.getTotalVida();
		}
		
		String resultado = new String();
		if(humanosVida > orcsVida) {
			resultado = "Os Humanos ganharam com " + String.valueOf(humanosVida) + " de vida e os Orcs ficaram com " + String.valueOf(orcsVida) + " de vida";
		}else if(humanosVida < orcsVida) {
			resultado = "Os Orcs ganharam com " + String.valueOf(orcsVida) + " de vida e os Humanos ficaram com " + String.valueOf(humanosVida) + " de vida";
		}else {
			resultado = "Os Orcs e Humanos emparatam com " + String.valueOf(humanosVida) + " vida e os Orcs tambem ficaram com " + String.valueOf(orcsVida) + " de vida";
		}
		
		if(resultadoTotal) {
			System.out.println(resultado);
		}
	}
//**************************************************************************************************************************************
//Parte aonde se eh feito o calculo e desconto dos golpes
//**************************************************************************************************************************************
	//Esse calcula somente de forma aleatoria
	private static void golpe(Orc orc, Humano humano, boolean resultadoPassoPasso, boolean iguais) {
		Random aleatorio = new Random();
		
		int orcAle = 0;
		int humAle = 0;
		int orcPoder = 0;
		int humanoPoder = 0;
		
		if(iguais) {
			do {
				 orcAle = aleatorio.nextInt(30);
				 humAle = aleatorio.nextInt(30);
			}while(orcAle == humAle);
		}
		if(orcAle < 10) {
			orcPoder = orc.getForca();
			if(resultadoPassoPasso) {
				System.out.print("O golpe foi de Forca ( "+ orc.getForca());
			}
		}else if(orcAle >= 20) {
			orcPoder = orc.getAgilidade();
			if(resultadoPassoPasso) {
				System.out.print("O golpe foi de Agilidade ( "+ orc.getAgilidade());
			}
		}else {
			orcPoder = orc.getHabilidade();
			if(resultadoPassoPasso) {
				System.out.print("O golpe foi de Habilidade ( "+ orc.getHabilidade());
			}
		}
		
		if(humAle < 10) {
			humanoPoder = humano.getInteligencia();
			if(resultadoPassoPasso) {
				System.out.println(" ) contra Inteligancia ( "+ humano.getInteligencia() + " )");
			}
		}else if(humAle >= 20) {
			humanoPoder = humano.getEquipamentos();
			if(resultadoPassoPasso) {
				System.out.println(" ) contra Equipamentos ( "+ humano.getEquipamentos() + " )");
			}
		}else {
			humanoPoder = humano.getVelocidade();
			if(resultadoPassoPasso) {
				System.out.println(" ) contra Velocidade ( "+ humano.getVelocidade() + " )");
			}
		}
		
		orc.setVida(orcPoder,humanoPoder);
		humano.setVida(humanoPoder,orcPoder);
		
		if(resultadoPassoPasso) {
			System.out.println(orc.toString() + " tem de vida " + orc.getVida());
			System.out.println(humano.toString() + " tem de vida " + humano.getVida());
		}
	}
	//Ja esse eh o calculo padrao dos golpes que sao dados no oponente 
	private static void golpe(Orc orc, Humano humano, boolean resultadoPassoPasso) {
		Random aleatorio = new Random();
		
		int numAle = aleatorio.nextInt(30);
		int orcPoder = 0;
		int humanoPoder = 0;
		if(numAle < 10) {
			orcPoder = orc.getForca();
			humanoPoder = humano.getInteligencia();
			if(resultadoPassoPasso) {
				System.out.println("O golpe foi de Forca ( "+ orcPoder +" ) contra Inteligancia ( "+ humanoPoder + " )");
			}
		}else if(numAle >= 20) {
			orcPoder = orc.getAgilidade();
			humanoPoder = humano.getEquipamentos();
			if(resultadoPassoPasso) {
				System.out.println("O golpe foi de Agilidade ( "+ orcPoder +" ) contra Equipamentos ( "+ humanoPoder + " )");
			}
		}else {
			orcPoder = orc.getHabilidade();
			humanoPoder = humano.getVelocidade();
			if(resultadoPassoPasso) {
				System.out.println("O golpe foi de Habilidade ( "+ humanoPoder +" ) contra Velocidade ( "+ orcPoder + " )");
			}
		}
		
		orc.setVida(orcPoder,humanoPoder);
		humano.setVida(humanoPoder,orcPoder);
		
		if(resultadoPassoPasso) {
			System.out.println(orc.toString() + " tem de vida " + orc.getVida());
			System.out.println(orc.toString() + " tem de vida " + orc.getVida());
		}
		
	}
//**************************************************************************************************************************************
}

