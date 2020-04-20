package Ficheros;

/**
 * @author Pedro Camacho
 */
public class Controlador {
	private Vista miVista;
	private Modelo miModelo;
	
	public void setVista (Vista miVista){
		this.miVista=miVista;
	}
	
	public void setModelo (Modelo miModelo) {
		this.miModelo=miModelo;
	}
	
	public void guardar(){
		miModelo.guardar(miVista.getBillete(),miVista.getPremio());
	}
	
	public void borrar (){
		miModelo.borrar(miVista.getBillete());
	}
	
	public void comprobar (){
		miModelo.comprobar(miVista.getBillete());
	}
	
}
