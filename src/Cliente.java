import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import Utilidades.Fecha;

public abstract class Cliente {
	private final ArrayList<SolicitudPrestamo> solicitudesPrestamos = new ArrayList<>();
	private final Fecha fechaRegistro;
	private final Hashtable<Item, Integer> puntuaciones = new Hashtable<>();

	public Cliente(Fecha f) {
		fechaRegistro = f;
	}

	public abstract boolean sos(String n);

	public abstract void mostrarDatosBasicos();

	public boolean hasItem(Item item) {
		return puntuaciones.containsKey(item);
	}

	public SolicitudPrestamo getSolicitud(int n) {
		for (SolicitudPrestamo s : solicitudesPrestamos) {
			if (s.getCodigo() == n)
				return s;
		}
		return null;
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

	public String getTipoCliente() {
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

	public void informate() {
		System.out.println("--------DATOS REGISTRO Y PUNTUACIONES DEL CLIENTE--------");
		Item i;
		System.out.println("Fecha de registro: " + fechaRegistro);
		Enumeration<Item> enumItem = puntuaciones.keys();
		while (enumItem.hasMoreElements()) {
			i = enumItem.nextElement();
			System.out.println("Item: " + i.getNombre() + " Puntuacion Minima: " + puntuaciones.get(i));
		}
		System.out.println("--------DATOS DE PRESTAMOS SOLICITADOS--------");
		mostrarSolicitudes();

	}

	public void modificarPuntuacion() {
		Scanner in = new Scanner(System.in);
		Item i;
		int p;
		Enumeration<Item> enumItems = puntuaciones.keys();

		while (enumItems.hasMoreElements()) {
			i = enumItems.nextElement();
			System.out.println("Categoria " + i.getNombre() + " , Puntuacion actual:" + puntuaciones.get(i));
			System.out.println("Ingresa la nueva puntuacion: ");
			p = in.nextInt();
			puntuaciones.put(i, p);
		}
	}

	public void mostrarSolicitudes() {
		for (SolicitudPrestamo s : solicitudesPrestamos) {
			s.mostrate();
			System.out.println(" ");
		}
	}

	public void eliminarSolicitud(SolicitudPrestamo s) {
		solicitudesPrestamos.remove(s);
	}
}
