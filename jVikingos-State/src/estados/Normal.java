package estados;

import src.Vikingo;

public class Normal extends Estado {
	
	@Override
	public Estado atacar(Vikingo v) {
		v.recibirAtaque(v, Vikingo.getDaño());
		return this;
	}
	
	@Override
	public Estado recibirAtaque(Vikingo v, int daño) {
		v.restarHP(daño);
		if(v.estaFueraDeCombate())
			return new FueraDeCombate();
		return new Colerico();
	}
	
	@Override
	public Estado meditar() {
		return new Calmado();
	}
}
