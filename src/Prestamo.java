import java.util.Enumeration;
import java.util.Hashtable;

public abstract class Prestamo {
	private final double monto;
	private final Hashtable<Item, Integer> requisitosMinimos;
	private final int idPrestamo;
	private final String descripcion;
	private final String tipo;

	public Prestamo(int id, String t, String d, Hashtable<Item, Integer> reqMin, double m) {
		idPrestamo = id;
		tipo = t;
		descripcion = d;
		requisitosMinimos = reqMin;
		monto = m;
	}

	public String getTipo() {
		return tipo;
	}

	public boolean sos(int id) {
		return id == idPrestamo;
	}

	public int getPuntajeMin(Item item) {
		return requisitosMinimos.get(item);
	}

	public Hashtable<Item, Integer> getReqMinimos() {
		return requisitosMinimos;
	}

	public String tipoDePrestamo() {
		String nombre = this.getClass().getName();
		return nombre;
	}

	public void mostrate()
	{
		System.out.print("\nID del prestamo: " + idPrestamo);
		System.out.print("\nTipo de prestamo: " + tipo);
		System.out.print("\nDescripcion: " + descripcion);
		
		System.out.print("\nRequisitos minimos: ");
		Item i;
		Enumeration<Item>enumItem=requisitosMinimos.keys();
        while(enumItem.hasMoreElements())
        {                                                                
            i=enumItem.nextElement();
            System.out.println("\nRequisito: " + i.getNombre() + "    Puntuacion Minima: " + requisitosMinimos.get(i));
        }            

		System.out.print("Monto: " + monto);
	}
}
