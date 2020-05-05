package estados;

import src.Vikingo;

public class FueraDeCombate extends Estado {
	

	@Override
	public Estado recibirAtaque(Vikingo v, int daño) {
		return this;
	}
	
	@Override
	public Estado recibirAtaque(Vikingo v) {
		return this;
	}

}
