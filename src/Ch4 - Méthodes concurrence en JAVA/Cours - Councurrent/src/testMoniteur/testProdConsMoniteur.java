package testMoniteur;

public class testProdConsMoniteur {
	public static void main(String[] args) {
		ProdConsMoniteur verrou = new ProdConsMoniteur(2);
		Producteur p1 = new Producteur(verrou);
		Consommateur c1 = new Consommateur(verrou);
		Producteur p2 = new Producteur(verrou);
		Consommateur c2 = new Consommateur(verrou);
		p1.setName("P1");
		p1.start();
		c1.setName("C1");
		c1.start();
		p2.setName("P2");
		p2.start();
		c2.setName("C2");
		c2.start();
	}
}