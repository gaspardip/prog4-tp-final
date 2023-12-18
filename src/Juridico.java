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

	public void informate()
	{
		System.out.println("--------DATOS DE ENTIDAD--------");
		System.out.println("Razon social: " + razonSocial);
		System.out.println("Cuit: " + cuit);
		super.informate();
	}

	public void mostrarDatosBasicos()
	{
		System.out.println("\nCLIENTE JURIDICO\nRazon Social: " + razonSocial + "\nCuit: " + cuit);
	}

}