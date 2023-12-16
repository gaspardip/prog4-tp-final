import java.util.Hashtable;

public abstract class Prestamo {
	private int idPrestamo;
	private String tipo;
	private String descripcion;
	private Hashtable<Item, Integer> requisitosMinimos;
	private double monto;

	public Prestamo(int id, String t, String d, Hashtable<Item, Integer> reqMin, double m) {
		idPrestamo = id;
		tipo = t;
		descripcion = d;
		requisitosMinimos = reqMin;
		monto = m;
	}

	public boolean sos(int id) {
		return id == idPrestamo;
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();

		sb.append("ID: ");
		sb.append(idPrestamo);
		sb.append("\n");

		sb.append("Tipo: ");
		sb.append(tipo);
		sb.append("\n");

		sb.append("Descripcion: ");
		sb.append(descripcion);
		sb.append("\n");

		sb.append("Requisitos minimos: ");

		for (var item : requisitosMinimos.keySet()) {
			sb.append(item);
			sb.append(": ");
			sb.append(requisitosMinimos.get(item));
			sb.append(" ");
		}

		sb.append("\n");

		sb.append("Monto: ");
		sb.append(monto);
		sb.append("\n");

		return sb.toString();
	}
}
