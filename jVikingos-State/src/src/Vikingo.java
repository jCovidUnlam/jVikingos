package src;

import estados.Berseker;
import estados.Colerico;
import estados.Estado;
import estados.Normal;

public class Vikingo { 
	private int HP; //Healt ponints
	private Estado estado;
	private static final int daño = 10;
	
	public Vikingo() {
		this.HP = 70;
		this.estado = new Normal();
	}
	
	public Vikingo(int HP) {
		this.HP = HP;
		this.estado = new Normal();
	}
	
	public void restarHP(int points) {
		HP -= points;
	}
	
	public boolean estaFueraDeCombate() {
		return this.HP <= 0;
	}

	public void atacar(Vikingo v) {
		estado = estado.atacar(v);
	}
	
	public void recibirAtaque(Vikingo v, int daño) {
		estado = estado.recibirAtaque(v, daño);
	}
	
	public void recibirAtaque(Vikingo v) {
		estado = estado.recibirAtaque(v);
	}
	
	public void meditar() {
		estado = estado.meditar();
	}

	public int getHP() {
		return HP;
	}
	
	public static int getDaño() {
		return daño;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
