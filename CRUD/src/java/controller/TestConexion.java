/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.Conexion;

/**
 *
 * @author J Cardoza
 */
public class TestConexion {
    
    public static void main(String[] args) {
        try {
            Conexion c  = new Conexion();
            c.conectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
