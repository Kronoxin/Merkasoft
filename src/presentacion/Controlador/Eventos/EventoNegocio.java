/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Eventos;


public class EventoNegocio 
{
    //100 Control de cliente y su GUI
    public static final int ALTA_CLIENTE = 101;
    public static final int BAJA_CLIENTE = 102;
    public static final int MOSTRAR_CLIENTE = 103;
    public static final int MOSTRAR_LISTA_CLIENTES = 104;
    public static final int MODIFICAR_CLIENTE = 105;
    public static final int GUI_ALTA_CLIENTE = 106;
    public static final int GUI_BAJA_CLIENTE = 107;
    public static final int GUI_MOSTRAR_CLIENTE = 108;
    public static final int GUI_MOSTRAR_LISTA_CLIENTES = 109;
    public static final int GUI_MODIFICAR_CLIENTE = 110;
    public static final int GUI_MEDIA_CLIENTES = 111;
    //PUTO GIT
    
    
    
    //200 Control de productos y su GUI
    public static final int ALTA_PRODUCTO = 201;
    public static final int BAJA_PRODUCTO = 202;
    public static final int MOSTRAR_PRODUCTO = 203;
    public static final int MOSTRAR_LISTA_PRODUCTOS = 204;
    public static final int MODIFICAR_PRODUCTO = 205;
    public static final int GUI_ALTA_PRODUCTO = 206;
    public static final int GUI_BAJA_PRODUCTO = 207;
    public static final int GUI_MOSTRAR_PRODUCTO = 208;
    public static final int GUI_MOSTRAR_LISTA_PRODUCTOS = 209;
    public static final int GUI_MODIFICAR_PRODUCTO = 210;
    
    //300 control de ventas y su GUI
    public static final int ALTA_VENTA = 301;
    public static final int DEVOLUCION_PRODUCTO = 302;
    public static final int MOSTRAR_VENTA = 303;
    public static final int MOSTRAR_LISTA_VENTAS = 304;
    public static final int GUI_ALTA_VENTA = 305;
    public static final int GUI_DEVOLUCION_PRODUCTO = 306;
    public static final int GUI_MOSTRAR_VENTA = 307;
    public static final int GUI_MOSTRAR_LISTA_VENTAS = 308;
    
    //400 control de exito
    
    //Modulo CLIENTE
    public static final int EXITO_ALTA_CLIENTE=401;
    public static final int EXITO_BAJA_CLIENTE=402;
    public static final int EXITO_MODIFICAR_CLIENTE=403;
    public static final int EXITO_MOSTRAR_CLIENTE=411;
    public static final int EXITO_MOSTRAR_LISTA_CLIENTE=412;
    //Modulo PRODUCTOS
    public static final int EXITO_ALTA_PRODUCTO=404;
    public static final int EXITO_BAJA_PRODUCTO=405;
    public static final int EXITO_MODIFICAR_PRODUCTO=406;
    public static final int EXITO_MOSTRAR_PRODUCTO=409;
    public static final int EXITO_MOSTRAR_LISTA_PRODUCTO=410;
    
    
    //Modulo VENTAS
    public static final int EXITO_ALTA_VENTA=407;
    public static final int EXITO_MOSTRAR_VENTA=411;
    public static final int EXITO_MOSTRAR_LISTA_VENTA=412;
    public static final int EXITO_DEVOLUCION_PRODUCTO=408;
    
    //Modulo EMPLEADOS
    public static final int EXITO_ALTA_EMPLEADO = 471; 
    public static final int EXITO_BAJA_EMPLEADO = 472; 
    public static final int EXITO_MODIFICAR_EMPLEADO = 473; 
    public static final int EXITO_MOSTRAR_EMPLEADO = 474; 
    public static final int EXITO_MOSTRAR_LISTA_EMPLEADO = 475;
    public static final int EXITO_MOSTRAR_EMPLEADO_PARA_MODIFICAR = 476;
    
