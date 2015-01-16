/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.departamentos.SA;

import java.util.ArrayList;
import negocio.departamentos.Departamento;


public interface SADepartamento 
{
    public int altaDepartamento(Departamento empleado);
    public  boolean bajaDepartamento(int id);
    public boolean modificarDepartamento(Departamento empleado);
    public Departamento mostrarDepartamento(int id);
    public ArrayList<Departamento> mostrarListaDepartamentos();
}
