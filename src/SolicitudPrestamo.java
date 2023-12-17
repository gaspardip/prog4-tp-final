
public class SolicitudPrestamo {
	private final Cliente cliente;
	private final int codigoSolicitud;
	private final Prestamo prestamo;
	private final String estado;

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
