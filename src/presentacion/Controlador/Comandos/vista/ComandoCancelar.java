
import javax.swing.JDialog;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;

/**
 * Clase ComandoCancelar: cierra una ventana grafica de un mensaje de confirmacion
 */
public class ComandoCancelar implements Command {

	@Override
	public RespuestaComando execute(Object datos) {
		// TODO Auto-generated method stub
		JDialog ventana = (JDialog) datos;
		ventana.dispose();
		return null;
	}

}
