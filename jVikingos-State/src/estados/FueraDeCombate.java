package estados;

import src.Vikingo;

public class FueraDeCombate extends Estado {
	

	@Override
	public Estado recibirAtaque(Vikingo v, int da�o) {
		return this;
	}
	
	@Override
	public Estado recibirAtaque(Vikingo v) {
		return this;
	}

}
