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
public class Operario extends Empleado implements Serializable{
    private int horasTrabajadas;

    public Operario(int horasTrabajadas, String cedula, 
            String nombre, boolean licencia) {
        super(cedula, nombre, licencia);
        this.horasTrabajadas = horasTrabajadas;
    }    
    

    @Override
    public double calcularSalario(int horas, double valor) {                
        //Codificaria lo especial del operario        
        return super.calcularSalario(horas, valor); //To change body of generated methods, choose Tools | Templates.
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    
    
    
    
    
}
