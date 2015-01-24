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
public class PopupsHorarios {
    
    public PopupsHorarios(){
        super();
    }
    
    
    public static void AsignarTurnoEmpleadoExito(){

      JOptionPane.showMessageDialog(null, "Se ha asignado el turno correctamente","Correcto",JOptionPane.INFORMATION_MESSAGE);
      
    }
    
    public static void AsignarTurnoEmpleadoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido asignar el turno","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void MostrarTurnosEmpleadoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido mostrar los turnos ","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
    public static void MostrarRelacionTurnoFracaso(){

      JOptionPane.showMessageDialog(null, "No se ha podido mostrar la relación Turnos-Empleado","Error",JOptionPane.ERROR_MESSAGE);
      
    }
    
}
