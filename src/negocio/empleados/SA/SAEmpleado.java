/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.empleados.SA;

import java.math.BigDecimal;
import java.util.ArrayList;
import negocio.empleados.Empleado;

/**
 *
 * @author Ruben
 */
//meter los CRUD
public interface SAEmpleado 
{
    
    public int altaEmpleado(Empleado empleado);
    public  boolean bajaEmpleado(int id);
    public boolean modificarEmpleado(Empleado empleado);
    public Empleado mostrarEmpleado(int id);
    public ArrayList<Empleado> mostrarListaEmpleados();    
}
