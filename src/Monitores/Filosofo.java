package Monitores;

public class Filosofo extends Thread{
	Mesa x = null;
	int i;
	
	
	public Filosofo(Mesa x, int i) {
		this.i = i;
		this.x = x;
		new Thread(this).start();
	}

	public void run() {
		while (true) {
			int n = i+1;
			System.out.println("Filosofo: " + n + " esta pensando");
			x.tomarTenedores(i);
			Util.mySleep(1000);
			System.out.println("Filosofo: " + n + " esta comiendo con tenedor: " + n + " y tenedor: " + ((n + 1) % 5));
			Util.mySleep(1000);
			x.bajarTenedores(i);
			System.out.println("Filosofo: " + n + " esta bajando el tenedor " + n + " y el tenedor: " + ((n + 1) % 5));
		}
	}
	
	
}

