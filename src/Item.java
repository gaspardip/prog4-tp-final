
public class Item {
	private String nombre;
	private String descripcion;
	
	public Item (String n, String d)
	{
		nombre = n;
		descripcion = d;
	}
	
	public boolean sos(String n) {
		return nombre.equalsIgnoreCase(n);
	}
}
