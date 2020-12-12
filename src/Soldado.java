
public final class Soldado extends Humano{
	public Soldado() {
		super(20,80,40);
	}
	public String toString() {
		String string = super.getClass().getName() + " que pertence aos ";
		return  string + super.toString() + "s";
	}
}
