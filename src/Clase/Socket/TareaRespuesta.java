package Clase.Socket;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TareaRespuesta implements Runnable{

    private Socket socket;

    public TareaRespuesta(Socket socket) {
        this.socket = socket;
    }





    @Override
    public void run() {
        //! La parte respuesta lo que tiene que hacer es recibir una cadena (String), la envia y cierra la conexion.

        try (DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            //! UTF = Metodo que sirve para ver y el otro para enviar
            String s = in.readUTF();
            System.out.println("MOSTRANDO: " + s);
            out.writeUTF(s);

            System.out.println("ADIOS MARY CARMEN");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
