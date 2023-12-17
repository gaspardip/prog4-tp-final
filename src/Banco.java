import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

import Utilidades.Fecha;
import Utilidades.Titulo;

public class Banco {

	private final ArrayList<Prestamo> prestamos = new ArrayList<>();
	private final ArrayList<Item> itemsRequisitos = new ArrayList<>();
	private final ArrayList<Cliente> clientes = new ArrayList<>();
	private final ArrayList<SolicitudPrestamo> solicitudesPrestamos = new ArrayList<>();

	public void registrarPrestamo() {
		Scanner in = new Scanner(System.in);

		Titulo.mostrar("REGISTRAR PRESTAMO");

		System.out.println("ID del prestamo: ");

		int id = in.nextInt();

		Prestamo prestamo = this.buscarPrestamo(id);

		if (prestamo == null) {
			System.out.println("Tipo de prestamo: ");
			in.nextLine(); // Llamada a leer linea vacia para control de errores despues de nextInt
			String tipo = in.nextLine();

			System.out.println("Descripcion del prestamo: ");
			String descr = in.nextLine();

			String moneda;

			do {
				System.out.println("Moneda del prestamo (Peso/Dolar): ");
				moneda = in.nextLine();
			} while (!(moneda.equalsIgnoreCase("Dolar") || moneda.equalsIgnoreCase("Peso"))); // Se ejecutara mientras
																								// moneda no sea ni peso
																								// ni dolar

			System.out.println("Monto del prestamo: ");
			double monto = in.nextDouble();

			Hashtable<Item, Integer> reqMin = new Hashtable<>();
			System.out.println("Carga de requisitos minimos para solicitar este prestamo. ");

			int opc = 1;
			do {
				System.out.println("Ingrese el nombre del requisito a añadir puntaje minimo: ");
				in.nextLine();
				String nombreReq = in.nextLine();
				Item i = this.buscarItem(nombreReq);

				int op = 1;

				while (i == null) {
					System.out.println(
							"El requisito ingresado no se encuentra entre los requisitos existentes.");

					System.out.println("Desea crear uno nuevo con ese nombre? (1 = Si ; 0 = No)");

					op = in.nextInt();

					if (op == 1) {
						System.out.println("Ingrese la descripcion para el nuevo requisito " + nombreReq + ":");
						in.nextLine();
						String desc = in.nextLine();

						Item item = new Item(nombreReq, desc);
						itemsRequisitos.add(item);
						i = item;
					} else {
						System.out.println("Ingrese un nombre de requisito nuevamente: ");
						in.nextLine();
						nombreReq = in.nextLine();
						i = this.buscarItem(nombreReq);
					}
				}

				System.out.println("Ingrese el puntaje minimo para este requisito: ");
				int puntajeMin = in.nextInt();

				reqMin.put(i, puntajeMin);

				System.out.println("Deseas agregar algun requisito mas? (1 = Si ; 0 = No)");
				opc = in.nextInt();

			} while (opc == 1);

			if (moneda.equalsIgnoreCase("Dolar")) {
				Dolar prestamoDolar = new Dolar(id, tipo, descr, reqMin, monto);
				prestamos.add(prestamoDolar);
				System.out.println("Prestamo registrado con exito! ");
			} else if (moneda.equalsIgnoreCase("Peso")) {
				Peso prestamoPeso = new Peso(id, tipo, descr, reqMin, monto);
				prestamos.add(prestamoPeso);
				System.out.println("Prestamo registrado con exito! ");
			}
		} else {
			System.out.println("Ya existe un prestamo con ese mismo codigo!");
		}

		in.close();
	}

	public void registrarCliente() {
		Scanner in = new Scanner(System.in);

		Titulo.mostrar("REGISTRAR CLIENTE");

		String tipo;
		do {
			System.out.println("Tipo de cliente (Fisico / Juridico): ");
			tipo = in.next();
		} while (!(tipo.equalsIgnoreCase("fisico") || tipo.equalsIgnoreCase("juridico")));

		if (tipo.equalsIgnoreCase("fisico")) {
			System.out.println("Ingresa el DNI: ");
			String dni = in.next();

			if (this.buscarCliente(dni) == null) {
				System.out.println("Ingresa el nombre: ");
				String nom = in.next();

				System.out.println("Ingresa el apellido: ");
				String ape = in.next();

				System.out.println("Fecha de registro en el banco: ");
				Fecha f = Fecha.nuevaFecha();

				Fisico cliFisico = new Fisico(f, nom, ape, dni);
				clientes.add(cliFisico);
				System.out.println("Cliente registrado con exito! ");

			} else
				System.out.println("Ya existe un cliente con ese DNI");
		} else if (tipo.equalsIgnoreCase("juridico")) {

			System.out.println("Ingresa el cuit: ");
			String cuit = in.next();

			if (this.buscarCliente(cuit) == null) {
				System.out.println("Ingresa razon social: ");
				in.nextLine();
				String razonSoc = in.nextLine();

				System.out.println("Fecha de registro en el banco: ");
				Fecha f = Fecha.nuevaFecha();

				Juridico cliJuridico = new Juridico(f, razonSoc, cuit);
				clientes.add(cliJuridico);
				System.out.println("Cliente registrado con exito! ");

			} else
				System.out.println("Ya existe un cliente con ese cuit");
		}

		in.close();
	}

