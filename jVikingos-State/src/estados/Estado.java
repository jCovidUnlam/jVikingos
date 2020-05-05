package estados;

import src.Vikingo;

public abstract class Estado {
	
	public Estado atacar(Vikingo v) {
		return this;
	}
	
	public Estado recibirAtaque(Vikingo v, int da�o) {
		return this;
	}
	
	public Estado recibirAtaque(Vikingo v) {
		return this;
	}
	
	public Estado meditar() {
		return this;
	}
	

	@Override
	public boolean equals(Object obj) {
		return obj.getClass().getName().equals(this.getClass().getName());
	}
	
	
	
}
