import java.util.ArrayList;

public class Utilisateur {
	
	private static int identifiant = 0;
	
	public Utilisateur() {
		this.identifiant ++;
	}
	
	public int getIdentifiant() {
		int id = this.identifiant;
		return id;
	}

}
