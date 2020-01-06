import java.net.*;
import java.io.*;

/**
 * Mandar un mensaje utilizando un socket datagrama sin conexión.
 * Se esperan tres argumentos:
 * <nombre del dominio o dirección IP del receptor>
 * <número de puerto del socket del receptor>
 * <mensaje para mandar>
 */
 public class Ejemplo1Emisor {
 public static void main(String[] args) {
 if(args.length != 3)
  System.out.println("Se requieren 3 argumentos");
 else {
  try {
    InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
    int puertoReceptor = Integer.parseInt(args[1]);
    String mensaje = args[2];
    DatagramSocket miSocket = new DatagramSocket();
    byte[] almacen = mensaje.getBytes();
    DatagramPacket datagrama = new DatagramPacket(almacen, almacen.length,maquinaReceptora, puertoReceptor);
    miSocket.send(datagrama);
    miSocket.close();
  } //fin try
  catch (Exception e) {
    e.printStackTrace();
  } //fin catch
 } //fin else
 } //fin main
 } //fin class
