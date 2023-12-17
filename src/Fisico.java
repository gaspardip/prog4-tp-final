import java.util.Scanner;

import Utilidades.Fecha;

public class Fisico extends Cliente {
	private static int maxPrestamosVigentes;
	private final String nombre;
	private final String apellido;
	private final String dni;

	public Fisico(Fecha f, String n, String a, String d) {
		super(f);
		nombre = n;
		apellido = a;
		dni = d;
	}

	public boolean sos(String n) {
		return dni.equalsIgnoreCase(n);
	}

	public int getCantidadMaxPrestamos() {
		return numeroMaxDePrestamos();
	}

	public static int numeroMaxDePrestamos() {
		if (maxPrestamosVigentes == 0) {
			Scanner in = new Scanner(System.in);

			System.out.print("ingrese el maximo de prestamos que puede solicitar un cliente fisico: ");

			maxPrestamosVigentes = in.nextInt();

			in.close();
		}

		return maxPrestamosVigentes;
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();

		sb.append("Nombre: ");
		sb.append(nombre);
		sb.append("\n");

		sb.append("Apellido: ");
		sb.append(apellido);
		sb.append("\n");

		sb.append("DNI: ");
		sb.append(dni);
		sb.append("\n");

		sb.append(super.toString());

		return sb.toString();
	}

}
