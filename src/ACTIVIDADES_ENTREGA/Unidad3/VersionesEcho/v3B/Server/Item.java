package ACTIVIDADES_ENTREGA.Unidad3.VersionesEcho.v3B.Server;

import java.io.DataOutputStream;

public class Item {
	private String string;
	private DataOutputStream out;
	
	public Item(String string, DataOutputStream out) {
		this.string = string;
		this.out = out;
	}

	public String getString() {
		return string;
	}

	public DataOutputStream getOut() {
		return out;
	}
	
	
}
