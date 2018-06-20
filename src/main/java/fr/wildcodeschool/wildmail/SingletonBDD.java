package fr.wildcodeschool.wildmail;

import com.mysql.jdbc.Driver;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingletonBDD {
    /** Constructeur privé */
    private SingletonBDD()
    {
        initConnection();
    }

    /** Instance unique non préinitialisée */
    private static SingletonBDD INSTANCE = null;
    private Connection mConnection = null;

    /** Point d'accès pour l'instance unique du singleton */
    public static SingletonBDD getInstance()
    {
        if (INSTANCE == null)
        {   INSTANCE = new SingletonBDD();
        }
        return INSTANCE;
    }

    public Connection getConnection(){
        return mConnection;
    }

    private void initConnection(){
        Class driverClass = null;
        try {
            driverClass = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) driverClass.newInstance();
            DriverManager.registerDriver(driver);
            mConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wildmail", "root", "jecode4wcs");

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();

        }
    }

}
