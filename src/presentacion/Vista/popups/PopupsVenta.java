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
public class PopupsVenta {
    
    public PopupsVenta(){
        super();
    }
    
    public static void AltaVentaExito(){

      JOptionPane.showMessageDialog(null, "Se ha creado la venta correctamente ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    public static void AltaVentaFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido crear la venta ","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void BajaVentaExito(){

      JOptionPane.showMessageDialog(null, "Se ha devuelto los productos correctamente","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void BajaVentaFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido devolver los productos","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    
}
