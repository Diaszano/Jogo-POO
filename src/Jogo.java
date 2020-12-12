import java.util.ArrayList;

public class Jogo {

	public static void main(String[] args) {
		
		ArrayList <Humano> Humanos = new ArrayList<Humano>();
		ArrayList <Orc> Orcs = new ArrayList<Orc>();
		
		Menu.menu(Orcs,Humanos);
		Humanos.clear();
		Orcs.clear();
	}

}
