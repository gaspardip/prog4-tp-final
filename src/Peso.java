import java.util.Hashtable;

public class Peso extends Prestamo {
	
	public Peso(int id, String d, String t, Hashtable<Item, Integer> reqMin, double m)
	{
		super(id, t, d, reqMin, m);
	}
}
