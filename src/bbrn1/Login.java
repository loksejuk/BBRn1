/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbrn1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Popup;

/**
 *
 * @author Operator
 */
public class Login implements ActionListener{
	JFrame ramka;
	JButton zalogujButton;
	JButton wyjdzButton;
        JTextField login;
        JTextField password;
        JLabel llabel;
        JLabel plabel;
        String host = "10.0.0.7";
        DBConnect polaczenie;
        Integer zalogowano=0;
        
        
	//JLabel rezultatJL;//czy to jest potrzebne?
 /*
	public static void main(String[] args) {
            //debug
		Login przyciski = new Login();//ok, tworzy obiekt, ale po co?
		przyciski.zbudujGUI();
            //debug
//pewnie, zeby zbudowac gui, w returnie pewnie trzeba by przekazac dane sesji
 
	}
 */
public void zbudujGUI() {
    
	ramka = new JFrame();
        login = new JTextField();
        password = new JTextField();
	JPanel jp = new JPanel();
	zalogujButton = new JButton();
	zalogujButton.setText("Zaloguj");//zaloguj?
	zalogujButton.addActionListener(this);
        wyjdzButton = new JButton("Wyjdz");//wyjdz?
	wyjdzButton.addActionListener(this);
        llabel = new JLabel("Login");
        plabel = new JLabel("Haslo");
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
        lfield.add(login);
        
        pfield.setLayout(new GridLayout(1,2));
        pfield.add(plabel);
        pfield.add(password);
        
        
	jp2.setLayout(new GridLayout(3,1));
	// tworzymy pole na którym będzie wypisany tekst
	//rezultatJL.setSize(400,20);
	jp2.add(lfield);
        jp2.add(pfield);
	//jp2.add(rezultatJL);
	jp2.add(jp);
	ramka.add(jp2);
	ramka.setVisible(true);
        
       
}
        public Integer zalogowano()
            {
            return zalogowano;
            }

        public String getLogin()
        {
            String SLogin = login.getText();
            return SLogin;
        }

        
        public String getPassword()
        {
            String SPassword = password.getText();
            return SPassword;
        }
        
        @Override
	public void actionPerformed(ActionEvent akcja) {
		if (akcja.getSource() == zalogujButton)
                        {
			// modyfikujemy komponent, zmieniając tekst
			//rezultatJL.setText(" Witaj "+textF.getText());
                         //polaczenie = new DBConnect(login.getText(), password.getText(), host);
                         //System.out.println(login.getText());
                         //System.out.println(password.getText());
                        zalogowano=1;
                        ramka.setVisible(false);
                        
                            /*
                            
                            try {
                                polaczenie.createConn();
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            //WTF?
                                */
                            /*
                            JFrame popup = new JFrame();
                            JPanel pop1 = new JPanel();
                            JButton okbutton = new JButton("OK");
                            okbutton.addActionListener(this);
                            popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            popup.setSize(100, 100);
                            pop1.setLayout(new GridLayout(3,1));
                            pop1.add(login);
                            pop1.add(password);
                            pop1.add(okbutton);
                            popup.add(pop1);
                            popup.setVisible(true);
                            */                              
                            
                            
                        }
                //wywal okno z komunikatem o zalogowaniu do bazy jakjejtambylo
		else if (akcja.getSource() == wyjdzButton)
                        {
			// modyfikujemy komponent, zmieniając tekst
                        System.exit(0);
			//rezultatJL.setText(" Żegnaj "+textF.getText());
                        }
                //zamknij okno
 
		else
			System.out.println("Skontaktowali się ze mną kosmici");
 
	}
}