import java.util.ArrayList;

public class Utilisateur {
	
	private static int identifiant = 0;
	private String nom;
	private String prenom;
	protected ArrayList<Livre> livresDeLaLibrairie = new ArrayList<Livre>();
	
	public Utilisateur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant ++;
	}
	
	public int getIdentifiant() {
		int id = this.identifiant;
		return id;
	}
	
	public void voirLaListe() {
		for (int i = 0; i < livresDeLaLibrairie.size(); i++) {
			System.out.println(livresDeLaLibrairie.get(i));
		}
	}

}
