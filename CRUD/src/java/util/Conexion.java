/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author J Cardoza
 */
public class Conexion {
/**
 * 
 */
    private static String bd = "db_estudianteAAAAAAAAAAAAAAAAAAAAAAAAAA";
    private static String user = "root";
    private static String pass = "";
    private static String ruta = "jdbc:mysql://localhost:3307/" + bd;

    private Connection cnx;

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public void conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.cnx = DriverManager.getConnection(ruta, user, pass);
            if (this.cnx != null) {
                System.out.println("Conectado");
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void desconectar() throws Exception {
        try {
            if (this.cnx != null) {
                if (this.cnx.isClosed() != true) {
                    this.cnx.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
