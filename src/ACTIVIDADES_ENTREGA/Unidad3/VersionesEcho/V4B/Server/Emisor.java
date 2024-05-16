package ACTIVIDADES_ENTREGA.Unidad3.VersionesEcho.V4B.Server;

import java.io.IOException;

public class Emisor extends Thread {

	private Almacen almacen;

	public Emisor(Almacen almacen) {
		this.almacen = almacen;
	}

	@Override
	public void run() {
		while (true) {
			Item item = almacen.retirar();
			try {
				item.getOut().writeUTF(item.getString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
