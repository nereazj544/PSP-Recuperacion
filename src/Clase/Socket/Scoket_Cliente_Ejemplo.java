package Clase.Scoket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Scoket_Cliente_Ejemplo {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Escribe: ");
        String linea;

        while ((linea = teclado.readLine())!= null) {
            Socket socket = new Socket("localhost", 5000);
            try (DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                
                out.writeUTF(linea);

                System.out.println(in.readUTF());
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        
    }
}
