import java.util.ArrayList;

public class Membre extends Utilisateur {

	ArrayList<Livre> livresEmpruntes = new ArrayList<Livre>();
	
	public Membre(String nom, String prenom) {
		super(nom, prenom);
	}
	
	public void emprunterUnLivre(Livre livreAEmprunter) {
		if(livresDeLaLibrairie.contains(livreAEmprunter)) {
			if(livreAEmprunter.estEmpruntable()) {
				livresEmpruntes.add(livreAEmprunter);
				livreAEmprunter.livreEmprunte(true);
				System.out.println(this.getIdentifiant() + " a emprunté le livre " + livreAEmprunter.getTitre() +
						"jusqu'au ");
			} else {
				System.out.println("Le livre " + livreAEmprunter.getTitre() + " est déjà emprunté par un autre"
						+ " utilisateur jusqu'au ");
			}
		}
	}

}
