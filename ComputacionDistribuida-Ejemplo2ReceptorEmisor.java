import java.net.*;

/**
 * Aplicación que recibe un mensaje y después lo manda utilizando un socket datagrama
 * sin conexión.
 * Se esperan cuatro argumentos:
 * <nombre de dominio o dirección IP del receptor>
 * <número de puerto del socket datagrama del receptor>
 * <número de puerto del socket datagrama de este proceso>
 * <mensaje, una cadena, para mandar>
 */
 public class Ejemplo2ReceptorEmisor {
 public static void main(String[] args) {
 if(args.length != 4)
  System.out.println("Se requieren 4 argumentos");
 else {
  try {
    InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
    int puertoReceptor = Integer.parseInt(args[1]);
    int miPuerto = Integer.parseInt(args[2]);
    String mensaje = args[3];
    MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
    System.out.println(miSocket.recibeMensaje());
    miSocket.enviaMensaje(maquinaReceptora, puertoReceptor, mensaje);
    miSocket.close();
  } //fin try
  catch (Exception e) {
    e.printStackTrace();
  } //fin catch
 } //fin else
 } //fin main
 } //fin class
