/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author artur
 */
public class DatabaseSQLite {

    private static DatabaseSQLite INSTANCE = null;

    private Connection connection = null;

    private DatabaseSQLite() {

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");

        } catch (Exception e) {
            System.err.println("Houve um problema ao criar o arquivo do banco!");
            e.printStackTrace();
        }

    }

    public static DatabaseSQLite getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new DatabaseSQLite();
        }

        return INSTANCE;

    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {

        try {
            this.connection.close();
        } catch (SQLException e) {
            System.err.println("Houve um erro ao fechar a conexão com banco!");
            e.printStackTrace();
        }
    }

}
