package colores;

import java.awt.Color;

public class Colores {
	private Color verde;
	private Color amarillo;
	private Color naranja;
	
	public Colores() {
		verde = new Color(64, 191, 119);
		amarillo = new Color(255, 222, 89);
		naranja = new Color(255, 145, 77);
	}
	
	public Color getVerde() {
		return verde;
	}
	
	public Color getAmarillo() {
		return amarillo;
	}
	
	public Color getNaranja() {
		return naranja;
	}
}
