package testMoniteur;

interface ProdConsInterface {
	
	public void Deposer(int m) throws InterruptedException;
	public int Prelever() throws InterruptedException;
	
}