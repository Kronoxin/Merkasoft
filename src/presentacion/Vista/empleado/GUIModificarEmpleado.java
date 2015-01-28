/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.empleado;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import negocio.FactoriaSA.FactoriaSA;
import negocio.departamentos.Departamento;
import negocio.empleados.Empleado;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;
import presentacion.Vista.ControlErrores;


public class GUIModificarEmpleado extends JFrame{
  
    Object[][] datos_entrada = {
        {"","", "", "", "", "","","","",""}
       };
        
        String[] NombreColumnas = {"ID","DNI","Nombre", "Apellidos", "Direccion", "Tipo", "Departamento", "Sueldo","Disponible","Version"};

        JTextField textID = new JTextField("");

        JPanel panelSuperior = new JPanel(new GridLayout(2,2,5,5));
        JPanel panelTabla = new JPanel();

        JLabel labID = new JLabel("ID del Empleado",JLabel.CENTER);
        JButton butID = new JButton("Buscar por ID");
        JButton boton_salir = new JButton("Salir");
        JButton boton_guardar = new JButton("Guardar");
        JComboBox comboBox;
        JCheckBox check;
        
        JTable tabla;
    
    public GUIModificarEmpleado(){
        final ControlErrores control=new ControlErrores();
        this.setTitle("Modificar Empleado");
	setBounds(100, 100, 820, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
                
		
            panelSuperior.add(labID);
            panelSuperior.add(textID);
            panelSuperior.add(butID);

            //se crea la Tabla
            tabla = new JTable(datos_entrada, NombreColumnas);
            //cojo la primera columna de la tabla (el DNI) y fijo el tamaño de esa columna
            tabla.getColumnModel().getColumn(0).setPreferredWidth(3);


            //dimensiones del Jtable
            tabla.setPreferredScrollableViewportSize(new Dimension(800, 200));
            //Creamos un JscrollPane y le agregamos la JTable
            JScrollPane scrollPane = new JScrollPane(tabla);
            panelTabla.add(scrollPane,BorderLayout.CENTER);

            boton_salir.setPreferredSize(new Dimension(90,40));
            boton_guardar.setPreferredSize(new Dimension(90, 40));
            JPanel panelBotones = new JPanel();
            JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,15));
            JPanel panelBotonGuardar = new JPanel(new FlowLayout(FlowLayout.LEFT,15,15));
            
            boton_guardar.setForeground(Color.BLUE);
            boton_salir.setForeground(Color.red);
            
           
            panelBoton.add(boton_salir);
            panelBotonGuardar.add(boton_guardar);
            
            
            panelBotones.add(panelBotonGuardar);
            panelBotones.add(panelBoton);

            this.add(panelSuperior,BorderLayout.NORTH);
   //         this.setBorder(new TitledBorder(new TitledBorder(""), "Mostrar Empleado por ID", TitledBorder.CENTER, TitledBorder.TOP ));	

            this.add(panelTabla, BorderLayout.CENTER);
            this.add(panelBotones,BorderLayout.SOUTH);
            this.setVisible(true);
            
            boton_guardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Departamento> depts2 = FactoriaSA.obtenerInstancia().generaSADepartamento().mostrarListaDepartamentos();
                
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado((int)tabla.getValueAt(0, 0));
                empleado.setDni((String)(tabla.getValueAt(0, 1)));
                empleado.setNombre((String)(tabla.getValueAt(0, 2)));
                empleado.setApellidos((String)(tabla.getValueAt(0, 3)));
                empleado.setDireccion((String)tabla.getValueAt(0, 4));
                empleado.setTipo((String)tabla.getValueAt(0, 5));
                
                Departamento dep_selec = depts2.get(comboBox.getSelectedIndex());
                empleado.setDepartamento(dep_selec);
                empleado.setSueldo((double)tabla.getValueAt(0, 7));
                empleado.setDisponible((Boolean)tabla.getValueAt(0, 8));
                empleado.setVersion((int)tabla.getValueAt(0,9));
                
                Controlador.getInstance().accion(EventoNegocio.MODIFICAR_EMPLEADO, empleado);
                
                
            }
        });
            
             butID.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Object> datos = new ArrayList<>();
                    
                    if(control.controlErroresID(textID.getText()))
                    {
                        datos.add(Integer.parseInt(textID.getText()));
                        Controlador.getInstance().accion(EventoNegocio.MOSTRAR_EMPLEADO_PARA_MODIFICAR, datos);
                        dispose();
                    }
                    else
                    {
                        System.out.println("Formato erroneo o falta de datos");
                        Controlador.getInstance().accion(EventoNegocio.MOSTRAR_INFORMACION_ERROR, null);
                    }
                }
            });
        
        
        boton_salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               
            }
        });
        
 
    }
    public Class getColumnClass(int columna)
   {
      if (columna == 8) return Boolean.class;
      return Object.class;
   }
    
    public void cargarEmpleadoEnLista(Empleado empleado)
    {
        DefaultTableModel dtm = new DefaultTableModel(0, 0){

            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==8 || column==0 || column==9){
                    return false;
                }
                return true;
                    
            }
            
        };
       
        dtm.setColumnIdentifiers(NombreColumnas);
        
        ArrayList<Departamento> depts = FactoriaSA.obtenerInstancia().generaSADepartamento().mostrarListaDepartamentos();
            String[] departments = new String[depts.size()];
            for (int i = 0; i < depts.size(); i++)
            {
                departments[i] = depts.get(i).getNombre();
            }
        
        tabla.setModel(dtm);
        comboBox = new JComboBox(departments);
        check = new JCheckBox();
        
        tabla.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBox));
        tabla.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(check));
        
        //que la columna ID tenga un tamaño de 3
        tabla.getColumnModel().getColumn(0).setPreferredWidth(3);
 
        dtm.addRow(new Object[]
        {empleado.getIdEmpleado(),empleado.getDni(), empleado.getNombre(), empleado.getApellidos(), empleado.getDireccion(),empleado.getTipo(), empleado.getDepartamento().getNombre(),empleado.getSueldo(),empleado.getDisponible(), empleado.getVersion() });
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
