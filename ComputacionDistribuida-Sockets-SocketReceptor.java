import java.net.*;
import java.io.*;

/**
 * Recibir un mensaje utilizando un socket datagrama sin conexión.
 * Se espera un argumento:
 * <número de puerto del socket del receptor>
 */
 public class EjemploReceptor {
 public static void main(String[] args) {
 if(args.length != 1)
  System.out.println("Se requiere 1 argumento");
 else {
  int puerto = Integer.parseInt(args[0]);
  final int MAX_LON = 10; //Longitud máxima en octetos admitida
  try {
    DatagramSocket miSocket = new DatagramSocket(puerto);
    byte[] almacen = new byte[MAX_LON];
    DatagramPacket datagrama = new DatagramPacket(almacen, MAX_LON);
    miSocket.receive(datagrama);
    String mensaje = new String(almacen);
    System.out.println(mensaje);
    miSocket.close();
  } //fin try
  catch (Exception e) {
    e.printStackTrace();
  } // fin catch
  } //fin else
 } //fin main
 } //fin class
