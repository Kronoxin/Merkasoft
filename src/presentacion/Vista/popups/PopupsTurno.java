/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.popups;

import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class PopupsTurno {
    
    public PopupsTurno(){
        super();
    }
    
     public static void AltaTurnoExito(){

      JOptionPane.showMessageDialog(null, "Se ha dado de alta el turno con exito ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void AltaTurnoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido dar de alta el turno ","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void BajaTurnoExito(){

      JOptionPane.showMessageDialog(null, "Se ha dado de baja el turno con exito ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void BajaTurnoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido dar de baja el turno","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void ModificarTurnoExito(){

      JOptionPane.showMessageDialog(null, "Se ha modificado el turno correctamente ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void ModificarTurnoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido modificar el turno","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
}
