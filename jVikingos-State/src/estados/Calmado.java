package estados;

import src.Vikingo;

public class Calmado extends Estado{
	
	@Override
	public Estado atacar(Vikingo v) {
		v.recibirAtaque(v, Vikingo.getDa�o());
		return new Normal();
	}
	
	@Override
	public Estado recibirAtaque(Vikingo v, int da�o) {
		return this;
	}
	
	@Override
	public Estado meditar() {
		return this;
	}

}
