/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.departamento;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import negocio.departamentos.Departamento;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Ruben
 */
public class GUIModificarDepartamento extends JFrame{
    
   
     Object[][] datos_entrada = {
        {"","","","",""}
       };
        
        String[] NombreColumnas = {"ID","Nombre", "Descripcion","Disponible","Version"};

        JTextField textID = new JTextField("");

        JPanel panelSuperior = new JPanel(new GridLayout(2,2,5,5));
        JPanel panelTabla = new JPanel();

        JLabel labID = new JLabel("ID del Departamento",JLabel.CENTER);
        JButton butID = new JButton("Buscar por ID");
        JButton boton_salir = new JButton("Salir");
        JButton boton_guardar = new JButton("Guardar");
        
        JTable tabla;
    
    public GUIModificarDepartamento(){
         this.setTitle("Modificar Departamento");
	setBounds(100, 100, 500, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
                
		
            panelSuperior.add(labID);
            panelSuperior.add(textID);
            panelSuperior.add(butID);

            //se crea la Tabla
            tabla = new JTable(datos_entrada, NombreColumnas);
            //cojo la primera columna de la tabla (el ID) y fijo el tamaño de esa columna
            tabla.getColumnModel().getColumn(0).setPreferredWidth(3);

            //dimensiones del Jtable
            tabla.setPreferredScrollableViewportSize(new Dimension(450, 70));
            //Creamos un JscrollPane y le agregamos la JTable
            JScrollPane scrollPane = new JScrollPane(tabla);
            panelTabla.add(scrollPane,BorderLayout.CENTER);

            boton_salir.setPreferredSize(new Dimension(90,40));
            boton_guardar.setPreferredSize(new Dimension(90, 40));
            boton_guardar.setForeground(Color.BLUE);
            boton_salir.setForeground(Color.red);
            
            JPanel panelBotones = new JPanel();
            JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,15));
            JPanel panelBotonGuardar = new JPanel(new FlowLayout(FlowLayout.LEFT,15,15));
            
           
            panelBoton.add(boton_salir);
            panelBotonGuardar.add(boton_guardar);
            
            
            panelBotones.add(panelBotonGuardar);
            panelBotones.add(panelBoton);

            this.add(panelSuperior,BorderLayout.NORTH);
   //      this.setBorder(new TitledBorder(new TitledBorder(""), "Mostrar Departamento por ID", TitledBorder.CENTER, TitledBorder.TOP ));	

            this.add(panelTabla, BorderLayout.CENTER);
            this.add(panelBotones,BorderLayout.SOUTH);
            this.setVisible(true);
            
            boton_guardar.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 Departamento departamento = new Departamento();
                departamento.setIdDepartamento((int)tabla.getValueAt(0, 0));
                departamento.setNombre((String)(tabla.getValueAt(0, 1)));
                departamento.setDescripcion((String)(tabla.getValueAt(0, 2)));
                departamento.setDisponible((Boolean)tabla.getValueAt(0, 3));
                departamento.setVersion((int)tabla.getValueAt(0, 4));
                
                Controlador.getInstance().accion(EventoNegocio.MODIFICAR_DEPARTAMENTO, departamento);

             }
         });
            
             butID.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                     ArrayList<Object> datos = new ArrayList<>();
                    
                    
                    datos.add(Integer.parseInt(textID.getText()));

                    Controlador.getInstance().accion(EventoNegocio.MOSTRAR_DEPARTAMENTO_PARA_MODIFICAR, datos);
                    dispose();
                    
                   
                }
            });
        
        
        boton_salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               
            }
        });
        
 
    }
    
    public void cargarDepartamentoEnLista(Departamento departamento)
    {   
        DefaultTableModel dtm = new DefaultTableModel(0, 0){

            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 3){
                    return false;
                }
                return true;
                
            }
            
        };
        dtm.setColumnIdentifiers(NombreColumnas);
        
        tabla.setModel(dtm);
        dtm.addRow(new Object[]
        {departamento.getIdDepartamento(),departamento.getNombre(), departamento.getDescripcion(),departamento.getDisponible(),departamento.getVersion()});
        dtm.fireTableDataChanged();
    }
         
   
    
    //getters y setters

    public Object[][] getDatos_entrada() {
        return datos_entrada;
    }

    public void setDatos_entrada(Object[][] datos_entrada) {
        this.datos_entrada = datos_entrada;
    }

    public String[] getNombreColumnas() {
        return NombreColumnas;
    }

    public void setNombreColumnas(String[] NombreColumnas) {
        this.NombreColumnas = NombreColumnas;
    }

    public JTextField getTextID() {
        return textID;
    }

    public void setTextID(JTextField textID) {
        this.textID = textID;
    }

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }

    public void setPanelSuperior(JPanel panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    public JPanel getPanelTabla() {
        return panelTabla;
    }

    public void setPanelTabla(JPanel panelTabla) {
        this.panelTabla = panelTabla;
    }

    public JLabel getLabID() {
        return labID;
    }

    public void setLabID(JLabel labID) {
        this.labID = labID;
    }

    public JButton getButID() {
        return butID;
    }

    public void setButID(JButton butID) {
        this.butID = butID;
    }

    public JButton getBoton_salir() {
        return boton_salir;
    }

    public void setBoton_salir(JButton boton_salir) {
        this.boton_salir = boton_salir;
    }

    public JButton getBoton_guardar() {
        return boton_guardar;
    }

    public void setBoton_guardar(JButton boton_guardar) {
        this.boton_guardar = boton_guardar;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

         
    
}
