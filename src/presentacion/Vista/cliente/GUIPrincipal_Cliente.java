/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


public class GUIPrincipal_Cliente extends JPanel{
        
        JPanel panel_botones_clientes = new JPanel(new GridLayout(6,1,4,4));
        JPanel panel_auxiliar = new JPanel();
        
        JButton boton_alta_cliente = new JButton("Alta Cliente");
        JButton boton_baja_cliente = new JButton("Baja Cliente");
        JButton boton_mostrar_cliente = new JButton("Mostrar Cliente");
        JButton boton_modificar_cliente = new JButton("Modificar Cliente");
        JButton boton_mostrar_lista_clientes = new JButton("Listado de Clientes");
        JButton boton_media_clientes = new JButton("Media Clientes");

        TitledBorder borde_clientes = new TitledBorder("Clientes");

    
    public GUIPrincipal_Cliente(){

        this.setLayout(new GridLayout(1, 2));

        borde_clientes.setTitleFont(new Font(null, Font.BOLD, 16));
        borde_clientes.setTitleJustification(TitledBorder.CENTER);
        panel_botones_clientes.setBorder(borde_clientes);

        panel_botones_clientes.add(boton_alta_cliente);
        panel_botones_clientes.add(boton_mostrar_cliente);
        panel_botones_clientes.add(boton_modificar_cliente);
        panel_botones_clientes.add(boton_baja_cliente);
        panel_botones_clientes.add(boton_mostrar_lista_clientes);
        panel_botones_clientes.add(boton_media_clientes);
        
        boton_alta_cliente.addActionListener(new oyenteCliente());
        boton_baja_cliente.addActionListener(new oyenteCliente());
        boton_mostrar_cliente.addActionListener(new oyenteCliente());
        boton_media_clientes.addActionListener(new oyenteCliente());
        boton_modificar_cliente.addActionListener(new oyenteCliente());
        boton_mostrar_lista_clientes.addActionListener(new oyenteCliente());
        
     //   panel_auxiliar.add(baja);

        this.add(panel_botones_clientes);
       // this.add(panel_auxiliar);
                

        
    }
    
  
    class oyenteCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource() ==  boton_alta_cliente ){
                    Controlador.getInstance().accion(EventoNegocio.GUI_ALTA_CLIENTE,GUIPrincipal_Cliente.this);
            }
            else if( e.getSource() == boton_baja_cliente){
                    Controlador.getInstance().accion(EventoNegocio.GUI_BAJA_CLIENTE, GUIPrincipal_Cliente.this);
            }
            else if( e.getSource() == boton_media_clientes){
                    Controlador.getInstance().accion(EventoNegocio.GUI_MEDIA_CLIENTES, GUIPrincipal_Cliente.this);
            }
            else if( e.getSource() == boton_modificar_cliente){
                    Controlador.getInstance().accion(EventoNegocio.GUI_MODIFICAR_CLIENTE, GUIPrincipal_Cliente.this);
            }
            else if (e.getSource() == boton_mostrar_cliente) {
                    Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_CLIENTE, GUIPrincipal_Cliente.this);

            }else if (e.getSource() == boton_mostrar_lista_clientes) {
                    Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_LISTA_CLIENTES, GUIPrincipal_Cliente.this);

            }
        }

    }
    
    //getters y setters

   
    public JPanel getPanel_botones_clientes() {
        return panel_botones_clientes;
    }

    public void setPanel_botones_clientes(JPanel panel_botones_clientes) {
        this.panel_botones_clientes = panel_botones_clientes;
    }

    public JButton getBoton_alta_cliente() {
        return boton_alta_cliente;
    }

    public void setBoton_alta_cliente(JButton boton_alta_cliente) {
        this.boton_alta_cliente = boton_alta_cliente;
    }

    public JButton getBoton_baja_cliente() {
        return boton_baja_cliente;
    }

    public void setBoton_baja_cliente(JButton boton_baja_cliente) {
        this.boton_baja_cliente = boton_baja_cliente;
    }

    public JButton getBoton_mostrar_cliente() {
        return boton_mostrar_cliente;
    }

    public void setBoton_mostrar_cliente(JButton boton_mostrar_cliente) {
        this.boton_mostrar_cliente = boton_mostrar_cliente;
    }

    public JButton getBoton_modificar_cliente() {
        return boton_modificar_cliente;
    }

    public void setBoton_modificar_cliente(JButton boton_modificar_cliente) {
        this.boton_modificar_cliente = boton_modificar_cliente;
    }

    public JButton getBoton_mostrar_lista_clientes() {
        return boton_mostrar_lista_clientes;
    }

    public void setBoton_mostrar_lista_clientes(JButton boton_mostrar_lista_clientes) {
        this.boton_mostrar_lista_clientes = boton_mostrar_lista_clientes;
    }

    public JButton getBoton_media_clientes() {
        return boton_media_clientes;
    }

    public void setBoton_media_clientes(JButton boton_media_clientes) {
        this.boton_media_clientes = boton_media_clientes;
    }

    public TitledBorder getBorde_clientes() {
        return borde_clientes;
    }

    public void setBorde_clientes(TitledBorder borde_clientes) {
        this.borde_clientes = borde_clientes;
    }
    
    
     
}
