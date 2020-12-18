import java.util.ArrayList;
import java.util.Random;

public class Sorteio {
	//Aqui nos temos o padrao aonde foi solicitado no trabalho
	public void padrao(ArrayList <Orc> o, ArrayList <Humano> h) {
		Random aleatorio = new Random();
		
		for(int i = 0; i < 100; i++) {
			int orcNum = aleatorio.nextInt(3);
			int humanoNum = aleatorio.nextInt(3);
			addObjs(o,h,orcNum,humanoNum);
		}
	}
	public void padrao(ArrayList <Orc> o, ArrayList <Humano> h,int quantidade) {
		Random aleatorio = new Random();
		
		for(int i = 0; i < quantidade; i++) {
			int orcNum = aleatorio.nextInt(3);
			int humanoNum = aleatorio.nextInt(3);
			addObjs(o,h,orcNum,humanoNum);
		}
	}
	//Nesse nos nao ocorre de um personagem ter 2 na seguida
	//Mas se repete no jogo
	public void naoSequencia(ArrayList <Orc> o, ArrayList <Humano> h) {
		Random aleatorio = new Random();
		int orcAnt = -1;
		int humAnt = -1;
		int orcNum = 0;
		int humanoNum = 0;
		for(int i = 0; i < 100; i++) {
			do {
				orcNum = aleatorio.nextInt(3);
			}while(orcAnt == orcNum);
			orcAnt = orcNum;
			
			do {
				humanoNum = aleatorio.nextInt(3);
			}while(humAnt == humanoNum);
			humAnt = humanoNum;
			addObjs(o,h,orcNum,humanoNum);
		}
	}
	public void naoSequencia(ArrayList <Orc> o, ArrayList <Humano> h,int quantidade) {
		Random aleatorio = new Random();
		int orcAnt = -1;
		int humAnt = -1;
		int orcNum = 0;
		int humanoNum = 0;
		for(int i = 0; i < quantidade; i++) {
			do {
				orcNum = aleatorio.nextInt(3);
			}while(orcAnt == orcNum);
			orcAnt = orcNum;
			
			do {
				humanoNum = aleatorio.nextInt(3);
			}while(humAnt == humanoNum);
			humAnt = humanoNum;
			addObjs(o,h,orcNum,humanoNum);
		}
	}
	//Nesse eu fiz um random de 0 ate 99 para sortear a escolha do personagem
	public void zeroCem(ArrayList <Orc> o, ArrayList <Humano> h) {
		Random aleatorio = new Random();
		
		for(int i = 0; i < 100; i++) {
			int orcNum = aleatorio.nextInt(100);
			int humanoNum = aleatorio.nextInt(100);
			
			if(orcNum < 33) {
				orcNum = 0;
			}else if(orcNum <= 66) {
				orcNum = 2;
			}else {
				orcNum = 1;
			}
			if(humanoNum < 33) {
				humanoNum = 0;
			}else if(humanoNum <= 66) {
				humanoNum = 2;
			}else {
				humanoNum = 1;
			}
			addObjs(o,h,orcNum,humanoNum);
		}
	}
	public void zeroCem(ArrayList <Orc> o, ArrayList <Humano> h,int quantidade) {
		Random aleatorio = new Random();
		
		for(int i = 0; i < quantidade; i++) {
			int orcNum = aleatorio.nextInt(100);
			int humanoNum = aleatorio.nextInt(100);
			
			if(orcNum < 33) {
				orcNum = 0;
			}else if(orcNum <= 66) {
				orcNum = 2;
			}else {
				orcNum = 1;
			}
			if(humanoNum < 33) {
				humanoNum = 0;
			}else if(humanoNum <= 66) {
				humanoNum = 2;
			}else {
				humanoNum = 1;
			}
			addObjs(o,h,orcNum,humanoNum);
		}
	}
	//Nesse nao podera ter personagens que sao equivalentes para combater
	public void diferentes(ArrayList <Orc> o, ArrayList <Humano> h) {
		Random aleatorio = new Random();
		
		int orcNum = 0;
		int humanoNum = 0;
		for(int i = 0; i < 100; i++) {
			do {
				orcNum = aleatorio.nextInt(3);
				humanoNum = aleatorio.nextInt(3);
			}while(orcNum == humanoNum);
			
			addObjs(o,h,orcNum,humanoNum);
		}
	}
	public void diferentes(ArrayList <Orc> o, ArrayList <Humano> h, int quantidade) {
		Random aleatorio = new Random();
		
		int orcNum = 0;
		int humanoNum = 0;
		for(int i = 0; i < quantidade; i++) {
			do {
				orcNum = aleatorio.nextInt(3);
				humanoNum = aleatorio.nextInt(3);
			}while(orcNum == humanoNum);
			
			addObjs(o,h,orcNum,humanoNum);
		}
	}
	
	//Aqui eh aonde tem se atribui os personagens no vetor
	private void addObjs(ArrayList <Orc> o, ArrayList <Humano> h,int orcNum, int humanoNum) {
		switch(orcNum){
			case 0:
				o.add(new Ogro());
					break;
			case 1:
				o.add(new Mago());
					break;
			case 2:
				o.add(new Demonio());
					break;
		}
		switch(humanoNum){
			case 0:
				h.add(new Arqueiro());
					break;
			case 1:
				h.add(new Soldado());
					break;
			case 2:
				h.add(new Robo());
					break;
		}
	}
	
}
