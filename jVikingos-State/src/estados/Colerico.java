package estados;

import src.Vikingo;

public class Colerico extends Estado{
	
	@Override
	public Estado atacar(Vikingo v) {
		v.recibirAtaque(v, Vikingo.getDa�o()*2);
		return this;
	}
	
	@Override
	public Estado recibirAtaque(Vikingo v, int da�o) {
		v.restarHP(da�o * 2);
		if(v.estaFueraDeCombate())
			return new FueraDeCombate();
		return new Berseker();
	}
	
	@Override
	public Estado meditar() {
		return new Normal();
	}

}
