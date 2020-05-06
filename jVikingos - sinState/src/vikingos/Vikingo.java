package vikingos;

public class Vikingo {

	
	public String estado= "normal";
	public int salud=100; //100%
	
	//hay que recalcular la salud a restar.
	public  void recibirAtaque(Vikingo enemigo) {
		if(estado.equals("normal")) {
			estado= "colerico";
			if(enemigo.estado.equals("normal"))
				salud-=20;
			else
			{
				if(enemigo.estado.equals("colerico"))
					salud-=40;
				else
					salud-=30;
			}
		}
		else
		{
			if(estado.equals("calmado")) 
				estado="calmado";
			else {
				estado="berserker";
				if(enemigo.estado.equals("normal"))
					salud-=5;
				else
				{
					if(enemigo.estado.equals("colerico"))
						salud-=10;
					else
						salud-=15;
				}
			}
				
			
		}
		
		if(salud<=0)
			estado="fuera de combate";
	}
	
	public void meditar() {
	if(estado.equals("berserker") || estado.equals("colerico"))
		estado="normal";
	else
		estado="calmado";
	}
	
	public void realizarAtaque() {
		if(estado.equals("calmado"))
			estado="normal";
	}
	
	public static void main(String[] args) {
		
		Vikingo vikingo1 = new Vikingo();
		Vikingo vikingo2 = new Vikingo();
		
		
		System.out.println(vikingo1.estado + " " +vikingo1.salud); //normal, 100
		System.out.println(vikingo2.estado + " " +vikingo2.salud); //normal, 100
		
		vikingo2.realizarAtaque(); 
		vikingo1.recibirAtaque(vikingo2);
		
		System.out.println(vikingo1.estado + " " +vikingo1.salud); //colerico,90
		System.out.println(vikingo2.estado + " " +vikingo2.salud); //normal, 100
		
		vikingo2.realizarAtaque();
		vikingo1.recibirAtaque(vikingo2);
		System.out.println(vikingo1.estado + " " +vikingo1.salud); //berserker, 85
		System.out.println(vikingo2.estado + " " +vikingo2.salud); //normal, 100
		 
		vikingo1.realizarAtaque();
		vikingo2.recibirAtaque(vikingo1);
		
		System.out.println(vikingo1.estado+ " " +vikingo1.salud); //berserker,85
		System.out.println(vikingo2.estado+ " " +vikingo2.salud);// colerico,70
		
		vikingo1.meditar(); //normal
		vikingo1.meditar(); //calmado
		
		System.out.println(vikingo1.estado+ " " +vikingo1.salud); //calmado,85
		System.out.println(vikingo2.estado+ " " +vikingo2.salud); //colerico,70
		
		vikingo2.realizarAtaque(); 
		
		vikingo1.recibirAtaque(vikingo2);
		
		System.out.println(vikingo1.estado+ " " +vikingo1.salud); //calmado, no recibe daño. 85
		System.out.println(vikingo2.estado+ " " +vikingo2.salud); //colerico,70
		
		
		
	}

}
