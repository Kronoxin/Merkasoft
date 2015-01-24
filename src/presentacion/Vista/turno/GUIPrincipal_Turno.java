/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.turno;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


public class GUIPrincipal_Turno extends JPanel {
    
    JPanel panel_botones_turnos = new JPanel(new GridLayout(5,1,4,4));
        JPanel panel_auxiliar = new JPanel();
        
        JButton boton_alta_turno = new JButton("Alta Turno");
        JButton boton_baja_turno = new JButton("Baja Turno");
        JButton boton_mostrar_turno = new JButton("Mostrar Turno");
        JButton boton_modificar_turno = new JButton("Modificar Turno");
        JButton boton_mostrar_lista_turnos = new JButton("Listado de Turnos");;

        TitledBorder borde_turnos = new TitledBorder("Turnos");

    
    public GUIPrincipal_Turno(){

        this.setLayout(new GridLayout(1, 2));

        borde_turnos.setTitleFont(new Font(null, Font.BOLD, 16));
        borde_turnos.setTitleJustification(TitledBorder.CENTER);
        panel_botones_turnos.setBorder(borde_turnos);

        panel_botones_turnos.add(boton_alta_turno);
        panel_botones_turnos.add(boton_mostrar_turno);
        panel_botones_turnos.add(boton_modificar_turno);
        panel_botones_turnos.add(boton_baja_turno);
        panel_botones_turnos.add(boton_mostrar_lista_turnos);
        
        boton_alta_turno.addActionListener(new oyenteTurno());
        boton_baja_turno.addActionListener(new oyenteTurno());
        boton_mostrar_turno.addActionListener(new oyenteTurno());
        boton_modificar_turno.addActionListener(new oyenteTurno());
        boton_mostrar_lista_turnos.addActionListener(new oyenteTurno());
        
     //   panel_auxiliar.add(baja);

        this.add(panel_botones_turnos);
       // this.add(panel_auxiliar);
                

        
    }
    
  
    class oyenteTurno implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource() ==  boton_alta_turno ){
                    Controlador.getInstance().accion(EventoNegocio.GUI_ALTA_TURNO,GUIPrincipal_Turno.this);
            }
            else if( e.getSource() == boton_baja_turno){
                    Controlador.getInstance().accion(EventoNegocio.GUI_BAJA_TURNO, GUIPrincipal_Turno.this);
            }
            else if( e.getSource() == boton_modificar_turno){
                    Controlador.getInstance().accion(EventoNegocio.GUI_MODIFICAR_TURNO, GUIPrincipal_Turno.this);
            }
            else if (e.getSource() == boton_mostrar_turno) {
                    Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_TURNO, GUIPrincipal_Turno.this);

            }else if (e.getSource() == boton_mostrar_lista_turnos) {
                    Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_LISTA_TURNOS, GUIPrincipal_Turno.this);

            }
        }

    }
    
}
