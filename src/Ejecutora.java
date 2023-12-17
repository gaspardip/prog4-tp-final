import java.util.Scanner;

public class Ejecutora {

	private void registrarDatosDePrueba(Banco banco) {
		banco.registrarCliente();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Banco banco = new Banco();

		int opcion;

		do {
			System.out.println("[1] Agregar un prestamo");
			System.out.println("[2] Agregar un cliente");
			System.out.println("[3] Inscribir un cliente a un préstamo");
			System.out.println("[4] Asignar préstamo a cliente");
			System.out.println("[5] Registrar items para requisitos");
			System.out.println("[6] Modificar puntuación del cliente");
			System.out.println("[7] Informar clientes");
			System.out.println("[8] Informar clientes inscriptos y asignados dado un prestamo");
			System.out.println("[9] Informar prestamos creados");
			System.out.println("[10] Informar los requisitos de los items disponibles");
			System.out.println("[11] Eliminar un préstamo");
			System.out.println("[12] Eliminar solicitud de cliente");

			System.out.println("Ingrese una opcion: ");

			opcion = in.nextInt();

			System.out.println("-------------------------");

			switch (opcion) {
				case 1:
					banco.registrarPrestamo();
					break;

				case 2:
					banco.registrarCliente();
					break;

				case 3:

					banco.inscripcionAPrestamo();
					break;

				case 4:

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
			System.out.println("-------------------------");
		} while (opcion != 0);

		in.close();
	}
}
