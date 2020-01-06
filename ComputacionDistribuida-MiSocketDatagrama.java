import java.net.*;
import java.io.*;

/**
 * Una subclase de DatagramSocket que envía y recibe mensajes.
 */
 public class MiSocketDatagrama extends DatagramSocket {
 static final int MAX_LON = 10;

 MiSocketDatagrama(int numPuerto) throws SocketException {
 super(numPuerto);
 }

 public void enviaMensaje(InetAddress maquinaReceptora, int puertoReceptor, String mensaje) throws IOException {
 byte[] almacenEnvio = mensaje.getBytes();
 DatagramPacket datagrama = new DatagramPacket(almacenEnvio, almacenEnvio.length, maquinaReceptora, puertoReceptor);
 this.send(datagrama);
 }

 public String recibeMensaje() throws IOException {
 byte[] almacenRecepcion = new byte[MAX_LON];
 DatagramPacket datagrama = new DatagramPacket(almacenRecepcion, MAX_LON);
 this.receive(datagrama);
 String mensaje = new String(almacenRecepcion);
 return mensaje;
 }
 } //fin class
