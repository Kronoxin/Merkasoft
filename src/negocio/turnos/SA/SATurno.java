/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.turnos.SA;

import java.util.ArrayList;
import negocio.turnos.Turno;


public interface SATurno {
    public int altaTurno(Turno turno);
    public boolean bajaTurno(int id);
    public boolean modificarTurno(Turno turno);
    public Turno mostrarTurno(int id);
    public ArrayList<Turno> mostrarListaTurnos();
    
}
