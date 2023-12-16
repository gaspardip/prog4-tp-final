
import Utilidades.Fecha;

public class Juridico extends Cliente {
	private String razonSocial;
	private String cuit;

	public Juridico(Fecha f, String r, String c) {
		super(f);
		razonSocial = r;
		cuit = c;
	}

	public boolean sos(String n) {
		return cuit.equalsIgnoreCase(n);
	}
}