    //Modulo DEPARTAMENTOS
    public static final int EXITO_ALTA_DEPARTAMENTO = 481;
    public static final int EXITO_BAJA_DEPARTAMENTO = 482;
    public static final int EXITO_MODIFICAR_DEPARTAMENTO = 483;
    public static final int EXITO_MOSTRAR_DEPARTAMENTO = 484;
    public static final int EXITO_MOSTRAR_LISTA_DEPARTAMENTO = 485;
    public static final int EXITO_CALCULAR_NOMINA_DEPARTAMENTO = 486;
    public static final int EXITO_MOSTRAR_DEPARTAMENTO_PARA_MODIFICAR = 487;
    
    //Modulo TURNOS
    public static final int EXITO_ALTA_TURNO = 491;
    public static final int EXITO_BAJA_TURNO = 492;
    public static final int EXITO_MODIFICAR_TURNO = 493;
    public static final int EXITO_MOSTRAR_TURNO = 494;
    public static final int EXITO_MOSTRAR_LISTA_TURNO = 495;
    public static final int EXITO_MOSTRAR_TURNO_PARA_MODIFICAR = 496;
    

    
    
    //500 Control de fracaso
    //Modulo CLIENTE
    public static final int FRACASO_ALTA_CLIENTE=501;
    public static final int FRACASO_BAJA_CLIENTE=502;
    public static final int FRACASO_MODIFICAR_CLIENTE=503;
    public static final int FRACASO_MOSTRAR_CLIENTE=513;
    public static final int FRACASO_MOSTRAR_LISTA_CLIENTE=514;
    //Modulo PRODUCTOS
    public static final int FRACASO_ALTA_PRODUCTO=504;
    public static final int FRACASO_BAJA_PRODUCTO=505;
    public static final int FRACASO_MODIFICAR_PRODUCTO=506;
    public static final int FRACASO_DEVOLUCION_PRODUCTO=508;
    public static final int FRACASO_MOSTRAR_PRODUCTO=509;
    public static final int FRACASO_MOSTRAR_LISTA_PRODUCTO=510;
    //Modulo VENTAS
    public static final int FRACASO_ALTA_VENTA=507;
    public static final int FRACASO_MOSTRAR_VENTA=511;
    public static final int FRACASO_MOSTRAR_LISTA_VENTA=512;
    
    //Modulo EMPLEADOS
    public static final int FRACASO_ALTA_EMPLEADO = 771; 
    public static final int FRACASO_BAJA_EMPLEADO = 772; 
    public static final int FRACASO_MODIFICAR_EMPLEADO = 773; 
    public static final int FRACASO_MOSTRAR_EMPLEADO = 774; 
    public static final int FRACASO_MOSTRAR_LISTA_EMPLEADO = 775;
    public static final int FRACASO_MOSTRAR_EMPLEADO_PARA_MODIFICAR = 776;
    
    //Modulo DEPARTAMENTOS
    public static final int FRACASO_ALTA_DEPARTAMENTO = 781;
    public static final int FRACASO_BAJA_DEPARTAMENTO = 782;
    public static final int FRACASO_MODIFICAR_DEPARTAMENTO = 783;
    public static final int FRACASO_MOSTRAR_DEPARTAMENTO = 784;
    public static final int FRACASO_MOSTRAR_LISTA_DEPARTAMENTO = 785;
    public static final int FRACASO_CALCULAR_NOMINA_DEPARTAMENTO = 786;
    public static final int FRACASO_MOSTRAR_DEPARTAMENTO_PARA_MODIFICAR = 787;
    
    //Modulo TURNOS
    public static final int FRACASO_ALTA_TURNO = 791;
    public static final int FRACASO_BAJA_TURNO = 792;
    public static final int FRACASO_MODIFICAR_TURNO = 793;
    public static final int FRACASO_MOSTRAR_TURNO = 794;
    public static final int FRACASO_MOSTRAR_LISTA_TURNO = 795;
    public static final int FRACASO_MOSTRAR_TURNO_PARA_MODIFICAR = 796;
    
