
public final class Arqueiro extends Humano {
	public Arqueiro() {
		super(60,60,20);
	}
	public String toString() {
		String string = super.getClass().getName() + " que pertence aos ";
		return  string + super.toString() + "s";
	}
}
