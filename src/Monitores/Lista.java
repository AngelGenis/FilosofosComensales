package Monitores;

import java.util.ArrayList;

class  Lista<k> extends ArrayList<k> {
	private static final long serialVersionUID = 1L;
	
	public k set(int i, k element) {
        if (i < 0) 
            i = size() - 1;
        else if (i >= size())
            i = 0;
        return super.set(i, element);
    }

	public k get(int i) {
        if (i < 0)
            i = size() - 1;
        else if (i >= size())
            i = 0;
        return super.get(i);
    }    
}

class Mesa {
	Lista<String> estados = new Lista<String>();
	int contador = 0;
	
	public Mesa() {
		int i=0;
		while(i<5) {
			estados.add("Pensando");
			i++;
		}		
	}

	public synchronized void probarBocado(int i) {
		if (estados.get(i) == "Hambriento" && estados.get(i+1) != "Comiendo" && estados.get(i-1) != "Comiendo")
			estados.set(i, "Comiendo");
	}
	public synchronized void bajarTenedores(int i) {
		probarBocado(i - 1);
		probarBocado(i + 1);
		estados.set(i, "Pensando");
		notify();
	}
	public synchronized void tomarTenedores(int i) {
		while (estados.get(i - 1) == "Comiendo" || estados.get(i + 1) == "Comiendo") 
			Util.myWait(this);
	
		estados.set(i, "Hambriento");
		probarBocado(i);
	}
	
}