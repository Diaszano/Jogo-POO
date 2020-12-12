import java.util.ArrayList;

public class Jogo {

	public static void main(String[] args) {
		
		ArrayList <Humano> Humanos = new ArrayList<Humano>(100);
		ArrayList <Orc> Orcs = new ArrayList<Orc>(100);
		
		Menu.menu(Orcs,Humanos);
		Humanos.clear();
		Orcs.clear();
	}

}
