/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbrn1;


//wywoływać okno logowania z tej klasy!

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static sun.security.jgss.GSSUtil.login;

public class DBConnect2 
    {
    private String dbuser;
    private String dbpassword;
    private String dbhost;
    //private String dbtable;
    
    private ResultSet resultSet = null;

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    


    
    
    
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
    
    
    public void writeDataBase()
        {
        
        }
    //metody
    
        //konstruktory
    DBConnect2() 
        {    
        
        JFrame ramka = new JFrame();
        JTextField wLogin = new JTextField();
        JTextField wPassword = new JTextField();
	JPanel jp = new JPanel();
	JButton zalogujButton = new JButton("Zaloguj");
        JButton wyjdzButton = new JButton("Wyjdz");//wyjdz?
        JLabel llabel = new JLabel("Login");
        JLabel plabel = new JLabel("Haslo");
	//rezultatJL = new JLabel();
        
	ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ramka.setSize(300, 100);
        
	jp.setLayout(new GridLayout(1,2));
	jp.add(zalogujButton);
	jp.add(wyjdzButton);
	JPanel jp2 = new JPanel();
        JPanel lfield = new JPanel();
        JPanel pfield = new JPanel();
        
        lfield.setLayout(new GridLayout(1,2));
        lfield.add(llabel);
        lfield.add(wLogin);
        
        pfield.setLayout(new GridLayout(1,2));
        pfield.add(plabel);
        pfield.add(wPassword);
        
        
	jp2.setLayout(new GridLayout(3,1));
	// tworzymy pole na którym będzie wypisany tekst
	//rezultatJL.setSize(400,20);
	jp2.add(lfield);
        jp2.add(pfield);
	//jp2.add(rezultatJL);
	jp2.add(jp);
	ramka.add(jp2);
	ramka.setVisible(true);
        
	zalogujButton.addActionListener((ActionEvent e) -> {
            this.dbuser=wLogin.getText();
            this.dbpassword=wPassword.getText();
            this.dbhost="10.0.0.7";//skasowac lub zmienic, jak zadziala
            ramka.setVisible(false);
            });
	//wyjdzButton.addActionListener(this);
        } 
    DBConnect2(String USER, String PASS) 
        {
        this.dbuser=USER;
        this.dbpassword=PASS;
        this.dbhost = "localhost";
        }
    DBConnect2(String USER, String PASS, String DATABASE) 
        {
        this.dbuser=USER;
        this.dbpassword=PASS;
        this.dbhost =DATABASE;
        }
    //konstruktory
    
 
    }
