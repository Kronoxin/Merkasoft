/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.horario;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


public class GUIPrincipal_Horario extends JPanel{
    
     JPanel panel_botones_horarios = new JPanel(new GridLayout(4,1,4,4));

        TitledBorder borde_horarios = new TitledBorder("Horarios");

        JButton boton_asignar_turno_empleado = new JButton("Asignar Turno a Empleado");
        JButton boton_mostrar_turnos_empleado = new JButton("Mostrar Turnos de un Empleado");
        JButton boton_mostrar_relacion_turno_empleado = new JButton("Mostrar Relación Turnos-Empleados");

        
        public GUIPrincipal_Horario(){
            
            this.setLayout(new GridLayout(1, 2));
        
            borde_horarios.setTitleFont(new Font(null, Font.BOLD, 16));
            borde_horarios.setTitleJustification(TitledBorder.CENTER);
            panel_botones_horarios.setBorder(borde_horarios);

            panel_botones_horarios.add(boton_asignar_turno_empleado);
            panel_botones_horarios.add(boton_mostrar_turnos_empleado);
            panel_botones_horarios.add(boton_mostrar_relacion_turno_empleado);

        
        //incorporamos el actionListener!
        boton_asignar_turno_empleado.addActionListener(new oyenteHorario());
        boton_mostrar_turnos_empleado.addActionListener(new oyenteHorario());
        boton_mostrar_relacion_turno_empleado.addActionListener(new oyenteHorario());

        this.add(panel_botones_horarios);
      //  this.add(mostrar_una);
        this.setVisible(true);
    }
        
    class oyenteHorario implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource() ==  boton_asignar_turno_empleado){
                    Controlador.getInstance().accion(EventoNegocio.GUI_ASIGNAR_TURNO_EMPLEADO, GUIPrincipal_Horario.this);
            }
            else if( e.getSource() == boton_mostrar_turnos_empleado){
                    Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_TURNOS_EMPLEADO, GUIPrincipal_Horario.this);
            }
            else if( e.getSource() == boton_mostrar_relacion_turno_empleado){
                    Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_RELACION_TURNO_EMPLEADO, GUIPrincipal_Horario.this);
            }
        }
    }
    
    //getters y setters

    public JPanel getPanel_botones_horarios() {
        return panel_botones_horarios;
    }

    public void setPanel_botones_horarios(JPanel panel_botones_horarios) {
        this.panel_botones_horarios = panel_botones_horarios;
    }

    public TitledBorder getBorde_horarios() {
        return borde_horarios;
    }

    public void setBorde_horarios(TitledBorder borde_horarios) {
        this.borde_horarios = borde_horarios;
    }

    public JButton getBoton_asignar_turno_empleado() {
        return boton_asignar_turno_empleado;
    }

    public void setBoton_asignar_turno_empleado(JButton boton_asignar_turno_empleado) {
        this.boton_asignar_turno_empleado = boton_asignar_turno_empleado;
    }

    public JButton getBoton_mostrar_turnos_empleado() {
        return boton_mostrar_turnos_empleado;
    }

    public void setBoton_mostrar_turnos_empleado(JButton boton_mostrar_turnos_empleado) {
        this.boton_mostrar_turnos_empleado = boton_mostrar_turnos_empleado;
    }

    public JButton getBoton_mostrar_relacion_turno_empleado() {
        return boton_mostrar_relacion_turno_empleado;
    }

    public void setBoton_mostrar_relacion_turno_empleado(JButton boton_mostrar_relacion_turno_empleado) {
        this.boton_mostrar_relacion_turno_empleado = boton_mostrar_relacion_turno_empleado;
    }
    
    
}
