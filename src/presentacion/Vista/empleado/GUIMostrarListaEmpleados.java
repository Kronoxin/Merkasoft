/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.empleado;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.empleados.Empleado;
import negocio.producto.TProducto;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;
import presentacion.Vista.producto.GUIMostrarListaProductos;


public class GUIMostrarListaEmpleados extends JFrame{
    
   Object[][] datos_entrada = {
        {"","", "", "", "", "","","",""}
       };
        
        String[] NombreColumnas = {"ID","DNI","Nombre", "Apellidos", "Direccion", "Tipo", "Departamento", "Sueldo","Disponible"};

        JPanel panelSuperior = new JPanel(new GridLayout(2,2,5,5));
        JPanel panelTabla = new JPanel();

        JButton butID = new JButton("Buscar");
        JButton boton_salir = new JButton("Salir");
        
        JTable tabla;
    
    public GUIMostrarListaEmpleados(){
        this.setTitle("Mostrar Lista Empleados");
	setBounds(100, 100, 750, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
                
		
            panelSuperior.add(butID);

            //se crea la Tabla
            tabla = new JTable(datos_entrada, NombreColumnas);
            //cojo la primera columna de la tabla (el DNI) y fijo el tamaño de esa columna
            tabla.getColumnModel().getColumn(0).setPreferredWidth(8);
            //y el campo Sueldo tb
            tabla.getColumnModel().getColumn(6).setPreferredWidth(5);

            //dimensiones del Jtable
            tabla.setPreferredScrollableViewportSize(new Dimension(700, 150));
            //Creamos un JscrollPane y le agregamos la JTable
            JScrollPane scrollPane = new JScrollPane(tabla);
            panelTabla.add(scrollPane,BorderLayout.CENTER);

            boton_salir.setPreferredSize(new Dimension(90,40));
            JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,15));
            panelBoton.add(boton_salir);

            this.add(panelSuperior,BorderLayout.NORTH);
   //         this.setBorder(new TitledBorder(new TitledBorder(""), "Mostrar Empleado por ID", TitledBorder.CENTER, TitledBorder.TOP ));	

            this.add(panelTabla, BorderLayout.CENTER);
            this.add(panelBoton,BorderLayout.SOUTH);
            this.setVisible(true);
            
             butID.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                     ArrayList<Object> datos = new ArrayList<>();

                    Controlador.getInstance().accion(EventoNegocio.MOSTRAR_LISTA_EMPLEADO, datos);
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
    
     public void cargarEmpleadoEnLista(ArrayList<Empleado> listaEmpleado)
    {
        DefaultTableModel dtm = new DefaultTableModel(0, 0){

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(NombreColumnas);
        
        tabla.setModel(dtm);
        for (Empleado empleado : listaEmpleado)
            dtm.addRow(new Object[] {empleado.getIdEmpleado(),empleado.getDni(), empleado.getNombre(), empleado.getApellidos(), empleado.getDireccion(),empleado.getTipo(), empleado.getDepartamento().getNombre(),empleado.getSueldo(),empleado.getDisponible()});
        
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
