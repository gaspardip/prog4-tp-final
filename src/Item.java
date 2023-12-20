
public class Item {
	private String nombre;
	private String descripcion;

	public Item(String n, String d) {
		nombre = n;
		descripcion = d;
	}

	public boolean sos(String n) {
		return nombre.equalsIgnoreCase(n);
	}

	public String getNombre() {
		return nombre;
	}

	public void mostrate() {
		System.out.println("Nombre del item: " + nombre);
		System.out.println("Descripcion del item: " + descripcion + "\n");
	}
}
