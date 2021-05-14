/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calcular_nomina.controlador;

import com.calcular_nomina.modelo.Empleado;
import com.calcular_nomina.modelo.Operario;
import com.calcular_nomina.modelo.Supervisor;
import com.calcular_nomina.modelo.Vigilante;

/**
 *
 * @author carloaiza
 */
public class ControladorNomina {
    public static final int NUMERO_EMPLEADOS=5;
    public static final double VALOR_HORA_OPERARIO=13000;
    private Empleado[] empleados;
    private int contEmpleados=0;

    public ControladorNomina() {
        empleados= new Empleado[NUMERO_EMPLEADOS];
        ///
        //Leyera mis empleados de un archivo plano
        inicializarEmpleados();
    }
    
    private void inicializarEmpleados()
    {
        empleados[0]= new Vigilante("1111111","Ramón Roncancio",
                    1200000,false);
        contEmpleados++;
        
        empleados[1]= new Operario(12,"22222222","Pedro Pérez",false);
        contEmpleados++;
    }
    
    public String adicionarEmpleado(Empleado emp)
    {
        //Como hago yo para saber en que posición lo 
        // debo agregar
        if(contEmpleados<NUMERO_EMPLEADOS)
        {
            //LO puedo adicionar
            empleados[contEmpleados]=emp;
            contEmpleados++;
            return "Empleado adicionado";
        }
        else
        {
            return "No puede adicionar más empleados";
        }
        
    }
    
    public double calcularNomina()
    {
        ///Sumar los salarios empleados
        // Recorrer los empleados
        // calcular el salario 
        //  acumula siempre y cuando no tenga Licencia
        double sumaSalarios=0;
        /// Tengo el total de horas de los operarios
        int totalHorasOperario = this.sumarHorasTrabajadasOperarios();
        for(Empleado emp : this.empleados)
        {
            double salarioCalculado=0;
            if( emp instanceof Operario)
            {
                
                salarioCalculado= emp.calcularSalario(((Operario) emp).getHorasTrabajadas(),
                       VALOR_HORA_OPERARIO );
            }
            //Calculo del supervisor
            else if (emp instanceof Vigilante)
            {
                salarioCalculado = emp.getSalario();
            }
            else
            {
                /// Supervisor
                // Suman horas trabajadas de todos los operarios
                salarioCalculado = emp.calcularSalario(totalHorasOperario, 
                        emp.getSalario());
            }
            
            if(!emp.isLicencia())
            {
                sumaSalarios = sumaSalarios + salarioCalculado;
            }
        }
        return sumaSalarios;
    }
    
    public int sumarHorasTrabajadasOperarios()
    {
        int totalHorasOperarios=0;
        for(Empleado emp: this.empleados)
        {
            if( emp instanceof Operario)
            {
                totalHorasOperarios = totalHorasOperarios + 
                        ((Operario) emp).getHorasTrabajadas();
            }
        }
        return totalHorasOperarios;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }
    
    
    
}
