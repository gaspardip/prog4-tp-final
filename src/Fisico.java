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
		}

		return maxPrestamosVigentes;
	}

	public void informate()
	{
		System.out.println("--------DATOS PERSONALES--------");
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellido: "+apellido);
		System.out.println("Dni: "+dni);
		super.informate();
	}

	public void mostrarDatosBasicos()
	{
		System.out.println("\nCLIENTE FISICO\nNombre completo: " + nombre + " " + apellido + "\nDNI: " + dni);
	}

}
