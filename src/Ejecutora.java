import java.util.Scanner;

public class Ejecutora {

	private void registrarDatosDePrueba(Banco banco) {
		banco.registrarCliente();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Banco banco = new Banco();

		String nroCliente;
		int opcion, codPres, codSoli;

		do {
			System.out.print("\n[1] Agregar un prestamo");
			System.out.print("\n[2] Agregar un cliente");
			System.out.print("\n[3] Inscribir un cliente a un préstamo");
			System.out.print("\n[4] Asignar préstamo a cliente");
			System.out.print("\n[5] Registrar items para requisitos");
			System.out.print("\n[6] Modificar puntuación del cliente");
			System.out.print("\n[7] Informar clientes");
			System.out.print("\n[8] Informar clientes inscriptos y asignados dado un prestamo");
			System.out.print("\n[9] Informar prestamos creados");
			System.out.print("\n[10] Informar los requisitos de los items disponibles");
			System.out.print("\n[11] Eliminar un préstamo");
			System.out.print("\n[12] Eliminar solicitud de cliente");

			System.out.print("\nIngrese una opcion: ");

			opcion = in.nextInt();

			System.out.print("\n-------------------------\n");

			switch (opcion) {
				case 1:
					banco.registrarPrestamo();
					break;

				case 2:
					banco.registrarCliente();
					break;

				case 3:
					System.out.println("Ingrese numero cliente: ");
					nroCliente = in.next();
					System.out.println("Ingrese codigo de prestamo: ");
					codPres = in.nextInt();
					banco.inscripcionAPrestamo(nroCliente, codPres);
					break;

				case 4:
					System.out.println("Ingrese numero de solicitud");
					codSoli = in.nextInt();
					// bco.asignarPrestamoCliente(codSoli);
					break;

				case 5:
					break;

				case 6:
					break;

				case 7:
					break;

				case 8:
					break;

				case 9:
					break;

				case 11:
					banco.eliminarPrestamo();
					break;

				case 12:
					banco.eliminarSolicitudCliente();
					break;

			}
			System.out.print("\n-------------------------\n");
		} while (opcion != 0);

		in.close();
	}
}
