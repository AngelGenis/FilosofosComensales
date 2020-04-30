package Monitores;

public class Main {
	public static void main(String[] args) {
		Filosofo filosofos[] = new Filosofo[5];
		Mesa b = new Mesa();
		
		int i=0;
		while(i<5) {
			filosofos[i] = new Filosofo(b, i);
			i++;
		}
		
	}
}
