
public class SolicitudPrestamo {
	private final Cliente cliente;
	private final Prestamo prestamo;
	private final int codigoSolicitud;
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
}
