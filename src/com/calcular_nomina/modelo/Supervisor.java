/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calcular_nomina.modelo;

import java.io.Serializable;

/**
 *
 * @author carloaiza
 */
public class Supervisor extends Empleado implements Serializable{

    public Supervisor(String cedula, String nombre, double salario, boolean licencia) {
        super(cedula, nombre, salario, licencia);
    }

    @Override
    public double calcularSalario(int horas, double valor) {
        //Horas suma horas trabajadas por los operarios
        //Valor su salario
        if(horas <100)
        {
            //BOnificación del 5;
            setSalario(getSalario() + getSalario()*0.05);
            return  getSalario();
        }
        else
        {
            setSalario(getSalario() + getSalario()*0.1);
            return  getSalario();
        }        
    }
    
    
    
}
