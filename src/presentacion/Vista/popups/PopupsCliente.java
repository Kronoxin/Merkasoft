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
public class PopupsCliente {
    
    public PopupsCliente(){
        super();
    }
    
    public static void AltaClienteExito(){

      JOptionPane.showMessageDialog(null, "Se ha dado de alta el cliente con exito ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void AltaClienteFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido dar de alta al cliente ","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void BajaClienteExito(){

      JOptionPane.showMessageDialog(null, "Se ha dado de baja el cliente con exito ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void BajaClienteFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido dar de baja al cliente","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void ModificarClienteExito(){

      JOptionPane.showMessageDialog(null, "Se ha modificado el cliente correctamente ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void ModificarClienteFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido modificar el cliente","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    
    
    
    
  /*  //Main de prueba
    public static void main(String[] args){
          BajaClienteExito();
          BajaClienteFracaso();
            
            

    }*/
    
}
