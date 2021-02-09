public class Utilisateur {
	
	/*
	 * Classe Utilisateur qui sert à initialiser les utilisateurs et l'identifiant
	 * */
	
	private static int identifiant = 0;
	
	/*
	 * L'identifiant est static et on l'incrémente à chaque création d'un utilisateur
	 * */
	public Utilisateur() {
		Utilisateur.identifiant ++;
	}
	
	public int getIdentifiant() {
		int id = Utilisateur.identifiant;
		return id;
	}

}
