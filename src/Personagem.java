
public abstract class Personagem {
	
	protected int vida = 100;

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		if(vida < 0) {
			vida = 0;
		}
		this.vida = vida;
	}
	
	public void setVida(int i, int j) {
		this.vida += i - j;
		if(this.vida < 0) {
			this.vida = 0;
		}
	}
}
