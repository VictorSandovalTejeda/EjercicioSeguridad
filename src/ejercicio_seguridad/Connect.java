/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_seguridad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.sqlite.SQLiteDataSource;

/**
 *
 * @author pc HP
 */
public class Connect {

    private DataSource ds;
    private Connection conn;

    public Connect() {
        ds = SQLDatasource.getSQLLiteDataSource();
        conn = null;
    }

    private Connection connectDB() {
        try {
            conn = this.ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    private void disconnectDB(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validateUser(String user) {

        conn = connectDB();
        String query = " Select UserEmail from  Users;";
        PreparedStatement consulta = null;
        ResultSet resultadotabla = null;

        try {
            consulta = conn.prepareStatement(query);
            resultadotabla = consulta.executeQuery();
            while (resultadotabla.next()) {
                if (user.equals(resultadotabla.getString(1))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (consulta != null) {
                    consulta.close();
                }
                if (conn != null) {
                    disconnectDB(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean validatePassword(String password, String user) {

        conn = connectDB();
        String query = " Select UserPassword from Users where UserEmail = ?;";
        PreparedStatement consulta = null;
        ResultSet resultadotabla = null;

        try {
            consulta = conn.prepareStatement(query);
            consulta.setString(1, user);
            resultadotabla = consulta.executeQuery();

            if (password.equals(resultadotabla.getString(1))) {
                return true;
            }

        } catch (SQLException e) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (consulta != null) {
                    consulta.close();
                }
                if (conn != null) {
                    disconnectDB(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public void insertarUsuario(String user, String password) {

        conn = connectDB();
        String query = "Insert into Users(UserEmail, UserPassword) Values(?, ?);";
        PreparedStatement consulta = null;

        try {
            consulta = conn.prepareStatement(query);
            consulta.setString(1, user);
            consulta.setString(2, password);

            boolean resultado = consulta.execute();

            if (resultado) {
                System.out.println(Console_Colors.ANSI_RED + "**Su Usuario no pudo ser registrado." + Console_Colors.ANSI_RESET);
            } else {
                System.out.println(Console_Colors.ANSI_GREEN + "Se ha registrado su Usuario exitosamente!" + Console_Colors.ANSI_RESET);
            }

        } catch (SQLException e) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (consulta != null) {
                    consulta.close();
                }
                if (conn != null) {
                    disconnectDB(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
