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
			System.out.println("Filosofo: " + i + " esta pensando");
			x.tomarTenedores(i);
			Util.mySleep(1000);
			System.out.println("Filosofo: " + i + " esta comiendo con tenedor: " + i + " y tenedor: " + ((i + 1) % 5));
			Util.mySleep(1000);
			x.bajarTenedores(i);
			System.out.println("Filosofo: " + i + " esta bajando el tenedor " + i + " y el tenedor: " + ((i + 1) % 5));
		}
	}
	
	
}