    //600 control de ventanas
    
    
    //700 Control de Empleados
    public static final int ALTA_EMPLEADO = 701; 
    public static final int BAJA_EMPLEADO = 702; 
    public static final int MODIFICAR_EMPLEADO = 703; 
    public static final int MOSTRAR_EMPLEADO = 704; 
    public static final int MOSTRAR_LISTA_EMPLEADO = 705; 
    public static final int MOSTRAR_EMPLEADO_PARA_MODIFICAR = 711;
 
    public static final int GUI_ALTA_EMPLEADO = 706;
    public static final int GUI_BAJA_EMPLEADO = 707;
    public static final int GUI_MODIFICAR_EMPLEADO = 708;
    public static final int GUI_MOSTRAR_EMPLEADO = 709;
    public static final int GUI_MOSTRAR_LISTA_EMPLEADOS = 710;
    
    //800 Control de Departamentos
    public static final int ALTA_DEPARTAMENTO = 801;
    public static final int BAJA_DEPARTAMENTO = 802;
    public static final int MODIFICAR_DEPARTAMENTO = 803;
    public static final int MOSTRAR_DEPARTAMENTO = 804;
    public static final int MOSTRAR_LISTA_DEPARTAMENTO = 805;
    public static final int CALCULAR_NOMINA_DEPARTAMENTO = 806;
    public static final int MOSTRAR_DEPARTAMENTO_PARA_MODIFICAR = 815;
    
    public static final int GUI_ALTA_DEPARTAMENTO = 807;
    public static final int GUI_BAJA_DEPARTAMENTO = 808;
    public static final int GUI_MODIFICAR_DEPARTAMENTO = 809;
    public static final int GUI_MOSTRAR_DEPARTAMENTO = 810;
    public static final int GUI_MOSTRAR_LISTA_DEPARTAMENTOS = 811;
    public static final int GUI_CALCULAR_NOMINA_DEPARTAMENTO = 812;
    public static final int GUI_MOSTRAR_EMPLEADO_PARA_MODIFICAR = 813;
    public static final int GUI_MOSTRAR_DEPARTAMENTO_PARA_MODIFICAR =814;


            
    //900 Control de Turnos
    public static final int ALTA_TURNO = 901;
    public static final int BAJA_TURNO = 902;
    public static final int MODIFICAR_TURNO = 903;
    public static final int MOSTRAR_TURNO = 904;
    public static final int MOSTRAR_LISTA_TURNO = 905;
    public static final int MOSTRAR_TURNO_PARA_MODIFICAR = 911;
    
    public static final int GUI_ALTA_TURNO = 906;
    public static final int GUI_BAJA_TURNO = 907;
    public static final int GUI_MODIFICAR_TURNO = 908;
    public static final int GUI_MOSTRAR_TURNO = 909;
    public static final int GUI_MOSTRAR_LISTA_TURNOS = 910;
    public static final int GUI_MOSTRAR_TURNO_PARA_MODIFICAR = 912;
    
    //1000 Control de Horarios
    
    public static final int ASIGNAR_TURNO_EMPLEADO = 1001;
    public static final int MOSTRAR_TURNOS_EMPLEADO = 1002;
    public static final int MOSTRAR_RELACION_TURNO_EMPLEADO = 1003;
    
    public static final int GUI_ASIGNAR_TURNO_EMPLEADO = 1010;
    public static final int GUI_MOSTRAR_TURNOS_EMPLEADO = 1011;
    public static final int GUI_MOSTRAR_RELACION_TURNO_EMPLEADO = 1012;
    
    public static final int EXITO_ASIGNAR_TURNO_EMPLEADO = 1020;
    public static final int EXITO_MOSTRAR_TURNOS_EMPLEADO = 1021;
    public static final int EXITO_MOSTRAR_RELACION_TURNO_EMPLEADO = 1022;
    
    public static final int FRACASO_ASIGNAR_TURNO_EMPLEADO = 1030;
    public static final int FRACASO_MOSTRAR_TURNOS_EMPLEADO = 1031;
    public static final int FRACASO_MOSTRAR_RELACION_TURNO_EMPLEADO = 1032;
            
    
}
