/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.popups;

import javax.swing.JOptionPane;


public class PopupsDepartamento {
    
    public PopupsDepartamento(){
        super();
    }
    
     public static void AltaDepartamentoExito(){

      JOptionPane.showMessageDialog(null, "Se ha dado de alta el departamento con exito ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void AltaDepartamentoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido dar de alta el departamento ","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void BajaDepartamentoExito(){

      JOptionPane.showMessageDialog(null, "Se ha dado de baja el departamento con exito ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void BajaDepartamentoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido dar de baja el departamento","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void ModificarDepartamentoExito(){

      JOptionPane.showMessageDialog(null, "Se ha modificado el departamento correctamente ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void ModificarDepartamentoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido modificar el departamento","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
}
