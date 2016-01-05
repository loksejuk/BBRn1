/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbrn1;


//wywoływać okno logowania z tej klasy!

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class DBConnect 
    {
    private String dbuser;
    private String dbpassword;
    private String dbhost;
    //private String dbtable;
    
    private ResultSet resultSet = null;

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    
    
    

    //konstruktory
    DBConnect() 
        {    
        this.dbuser = "sqluser";
        this.dbpassword = "sqluserpw";
        this.dbhost = "localhost";
        } 
    DBConnect(String USER, String PASS) 
        {
        this.dbuser=USER;
        this.dbpassword=PASS;
        this.dbhost = "localhost";
        }
    DBConnect(String USER, String PASS, String DATABASE) 
        {
        this.dbuser=USER;
        this.dbpassword=PASS;
        this.dbhost =DATABASE;
        }
    //konstruktory
    
    
    
    //metody
    //dodac metode setusername
    //oraz setuserpassword
    
    public void setusername(String uname)
        {
        dbuser=uname;
        System.out.println("username changed");
        }
     public String getusername()
        {
        return dbuser;
        }
    
    
    public void setuserpassword(String upasswd)
        {
        dbpassword = upasswd;
        System.out.println("password changed");
        }
    
    public ResultSet readDataBase(String dbase, String dbtable) throws Exception
        {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Ustawienia polaczenia z baza
        connect = DriverManager.getConnection("jdbc:mysql://"+dbhost+"/feedback?"+"user="+dbuser+"&password="+dbpassword);
        statement = connect.createStatement();
        resultSet = statement.executeQuery("select * from "+dbase+"."+dbtable);
        return resultSet;
        //writeResultSet2(resultSet);//juz jest ok
        }
    
    public DefaultTableModel readDataBase2(String dbase, String dbtable) throws Exception
        {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Ustawienia polaczenia z baza
        connect = DriverManager.getConnection("jdbc:mysql://"+dbhost+"/feedback?"+"user="+dbuser+"&password="+dbpassword);
        statement = connect.createStatement();
        resultSet = statement.executeQuery("select * from "+dbase+"."+dbtable);
        
        
        ResultSetMetaData metaData = resultSet.getMetaData();
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) 
            {
            columnNames.add(metaData.getColumnName(column));
            }
        
        
        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (resultSet.next()) 
            {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) 
                {
                vector.add(resultSet.getObject(columnIndex));
                }
            data.add(vector);
            }
        //dla numerow kolumn wiekszych niz X podmieniac wartosci liczbowe na teksty!
        
        return new DefaultTableModel(data, columnNames);
        }
    
    
    
    public ResultSet readSelectedRow(String dbase, String dbtable, int row)throws Exception
        {
        Class.forName("com.mysql.jdbc.Driver");
        // Ustawienia polaczenia z baza
        connect = DriverManager.getConnection("jdbc:mysql://"+dbhost+"/feedback?"+"user="+dbuser+"&password="+dbpassword);
        statement = connect.createStatement();
        resultSet = statement.executeQuery("select * from "+dbase+"."+dbtable+" where id="+row); 
        return resultSet;
        }  
    
    
    }
