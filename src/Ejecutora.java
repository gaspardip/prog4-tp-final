import java.util.Scanner;

public class Ejecutora {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Banco banco = new Banco();

		int opcion, idPres;

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
			
			System.out.println("\n-------------------------\n");

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
					banco.asignarPrestamoCliente();
					break;

				case 5:
					banco.registrarItem();
					break;

				case 6:
					banco.modificarPuntuacionCliente();
					break;

				case 7:
					banco.informarClientes();
					break;

				case 8:
					System.out.println("Ingrese ID de prestamo: ");
					idPres = in.nextInt();
					banco.informarInscriptosYAsignados(idPres);
					break;

				case 9:
					banco.informarPrestamos();
					break;

				case 10:
					banco.informarItemsRequisitosDisponibles();
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

	}
}
