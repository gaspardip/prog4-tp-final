import java.util.Hashtable;
import java.util.Scanner;

public class Dolar extends Prestamo {
	private static int antiguedadMinima; // Antiguedad minima en años

	public Dolar(int id, String t, String d, Hashtable<Item, Integer> reqMin, double m) {
		super(id, t, d, reqMin, m);
		getAntiguedadMinima();
	}

	public void mostrate() {
		super.mostrate();
		System.out.print("\nMoneda: Dolar");
		System.out.print("\nAntiguedad minima para solicitar prestamo en USD: " + antiguedadMinima);

	}

	public int getAntiguedadMinima() {
		return antiguedadMin();
	}

	public static int antiguedadMin() {
		if (antiguedadMinima == 0) {
			Scanner in = new Scanner(System.in);

			System.out.print("ingrese la antiguedad minima necesaria en años para acceder a prestamos en dolares: ");

			antiguedadMinima = in.nextInt();
		}

		return antiguedadMinima;
	}
}