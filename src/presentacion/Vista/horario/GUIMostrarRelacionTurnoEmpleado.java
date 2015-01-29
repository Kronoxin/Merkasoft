/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.horario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import negocio.turnos.HorarioTrabajo;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


public class GUIMostrarRelacionTurnoEmpleado extends JFrame{
     Object[][] datos_entrada = {
        {"","","",""}
       };
        
        String[] NombreColumnas = {"ID Turno","Nombre Turno","ID Empleado", "Nombre Empleado"};

 
        JPanel panelSuperior = new JPanel(new GridLayout(2,2,5,5));
        JPanel panelTabla = new JPanel();

        JButton butID = new JButton("Mostrar Relaciones");
        JButton boton_salir = new JButton("Salir");
        
        JTable tabla;
    
    public GUIMostrarRelacionTurnoEmpleado(){
         this.setTitle("Mostrar Relación Turno-Empleado");
	setBounds(100, 100, 500, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
                
		
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
            JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,15));
            panelBoton.add(boton_salir);

            this.add(panelSuperior,BorderLayout.NORTH);
   //         this.setBorder(new TitledBorder(new TitledBorder(""), "Mostrar Departamento por ID", TitledBorder.CENTER, TitledBorder.TOP ));	

            this.add(panelTabla, BorderLayout.CENTER);
            this.add(panelBoton,BorderLayout.SOUTH);
            this.setVisible(true);
            
        butID.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Controlador.getInstance().accion(EventoNegocio.MOSTRAR_RELACION_TURNO_EMPLEADO, null);
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
    
    public void cargarRelacionEnLista(ArrayList<HorarioTrabajo> horarios)
    {
        DefaultTableModel dtm = new DefaultTableModel(0, 0){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(NombreColumnas);
        
        tabla.setModel(dtm);
        for (HorarioTrabajo ht : horarios)
        {
            dtm.addRow(new Object[] 
            {ht.getTurno().getIdTurno(),ht.getTurno().getNombre(), ht.getEmpleado().getIdEmpleado(), ht.getEmpleado().getNombre()});
            dtm.fireTableDataChanged();
        }
        
        
        
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

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }
    
}
