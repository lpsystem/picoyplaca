/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static java.time.Clock.system;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import sun.util.BuddhistCalendar;

/**
 *
 * @author Erika
 */
public class Metodos {

    Scanner objIngreso = new Scanner(System.in);
    Datos objDatos = new Datos();
    String placa="";
    Integer numeroPlaca=0;
    Character numeroPlaca1=0;
    int dia = 0;
    int hora = 0;
    int minuto=0;    
    

    public void LeerDatos() {
        System.out.println("Ingrese la placa");
        objDatos.setPlaca(objIngreso.nextLine());
        System.out.println("Ingrese la fecha: ejemplo 21/05/2016");
        objDatos.setFecha(objIngreso.nextLine());
        System.out.println("Ingrese la hora: ejemplo 06:00");
        objDatos.setHora(objIngreso.nextLine());
        // determina el ultimo caracter de la cadena
        placa=objDatos.getPlaca();
        numeroPlaca=objDatos.getPlaca().length()-1;
        numeroPlaca1=placa.charAt(numeroPlaca);
        /////////////
        String fecha = objDatos.getFecha().substring(0,2);//saco los 2 primeros digitos de la cadena de fecha
        dia = Integer.parseInt(fecha);//convierto la cadena en entero
        
        ////////////
        String horas= objDatos.getHora().substring(0,2);
        hora=Integer.parseInt(horas);
        String minutos= objDatos.getHora().substring(3,5);
        minuto=Integer.parseInt(minutos);
        
    }

    /*
    Desde el pasado 3 de julio en los días pares tienen ‘Pico y Placa’ 
    de 6 a.m. a 8:30 a.m. y de 3 p.m. a 7:30 p.m.,
    las placas terminadas en 
    0, 2, 4, 6 y 8, 
    y en los impares las placas 1, 3, 5, 7 y 9.
    */
    public String ProcesoPicoPlaca() {
       LeerDatos();
        
        
       
        String Respuesta="";
       
        if((dia%2==0)&&(((hora>=6)&&(hora<=8)||(hora>=15)&&(hora<=19))&&((minuto>=0)&&(minuto<=30)))&&(numeroPlaca1%2==0))
        {
            Respuesta="No puede estar en la carretera";
        }
        
        else
        {
            
             if((dia%2!=0)&&(((hora>=6)&&(hora<=8)||(hora>=15)&&(hora<=17))&&((minuto>=0)&&(minuto<=30)))&&(numeroPlaca%2!=0))
            {
                Respuesta="No puede estar en la carretera";
            }
            else
            {
                Respuesta="Si puede estar en la carretera";
            }
            
        }  
      
        return Respuesta;
    }
}
