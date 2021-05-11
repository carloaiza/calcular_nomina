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
public class Vigilante extends Empleado implements Serializable{

    public Vigilante(String cedula, String nombre, double salario, boolean licencia) {
        super(cedula, nombre, salario, licencia);
    }
    
    
    
}
