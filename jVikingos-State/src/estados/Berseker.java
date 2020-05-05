package estados;

import src.Vikingo;

public class Berseker extends Estado{
	
	@Override
	public Estado atacar(Vikingo v) {
		v.recibirAtaque(v, Vikingo.getDaño()*3);
		return this;
	}
	
	@Override
	public Estado recibirAtaque(Vikingo v, int daño) {
		v.restarHP(daño / 2);
		if(v.estaFueraDeCombate())
			return new FueraDeCombate();
		return this;
	}
	
	@Override
	public Estado meditar() {
		return new Normal();
	}

}
