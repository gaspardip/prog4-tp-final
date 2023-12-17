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

	@Override
	public String toString() {
		var sb = new StringBuilder();

		sb.append("Razon social: ");
		sb.append(razonSocial);
		sb.append("\n");

		sb.append("CUIT: ");
		sb.append(cuit);
		sb.append("\n");

		sb.append(super.toString());

		return sb.toString();
	}

}