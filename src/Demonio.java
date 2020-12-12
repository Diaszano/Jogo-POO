
public final class Demonio extends Orc{
	public Demonio() {
		super(80,20,60);
	}
	public String toString() {
		String string = super.getClass().getName() + " que pertence aos ";
		return  string + super.toString() + "s";
	}
}
