/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.departamento;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


public class GUIPrincipal_Departamento extends JPanel{
    
    JPanel panel_botones_departamentos = new JPanel(new GridLayout(6,1,4,4));
        JPanel panel_auxiliar = new JPanel();
        
        JButton boton_alta_departamento = new JButton("Alta Departamento");
        JButton boton_baja_departamento = new JButton("Baja Departamento");
        JButton boton_mostrar_departamento = new JButton("Mostrar Departamento");
        JButton boton_modificar_departamento = new JButton("Modificar Departamento");
        JButton boton_mostrar_lista_departamentos = new JButton("Listado de Departamentos");
        JButton boton_nomina_departamentos = new JButton("Calcular Nomina Departamentos");

        TitledBorder borde_departamentos = new TitledBorder("Departamentos");

    
    public GUIPrincipal_Departamento(){

        this.setLayout(new GridLayout(1, 2));

        borde_departamentos.setTitleFont(new Font(null, Font.BOLD, 16));
        borde_departamentos.setTitleJustification(TitledBorder.CENTER);
        panel_botones_departamentos.setBorder(borde_departamentos);

        panel_botones_departamentos.add(boton_alta_departamento);
        panel_botones_departamentos.add(boton_mostrar_departamento);
        panel_botones_departamentos.add(boton_modificar_departamento);
        panel_botones_departamentos.add(boton_baja_departamento);
        panel_botones_departamentos.add(boton_mostrar_lista_departamentos);
        panel_botones_departamentos.add(boton_nomina_departamentos);
        
        boton_alta_departamento.addActionListener(new oyenteDepartamento());
        boton_baja_departamento.addActionListener(new oyenteDepartamento());
        boton_mostrar_departamento.addActionListener(new oyenteDepartamento());
        boton_nomina_departamentos.addActionListener(new oyenteDepartamento());
        boton_modificar_departamento.addActionListener(new oyenteDepartamento());
        boton_mostrar_lista_departamentos.addActionListener(new oyenteDepartamento());
        
     //   panel_auxiliar.add(baja);

        this.add(panel_botones_departamentos);
       // this.add(panel_auxiliar);
                

        
    }
    
  
    class oyenteDepartamento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource() ==  boton_alta_departamento ){
                    Controlador.getInstance().accion(EventoNegocio.GUI_ALTA_DEPARTAMENTO,GUIPrincipal_Departamento.this);
            }
            else if( e.getSource() == boton_baja_departamento){
                    Controlador.getInstance().accion(EventoNegocio.GUI_BAJA_DEPARTAMENTO, GUIPrincipal_Departamento.this);
            }
            else if( e.getSource() == boton_nomina_departamentos){
                    Controlador.getInstance().accion(EventoNegocio.GUI_CALCULAR_NOMINA_DEPARTAMENTO, GUIPrincipal_Departamento.this);
            }
            else if( e.getSource() == boton_modificar_departamento){
                    Controlador.getInstance().accion(EventoNegocio.GUI_MODIFICAR_DEPARTAMENTO, GUIPrincipal_Departamento.this);
            }
            else if (e.getSource() == boton_mostrar_departamento) {
                    Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_DEPARTAMENTO, GUIPrincipal_Departamento.this);

            }else if (e.getSource() == boton_mostrar_lista_departamentos) {
                    Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_LISTA_DEPARTAMENTOS, GUIPrincipal_Departamento.this);

            }
        }

    }
    
}
