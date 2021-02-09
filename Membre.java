import java.util.ArrayList;

public class Membre extends Utilisateur {

	/*
	 * Classe Membre qui hérite d'Utilisateur, un membre est donc un utilisateur
	 * */

	// Liste des documents empruntés par le membre
	private ArrayList<Livre> livresEmpruntes = new ArrayList<Livre>();

	public Membre() {
		super();
	}

	public void nouvelEmprunt(Livre livreAEmprunter) {
		livresEmpruntes.add(livreAEmprunter);
	}

	public void rendreLivre(Livre livreARendre) {
		if (livresEmpruntes.contains(livreARendre))
			livresEmpruntes.remove(livreARendre);
		else System.out.println("Vous n'avez pas emprunté ce livre");
	}

	public boolean livreDansLaListe(Livre livre) {
		return livresEmpruntes.contains(livre);
	}

	public void voirLaListe() {
		if(livresEmpruntes.size()>0) {
			System.out.println("Voici les documents que vous avez emprunté:");
			for (int i = 0; i < livresEmpruntes.size(); i++) {
				System.out.println(livresEmpruntes.get(i).getTitre());
			}
		}
		else System.out.println("Votre liste est vide");
	}

}
