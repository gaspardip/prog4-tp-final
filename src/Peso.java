import java.util.Hashtable;

public class Peso extends Prestamo {
	
	public Peso(int id, String t, String d, Hashtable<Item, Integer> reqMin, double m)
	{
		super(id, t, d, reqMin, m);
	}

	public void mostrate()
	{
		super.mostrate();
		System.out.print("\nMoneda: Peso");
	}
}
