// Daniel Cuevas Pérez

package Modelo;

import java.util.Arrays;
import java.util.List;

public class Ubicacion {
	
	private List<String> listUbicacion;
	
	public Ubicacion() {
		
		listUbicacion = Arrays.asList(
					"A Coruña", "Álava","Albacete","Alicante","Almería","Asturias","Ávila","Badajoz","Baleares","Barcelona","Burgos","Cáceres",
					"Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","Cuenca","Girona","Granada","Guadalajara","Gipuzkoa","Huelva","Huesca","Jaén","La Rioja",
					"Las Palmas","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra","Ourense","Palencia","Pontevedra","Salamanca","Segovia","Sevilla","Soria","Tarragona",
					"Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"
					); 
	}
	
	public List<String> getListUbicacion(){
		return listUbicacion;
	}
}