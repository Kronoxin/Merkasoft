/*
 * Clase que contiene diferentes popups de informacion y errores
 */
package presentacion.Vista.popups;

import javax.swing.JOptionPane;

public class PopupsErrores {
    public PopupsErrores()
    {
        super();
    }
    public static void FaltaDeDatos ()
    {
        JOptionPane.showMessageDialog(null, "Hay campos en blanco o faltan datos\nCorrija los errores para continuar","Informacion",JOptionPane.INFORMATION_MESSAGE);
    }
}
