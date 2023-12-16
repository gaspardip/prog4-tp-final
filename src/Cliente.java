import java.util.ArrayList;
import java.util.Hashtable;

import Utilidades.Fecha;

public abstract class Cliente {
	private final ArrayList<SolicitudPrestamo>solicitudesPrestamos= new ArrayList<>();
	private final Fecha fechaRegistro;
	private final Hashtable <Item, Integer>puntuaciones = new Hashtable <>();

	public Cliente(Fecha f)
	{
		fechaRegistro = f;
	}

	public abstract boolean sos(String n);
}
