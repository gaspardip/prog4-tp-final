import java.util.Hashtable;

public class Dolar extends Prestamo {
	private static int antiguedadMinima; //Antiguedad minima en años
	
	public Dolar(int id, String d, String t, Hashtable<Item, Integer> reqMin, double m)
	{
		super(id, t, d, reqMin, m);
	}
}