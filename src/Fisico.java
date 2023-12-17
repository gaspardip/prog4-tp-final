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

		return sb.toString();
	}
}
