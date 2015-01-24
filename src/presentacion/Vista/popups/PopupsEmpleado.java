/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.popups;

import javax.swing.JOptionPane;


public class PopupsEmpleado {
    
    public PopupsEmpleado(){
        super();
    }
    
     public static void AltaEmpleadoExito(){

      JOptionPane.showMessageDialog(null, "Se ha dado de alta el empleado con exito ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void AltaEmpleadoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido dar de alta al empleado ","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void BajaEmpleadoExito(){

      JOptionPane.showMessageDialog(null, "Se ha dado de baja el empleado con exito ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void BajaEmpleadoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido dar de baja al empleado","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void ModificarEmpleadoExito(){

      JOptionPane.showMessageDialog(null, "Se ha modificado el empleado correctamente ","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void ModificarEmpleadoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido modificar el empleado","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void MostrarEmpleadoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido mostrar el empleado","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    public static void MostrarListaEmpleadosFracaso(){

      JOptionPane.showMessageDialog(null, "No se hay Empleados que mostrar","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
}
