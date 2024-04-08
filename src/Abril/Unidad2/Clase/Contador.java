package ProgramacionMultihilos;

public class Contador {
	long v;

	// Crear contadores por defecto
	public Contador() {

	}

	// Crear contadores con cantidad expecifica
	public Contador(long v) {
		this.v = v;
	}
	
	public void in() {
		v++;
	}

	public long getValor() {
		return v;
	}
}
