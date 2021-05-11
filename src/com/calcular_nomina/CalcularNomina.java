/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calcular_nomina; //www.calularnomina.com

import com.calcular_nomina.controlador.ControladorNomina;
import com.calcular_nomina.modelo.Operario;
import com.calcular_nomina.modelo.Supervisor;
import com.calcular_nomina.modelo.Vigilante;


/**
 *
 * @author carloaiza
 */
public class CalcularNomina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Probar mi controlador;
        /*
        Carlos Loaiza -- Vigilante ---  1500000                         NO
        Juan Juárez   -- Operario  ---  		30               NO
        Pedro Pérez   -- Operario  ---  		45               NO
        Alvaro Alvarez-- Operario  ---  		30               NO
        Iván Duque     --Supervisor---  2500000                         NO
        
        */
        ControladorNomina control = new ControladorNomina();
        control.adicionarEmpleado(new Vigilante("7654321","Carlos Loaiza",1500000,false));
        control.adicionarEmpleado(new Operario(30,"3456789","Juan Juárez",true));
        control.adicionarEmpleado(new Operario(45,"9864646","Pedro Pérez",false));
        control.adicionarEmpleado(new Operario(30,"2232332","Alvaro Álvarez",false));
        control.adicionarEmpleado(new Supervisor("7655553","Carlos Arias",2500000,false));
        
        System.out.println("control = " + control.calcularNomina());
        
        
        
    }
    
}
