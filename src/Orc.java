
public abstract class Orc extends Personagem{
	
	private int forca;
	private int habilidade;
	private int agilidade;
	protected static int totalVida = 0;
	protected static int totalVivos = 0;
	
	public Orc(int forca, int habilidade, int agilidade) {
		this.forca = forca;
		this.habilidade = habilidade;
		this.agilidade = agilidade;
	}
	public int getForca() {
		return forca;
	}
	public int getHabilidade() {
		return habilidade;
	}
	public int getAgilidade() {
		return agilidade;
	}
	public int getTotalVida() {
		return totalVida;
	}
	public void setTotalVida(int totalVida) {
		Orc.totalVida = totalVida;
	}
	public void setTotalVida() {
		Orc.totalVida = 0;
	}
	public int getTotalVivos() {
		return totalVivos;
	}
	public void setTotalVivos() {
		Orc.totalVivos++;
	}
	public void setTotalVivos(int i) {
		Orc.totalVivos = i;
	}
	public String toString() {
		return  "Orc";
	}
}
