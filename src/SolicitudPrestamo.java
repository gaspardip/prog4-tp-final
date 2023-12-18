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
	
	public int getCodigo()
	{
		return codigoSolicitud;
	}

	public void mostrate()
	{
		System.out.println("Tipo de prestamo: "+prestamo.getTipo());
		System.out.println("Codigo de solicitud: "+this.codigoSolicitud);
		System.out.println("Estado: "+this.estado);
	}

	public void mostrarCliente()
	{
		cliente.mostrarDatosBasicos();
	}

	public String getEstado()
	{
		return estado;
	}
}
