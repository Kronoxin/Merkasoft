/*
 * Clase que continene las clases para el control del formato de las entidades
 */
package presentacion.Vista;

import negocio.departamentos.Departamento;
import negocio.empleados.Empleado;
import negocio.empleados.Supervisor;
import negocio.empleados.Trabajador;
import negocio.turnos.Turno;

/**
 *
 * @author Jose Luis
 */
public class ControlErrores 
{
     //Metodo de control de errores para la entidad empleado y sus especializaciones
    public boolean controlErroresEmpleado(Empleado empleado)
    {
        boolean correcto=false;
        if(empleado.getDisponible())
        {
            if(!empleado.getApellidos().isEmpty() && !empleado.getNombre().isEmpty())
            {
                if(!empleado.getDireccion().isEmpty() && empleado.getSueldo()>0 && !empleado.getTipo().isEmpty())
                {
                    if(empleado.getTipo().equalsIgnoreCase("supervisor"))
                     {
                         Supervisor s =(Supervisor)empleado;
                         if(s.getFactor_productividad()>0)
                         {
                             correcto=true;
                         }
                         else
                         {
                            Trabajador t =(Trabajador)empleado;
                            if(t.getHoras_trabajadas()>0)
                            {
                                correcto=true;
                            }
                         }               
                     }
                }
            }
        }
        return correcto;
    }
    
    //Metodo de control de errores para la entidad turno
    public boolean controlErorresTurno(Turno turno)
    {
        boolean correcto=false;
        if(turno.isDisponible())
        {
            //Nombre no esta vacio
            if(!turno.getNombre().isEmpty())
            {
                //Control del formato de las horas
                if(turno.getHoraEntrada()>=0 &&turno.getHoraEntrada()<=23);
                {
                    if(turno.getHoraSalida()>=0 &&turno.getHoraSalida()<=23);
                    {
                        //Control del formato de los minutos
                        if(turno.getMinutoEntrada()>=0&&turno.getMinutoEntrada()<=60)
                        {
                            if(turno.getMinutoSalida()>=0&&turno.getMinutoSalida()<=60)
                            {
                                correcto=true;
                            }
                        }
                    }
                }
            }
        }
        return correcto;
    }
    
    //Metodo de control de errores para la entidad Departamento
    public boolean controlErroresDepartamento(Departamento departamento)
    {
        boolean correcto=false;
        if(departamento.isDisponible())
        {
            if(!departamento.getDescripcion().isEmpty()&& !departamento.getNombre().isEmpty())
            {
                correcto=true;
            }
        }
        return correcto;
    }
}
