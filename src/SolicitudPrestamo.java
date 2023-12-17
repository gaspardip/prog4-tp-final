import java.util.Enumeration;
import java.util.Hashtable;

public class SolicitudPrestamo {
	private final Cliente cliente;
	private final Prestamo prestamo;
	private final int codigoSolicitud;
	// Inscripto o Asignado
	private String estado;

	public SolicitudPrestamo(Cliente c, Prestamo p, int cod) {
		cliente = c;
		prestamo = p;
		codigoSolicitud = cod;
		estado = "Inscripto";
	}

	public boolean sos(int numeroSolicitud) {
		return this.codigoSolicitud == numeroSolicitud;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void asignarCliente() {
		estado = "Asignado";

		Hashtable<Item, Integer> reqMin = prestamo.getReqMinimos();
		Enumeration<Item> enumItems = reqMin.keys();

		while (enumItems.hasMoreElements()) {
			Item i = enumItems.nextElement();

			if (cliente.getPuntaje(i) < prestamo.getPuntajeMin(i))
				estado = "Inscripto";
		}

		if (estado.equalsIgnoreCase("inscripto")) {
			System.out.println("La puntuacion del cliente no es suficiente para asignarle el prestamo.");
		} else {
			System.out.println("Cliente asignado al prestamo con exito!");
		}
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();

		sb.append("Codigo de solicitud: ");
		sb.append(codigoSolicitud);
		sb.append("\n");

		sb.append("Estado: ");
		sb.append(estado);
		sb.append("\n");

		sb.append("Cliente: ");
		sb.append(cliente);
		sb.append("\n");

		sb.append("Prestamo: ");
		sb.append(prestamo);
		sb.append("\n");

		return sb.toString();
	}
}
