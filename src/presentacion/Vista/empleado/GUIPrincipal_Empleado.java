/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.empleado;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Ruben
 */
public class GUIPrincipal_Empleado extends JPanel{
    
    JPanel panel_botones_empleados = new JPanel(new GridLayout(5,1,4,4));
        JPanel panel_auxiliar = new JPanel();
        
        JButton boton_alta_empleado = new JButton("Alta Empleado");
        JButton boton_baja_empleado = new JButton("Baja Empleado");
        JButton boton_mostrar_empleado = new JButton("Mostrar Empleado");
        JButton boton_modificar_empleado = new JButton("Modificar Empleado");
        JButton boton_mostrar_lista_empleados = new JButton("Listado de Empleados");

        TitledBorder borde_empleados = new TitledBorder("Empleado");

    
    public GUIPrincipal_Empleado(){

        this.setLayout(new GridLayout(1, 2));

        borde_empleados.setTitleFont(new Font(null, Font.BOLD, 16));
        borde_empleados.setTitleJustification(TitledBorder.CENTER);
        panel_botones_empleados.setBorder(borde_empleados);

        panel_botones_empleados.add(boton_alta_empleado);
        panel_botones_empleados.add(boton_mostrar_empleado);
        panel_botones_empleados.add(boton_modificar_empleado);
        panel_botones_empleados.add(boton_baja_empleado);
        panel_botones_empleados.add(boton_mostrar_lista_empleados);
        
        boton_alta_empleado.addActionListener(new oyenteCliente());
        boton_baja_empleado.addActionListener(new oyenteCliente());
        boton_mostrar_empleado.addActionListener(new oyenteCliente());
        boton_modificar_empleado.addActionListener(new oyenteCliente());
        boton_mostrar_lista_empleados.addActionListener(new oyenteCliente());
        
     //   panel_auxiliar.add(baja);

        this.add(panel_botones_empleados);
       // this.add(panel_auxiliar);
                

        
    }
    
  
    class oyenteCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource() ==  boton_alta_empleado ){
                    Controlador.getInstance().accion(EventoNegocio.GUI_ALTA_EMPLEADO,GUIPrincipal_Empleado.this);
            }
            else if( e.getSource() == boton_baja_empleado){
                  //  Controlador.getInstance().accion(EventoNegocio.GUI_BAJA_EMPLEADO, GUIPrincipal_Empleado.this);
            
            }
            else if( e.getSource() == boton_modificar_empleado){
                  //  Controlador.getInstance().accion(EventoNegocio.GUI_MODIFICAR_EMPLEADO, GUIPrincipal_Empleado.this);
            }
            else if (e.getSource() == boton_mostrar_empleado) {
                  //  Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_EMPLEADO, GUIPrincipal_Empleado.this);

            }else if (e.getSource() == boton_mostrar_lista_empleados) {
                  //  Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_LISTA_EMPLEADOS, GUIPrincipal_Empleado.this);

            }
        }

    }
    
    //getters y setters

    public JPanel getPanel_botones_empleados() {
        return panel_botones_empleados;
    }

    public void setPanel_botones_empleados(JPanel panel_botones_empleados) {
        this.panel_botones_empleados = panel_botones_empleados;
    }

    public JPanel getPanel_auxiliar() {
        return panel_auxiliar;
    }

    public void setPanel_auxiliar(JPanel panel_auxiliar) {
        this.panel_auxiliar = panel_auxiliar;
    }

    public JButton getBoton_alta_empleado() {
        return boton_alta_empleado;
    }

    public void setBoton_alta_empleado(JButton boton_alta_empleado) {
        this.boton_alta_empleado = boton_alta_empleado;
    }

    public JButton getBoton_baja_empleado() {
        return boton_baja_empleado;
    }

    public void setBoton_baja_empleado(JButton boton_baja_empleado) {
        this.boton_baja_empleado = boton_baja_empleado;
    }

    public JButton getBoton_mostrar_empleado() {
        return boton_mostrar_empleado;
    }

    public void setBoton_mostrar_empleado(JButton boton_mostrar_empleado) {
        this.boton_mostrar_empleado = boton_mostrar_empleado;
    }

    public JButton getBoton_modificar_empleado() {
        return boton_modificar_empleado;
    }

    public void setBoton_modificar_empleado(JButton boton_modificar_empleado) {
        this.boton_modificar_empleado = boton_modificar_empleado;
    }

    public JButton getBoton_mostrar_lista_empleados() {
        return boton_mostrar_lista_empleados;
    }

    public void setBoton_mostrar_lista_empleados(JButton boton_mostrar_lista_empleados) {
        this.boton_mostrar_lista_empleados = boton_mostrar_lista_empleados;
    }


    public TitledBorder getBorde_empleados() {
        return borde_empleados;
    }

    public void setBorde_empleados(TitledBorder borde_empleados) {
        this.borde_empleados = borde_empleados;
    }
    
    
    
}
