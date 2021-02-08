import java.util.ArrayList;

public class Membre extends Utilisateur {

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

}
