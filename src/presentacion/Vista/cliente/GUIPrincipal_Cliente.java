/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIPrincipal_Cliente extends JPanel{
    
    public GUIPrincipal_Cliente(){
        GUIAltaCliente alta_cliente = new GUIAltaCliente();
        GUIBajaCliente baja = new GUIBajaCliente();
        GUIMostrarCliente mostrar_cliente = new GUIMostrarCliente();
        GUIMostrarListaClientes lista_clientes = new GUIMostrarListaClientes();
        GUIModificarCliente mod = new GUIModificarCliente();
        GUIClientesMedia media = new GUIClientesMedia();
        
        this.setLayout(new GridLayout(1, 2));
        
        /*JPanel panel_aux = new JPanel();
        JLabel lab_aux = new JLabel("aqui");
        panel_aux.add(lab_aux);*/
        
         JPanel panel_botones_clientes = new JPanel(new GridLayout(6,1,4,4));
         
                
                TitledBorder borde_clientes = new TitledBorder("Clientes");
		borde_clientes.setTitleFont(new Font(null, Font.BOLD, 16));
		borde_clientes.setTitleJustification(TitledBorder.CENTER);
		panel_botones_clientes.setBorder(borde_clientes);
                
                
           
                
                JButton boton_alta_cliente = new JButton("Alta Cliente");
                JButton boton_baja_cliente = new JButton("Baja Cliente");
                JButton boton_mostrar_cliente = new JButton("Mostrar Cliente");
                JButton boton_modificar_cliente = new JButton("Modificar Cliente");
                JButton boton_mostrar_lista_clientes = new JButton("Listado de Clientes");
                JButton boton_media_clientes = new JButton("Media Clientes");
                
                panel_botones_clientes.add(boton_alta_cliente);
                panel_botones_clientes.add(boton_mostrar_cliente);
                panel_botones_clientes.add(boton_modificar_cliente);
                panel_botones_clientes.add(boton_baja_cliente);
                panel_botones_clientes.add(boton_mostrar_lista_clientes);
                panel_botones_clientes.add(boton_media_clientes);
                
                this.add(panel_botones_clientes);
                this.add(media);
                
    }
    
}
