import java.util.ArrayList;
import java.util.Hashtable;

import Utilidades.Fecha;

public abstract class Cliente {
	private final ArrayList<SolicitudPrestamo> solicitudesPrestamos = new ArrayList<>();
	private final Fecha fechaRegistro;
	private final Hashtable<Item, Integer> puntuaciones = new Hashtable<>();

	public Cliente(Fecha f) {
		fechaRegistro = f;
	}

	public abstract boolean sos(String n);

	public boolean hasItem(Item item) {
		return puntuaciones.containsKey(item);
	}

	public int getPuntaje(Item item) {
		return puntuaciones.get(item);
	}

	public void agregarPuntaje(Item i, int p) {
		puntuaciones.put(i, p);
	}

	public boolean estaInscripto(Prestamo p) {
		for (SolicitudPrestamo s : solicitudesPrestamos) {
			if (s.getPrestamo() == p)
				return true;
		}

		return false;
	}

	public String tipoDeCliente() {
		String nombre = this.getClass().getName();
		return nombre;
	}

	public int antiguedad() {
		return Fecha.hoy().getAño() - fechaRegistro.getAño();
	}

	public int getCantPrestamos() {
		return solicitudesPrestamos.size();
	}

	public void agregarSolicitud(SolicitudPrestamo solicitud) {
		solicitudesPrestamos.add(solicitud);
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();

		sb.append("Fecha de registro: ");
		sb.append(fechaRegistro);
		sb.append("\n");

		sb.append("Puntuaciones: ");

		for (Item item : puntuaciones.keySet()) {
			sb.append(item);
			sb.append(": ");
			sb.append(puntuaciones.get(item));
			sb.append("\n");
		}

		sb.append("Solicitudes de prestamo: ");

		for (SolicitudPrestamo solicitudPrestamo : solicitudesPrestamos) {
			sb.append(solicitudPrestamo);
			sb.append("\n");
		}

		return sb.toString();
	}
}
