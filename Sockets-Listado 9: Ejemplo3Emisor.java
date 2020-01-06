import java.net.*;

/**
 * Aplicación que utiliza un socket datagrama orientado a conexión para mandar
 * múltiples mensajes, y después recibe uno.
 * Se esperan cuatro argumentos:
 * <nombre de dominio o dirección IP del receptor>
 * <número de puerto del socket datagrama del otro proceso>
 * <número de puerto del socket datagrama de este proceso>
 * <mensaje, una cadena, para mandar>
 */
 public class Ejemplo3Emisor {
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
    miSocket.connect(maquinaReceptora, puertoReceptor);
    for(int i=0; i<10; i++)
    miSocket.enviaMensaje(maquinaReceptora, puertoReceptor, mensaje);

    System.out.println(miSocket.recibeMensaje());

    miSocket.disconnect();
    miSocket.close();
  } //fin try
  catch (Exception e) {
    e.printStackTrace();
  } //fin catch
 } //fin else
 } //fin main
 } //fin class