	public void inscripcionAPrestamo() {
		Scanner in = new Scanner(System.in);

		Titulo.mostrar("INSCRIPCION A PRESTAMO");

		System.out.println("Ingresa el DNI o CUIT del cliente: ");
		String nroCliente = in.next();

		Cliente cliente = this.buscarCliente(nroCliente);

		if (cliente != null) {
			String tipoDeCliente = cliente.tipoDeCliente();

			int cantidadMax = 0;
			int cantidadPrestamos = 0;

			if (tipoDeCliente.equalsIgnoreCase("fisico")) {
				cantidadMax = ((Fisico) cliente).getCantidadMaxPrestamos();
				cantidadPrestamos = cliente.getCantPrestamos();
			}

			if (tipoDeCliente.equalsIgnoreCase("fisico") && cantidadPrestamos >= cantidadMax) {
				System.out.println("\nEl cliente fisico ya esta inscripto a la cantidad maxima de prestamos");
			} else {
				System.out.println("Ingrese codigo de prestamo: ");
				int codPres = in.nextInt();
				Prestamo prestamo = this.buscarPrestamo(codPres);

				while (cliente.estaInscripto(prestamo)) {
					System.out
							.println("El cliente ya esta inscripto en ese prestamo. Ingrese otro codigo de prestamo: ");
					codPres = in.nextInt();
					prestamo = this.buscarPrestamo(codPres);
				}

				if (prestamo != null) {
					String tipoDePrestamo = prestamo.tipoDePrestamo();
					int antiguedad = cliente.antiguedad();

					if (tipoDePrestamo.equalsIgnoreCase("dolar") && antiguedad < 2) {
						System.out.println(
								"La antiguedad del cliente no alcanza la minima de 2 años para aceptar el prestamo en dolares");
					} else {
						System.out.println("Ingrese el numero de solicitud de prestamo: ");
						int numeroSolicitud = in.nextInt();
						SolicitudPrestamo solicitud = this.buscarSolicitud(numeroSolicitud);

						if (solicitud == null) {
							solicitud = new SolicitudPrestamo(cliente, prestamo, numeroSolicitud);
							solicitudesPrestamos.add(solicitud);
							cliente.agregarSolicitud(solicitud);
							registrarPuntuacion(cliente, prestamo);
						} else {
							System.out.println("Ya existe una solicitud con ese numero ");
						}
					}
				} else {
					System.out.println("El prestamo no existe ");
				}
			}
		} else {
			System.out.println("El cliente no existe ");
		}

		in.close();
	}

	public void registrarItem() {
		Scanner in = new Scanner(System.in);

		Titulo.mostrar("REGISTRAR ITEM");

		int opc = 1;

		do {
			System.out.println("Nombre del item: ");
			String name = in.next();
			Item item = this.buscarItem(name);

			if (item == null) {
				System.out.println("Descripcion del item: ");
				String descr = in.next();

				Item itemReq = new Item(name, descr);
				itemsRequisitos.add(itemReq);

				System.out.print("Item ingresado exitosamente.");
			} else {
				System.out.println("Ya existe un item con ese mismo nombre!");
			}

			System.out.print("Deseas agregar algun otro item? (1 = Si ; 0 = No)");
			opc = in.nextInt();
		} while (opc == 1);

		in.close();
	}

	private void registrarPuntuacion(Cliente cliente, Prestamo prestamo) {
		Scanner in = new Scanner(System.in);
		Item i;
		int p, op = 0;

		Titulo.mostrar("REGISTRAR PUNTUACIONES DEL CLIENTE");

		var requisitosMinimos = prestamo.getReqMinimos();
		var enumItems = requisitosMinimos.keys();

		while (enumItems.hasMoreElements()) {
			i = enumItems.nextElement();
			if (cliente.hasItem(i)) {
				System.out.println("La puntuacion del cliente en " + i.getNombre() + " es de " + cliente.getPuntaje(i));
				System.out.println("Deseas modificarla? (1 = Si ; 0 = No)");
				op = in.nextInt();
				if (op == 1) {
					System.out.println("Ingresa la nueva puntuacion del cliente en " + i.getNombre());
					p = in.nextInt();
					cliente.agregarPuntaje(i, p);
				}
			} else {
				System.out.println("Ingresa la puntuacion del cliente en " + i.getNombre());
				p = in.nextInt();
				cliente.agregarPuntaje(i, p);
			}
		}

		in.close();
	}

