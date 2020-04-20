package Ficheros;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @author Pedro Camacho
 */
public class Modelo {
	private Vista miVista;
	private Properties premios;
	private File miFichero;
	private InputStream entrada;
	private OutputStream salida;
	private String respuesta;
	private final String FILE = "Premios.txt";

	public Modelo() {
		premios = new Properties();
		try {
			miFichero = new File(FILE);
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				premios.load(entrada);
			} else {
				System.err.println("Fichero no encontrado");
				System.exit(1);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void guardar(String billete, String premio) {
		try {
			premios.setProperty(billete, premio);
			salida = new FileOutputStream(miFichero);
			premios.store(salida, "Ultima operacion: Guardado");
			respuesta = "Guardado";
		} catch (IOException e) {
			e.printStackTrace();
		}
		miVista.actualizar();
	}

	public void borrar(String billete) {
		if (!premios.containsKey(billete)) {
			respuesta = "No Encontrado";
		} else {
			premios.remove(billete);
			try {
				salida = new FileOutputStream(miFichero);
				premios.store(salida, "Ultima operacion: Borrado");
				respuesta = "Borrado";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		miVista.actualizar();
	}

	public void comprobar(String billete) {
		String premio = premios.getProperty(billete);
		if (premio == null) {
			respuesta = "No Encontrado";
		} else {
			respuesta = premio;
		}
		miVista.actualizar();
	}

	public void setVista(Vista miVista) {
		this.miVista = miVista;
	}

	public String getRespuesta() {
		return respuesta;
	}

}
