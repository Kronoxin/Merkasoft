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
public class PopupsProducto {
    
    public PopupsProducto(){
        super();
    }
    
    public static void AltaProductoExito(int id){

        
      JOptionPane.showMessageDialog(null, "Se ha dado de alta el producto "+id+" correctamente ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void AltaProductoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido dar de alta el producto","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void BajaProductoExito(){

      JOptionPane.showMessageDialog(null, "Se ha dado de baja el producto correctamente ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void BajaProductoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido dar de baja el producto ","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void ModificarProductoExito(){

      JOptionPane.showMessageDialog(null, "Se ha dado modificado el producto correctamente ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void ModificarProductoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido modificar el producto","Correcto",JOptionPane.ERROR_MESSAGE);
      
    }
    
   
    
}
