package Ficheros;

/**
 * @author Pedro Camacho
 */
public class Inicio {
	public static void main(String[] args) {
		Controlador miControlador = new Controlador();
		Modelo miModelo = new Modelo ();
		Vista miVista = new Vista ();
		
		miModelo.setVista(miVista);
		miVista.setControlador(miControlador);
		miVista.setModelo(miModelo);
		miControlador.setVista (miVista);
		miControlador.setModelo (miModelo);
		
		miVista.setVisible(true);
	}

}