	public void asignarPrestamoCliente() {
		Scanner in = new Scanner(System.in);

		Titulo.mostrar("ASIGNAR PRESTAMO A CLIENTE");

		System.out.println("Ingrese numero de solicitud: ");

		int codSoli = in.nextInt();

		SolicitudPrestamo solicitud = this.buscarSolicitud(codSoli);

		if (solicitud != null) {
			solicitud.asignarCliente();
		} else {
			System.out.println("La solicitud no existe");
		}

		in.close();
	}

	/*
	 * public void modificarPuntuacionCliente()
	 * {
	 * Scanner s = new Scanner (System.in);
	 * System.out.println("---- MODIFICAR PUNTUACION DE CLIENTE ----");
	 * System.out.println("Ingresa el DNI o CUIT del cliente: ");
	 *
	 * }
	 */

	private SolicitudPrestamo buscarSolicitud(int numeroSolicitud) {
		int i = 0;

		while (i < solicitudesPrestamos.size() && !solicitudesPrestamos.get(i).sos(numeroSolicitud)) {
			i++;
		}

		if (i != solicitudesPrestamos.size()) {
			return solicitudesPrestamos.get(i);
		} else
			return null;
	}

	private SolicitudPrestamo[] buscarSolicitudes(int idPrestamo) {

		return solicitudesPrestamos.stream().filter(s -> s.getPrestamo().sos(idPrestamo))
				.toArray(SolicitudPrestamo[]::new);
	}

	private Prestamo buscarPrestamo(int id) {
		int i = 0;

		while (i < prestamos.size() && !prestamos.get(i).sos(id)) {
			i++;
		}

		return i != prestamos.size() ? prestamos.get(i) : null;

	}

	private Item buscarItem(String n) {
		int i = 0;

		while (i < itemsRequisitos.size() && !itemsRequisitos.get(i).sos(n)) {
			i++;
		}

		return i != itemsRequisitos.size() ? itemsRequisitos.get(i) : null;
	}

	private Cliente buscarCliente(String n) {
		int i = 0;

		while (i < clientes.size() && !clientes.get(i).sos(n)) {
			i++;
		}

		return i != clientes.size() ? clientes.get(i) : null;
	}

	public void eliminarPrestamo() {
		Scanner in = new Scanner(System.in);

		Titulo.mostrar("ELIMINAR PRESTAMO");

		System.out.println("ID del prestamo: ");

		int idPrestamo = in.nextInt();

		Prestamo prestamo = this.buscarPrestamo(idPrestamo);

		if (prestamo != null) {
			SolicitudPrestamo[] solicitudes = this.buscarSolicitudes(idPrestamo);

			for (SolicitudPrestamo solicitud : solicitudes) {
				solicitudesPrestamos.remove(solicitud);
			}

			prestamos.remove(prestamo);

			System.out.println("Prestamo eliminado exitosamente");
		} else {
			System.out.println("No existe un prestamo con ese codigo");
		}

		in.close();
	}

	public void eliminarSolicitudCliente() {
		Scanner in = new Scanner(System.in);

		Titulo.mostrar("ELIMINAR SOLICITUD DE CLIENTE");

		System.out.println("ID del prestamo: ");

		int idPrestamo = in.nextInt();

		Prestamo prestamo = this.buscarPrestamo(idPrestamo);

		if (prestamo != null) {
			SolicitudPrestamo[] solicitudes = this.buscarSolicitudes(idPrestamo);

			System.out.println("Numero de cliente");

			String numeroCliente = in.next();

			Cliente cliente = this.buscarCliente(numeroCliente);

			if (cliente != null) {
				SolicitudPrestamo solicitud = Arrays
						.stream(solicitudes)
						.filter(s -> s.getCliente().sos(numeroCliente))
						.findFirst().orElse(null);

				if (solicitud != null) {
					solicitudesPrestamos.remove(solicitud);

					System.out.println("Solicitud eliminada exitosamente.");
				} else {
					System.out.println("No existe una solicitud con ese codigo!");
				}
			} else {
				System.out.println("No existe un cliente con ese numero");
			}
		} else {
			System.out.println("No existe un prestamo con ese codigo");
		}

		in.close();
	}

	public void informarPrestamos() {
		Titulo.mostrar("PRESTAMOS");

		for (Prestamo prestamo : prestamos) {
			System.out.println(prestamo);
		}
	}

	public void informarClientes() {
		Titulo.mostrar("CLIENTES");

		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

}
