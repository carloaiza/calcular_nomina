/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calcular_nomina.controlador;

import com.calcular_nomina.excepciones.UsuarioExcepcion;
import com.calcular_nomina.modelo.Rol;
import com.calcular_nomina.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author carloaiza
 */
public class ControladorUsuario {
    private Rol[] roles;
    private List<Usuario> usuarios;

    public ControladorUsuario() {
        inicializarColecciones();        
    }
    
    private void inicializarColecciones()
    {
        roles = new Rol[2];
        roles[0]= new Rol((byte)1, "Administrador");
        roles[1]= new Rol((byte)2, "Consulta");
        
        
        usuarios = new ArrayList<>();//Polimorfismo
        /// Donde yo cargaria los usuarios de una base de datos
        // Un archivo de excel, un archivo plano o un SGBD
        // Mysql, Postgres, Oracle, SqlSErver, 
        // Mariadb, MOngo, Dynamo
        usuarios.add(new Usuario("carloaiza@umanizales.edu.co","123456",roles[0],
                "Carlos Loaiza"));
        usuarios.add(new Usuario("lucas@umanizales.edu.co","654321",roles[1],
        "Lucas López"));       
        
    }
    
//    
//    public boolean verificarUsuario(String correo, String contrasenia)
//    {
//        for(Usuario usu: usuarios)
//        {
//            if(usu.getCorreo().equals(correo) && 
//                    usu.getContrasenia().equals(contrasenia))
//            {
//                return true;
//            }
//        }
//        return false;
//        
//                                                                 
//    }
    
    
    public Usuario verificarUsuario(String correo, String contrasenia)
            throws UsuarioExcepcion
    {
        if(correo == null || correo.equals("") || contrasenia ==null
                || contrasenia.equals(""))
        {
            throw new UsuarioExcepcion("Debe diligenciar todos los datos");
        }
        if(!validarCorreo(correo))
        {
            throw new UsuarioExcepcion("En el campo usuario debe ingresar un"
                    + " correo válido");
        }
        if(contrasenia.length()<6)
        {
            throw new UsuarioExcepcion("La contraseña debe tener al menos"
                    + "6 caracteres");
        }
        
        for(Usuario usu: usuarios)
        {
            if(usu.getCorreo().equals(correo) && 
                    usu.getContrasenia().equals(contrasenia))
            {
                return usu;
            }
        }
        ///Significa que el usuario o la contraseña son erradas
        throw new UsuarioExcepcion("Los datos ingresados son errados");
    }
    
    private boolean validarCorreo(String email) {
        boolean espacios = true;

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher = pattern.matcher(email);

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == ' ') {
                espacios = false;
                break;
            }
        }

        return matcher.find() && espacios;
    }
    
}
