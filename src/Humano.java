
public abstract class Humano extends Personagem{
	
	private int inteligencia;
	private int velocidade;
	private int equipamentos;
	private static int totalVida = 0;
	private static int totalVivos = 0;
	
	public Humano(int inteligencia, int velocidade, int equipamentos) {
		this.inteligencia = inteligencia;
		this.velocidade = velocidade;
		this.equipamentos = equipamentos;
	}
	
	public int getInteligencia() {
		return inteligencia;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public int getEquipamentos() {
		return equipamentos;
	}
	
	public int getTotalVida() {
		return totalVida;
	}
	public void setTotalVida(int totalVida) {
		Humano.totalVida = totalVida;
	}
	public void setTotalVida() {
		Humano.totalVida = 0;
	}
	public int getTotalVivos() {
		return totalVivos;
	}
	public void setTotalVivos() {
		Humano.totalVivos++;
	}
	public void setTotalVivos(int i) {
		Humano.totalVivos = i;
	}
	public String toString() {
		return  "Humano";
	}
}
