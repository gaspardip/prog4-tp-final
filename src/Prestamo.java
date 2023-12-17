import java.util.Hashtable;

public abstract class Prestamo {
	private final double monto;
	private final Hashtable<Item, Integer> requisitosMinimos;
	private final int idPrestamo;
	private final String descripcion;
	private final String tipo;

	public Prestamo(int id, String t, String d, Hashtable<Item, Integer> reqMin, double m) {
		idPrestamo = id;
		tipo = t;
		descripcion = d;
		requisitosMinimos = reqMin;
		monto = m;
	}

	public String getTipo() {
		return tipo;
	}

	public boolean sos(int id) {
		return id == idPrestamo;
	}

	public int getPuntajeMin(Item item) {
		return requisitosMinimos.get(item);
	}

	public Hashtable<Item, Integer> getReqMinimos() {
		return requisitosMinimos;
	}

	public String tipoDePrestamo() {
		String nombre = this.getClass().getName();
		return nombre;
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
