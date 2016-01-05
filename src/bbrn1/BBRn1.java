/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbrn1;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Operator
 */
public class BBRn1 {
    //Barbarian 1.0 (v0.1)
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    static ResultSet daneSQL = null;
    
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws Exception {
        
        JFrame oknogl = new JFrame();
        JPanel p1_oknogl = new JPanel();
        oknogl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oknogl.setSize(800, 600);
        
        p1_oknogl.setLayout(new BoxLayout(p1_oknogl, BoxLayout.Y_AXIS));
        p1_oknogl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //p1_oknogl.s
        
        
        
        
        

        // TODO code application logic here
        /*
        Login user = new Login();
        user.zbudujGUI();
        if(user.zalogowano()==1)
            {
            String login = user.getLogin();
            String password = user.getPassword();
            MySQLAccess polacz;
            polacz = new MySQLAccess(login,password,"10.0.0.7");
            polacz.readDataBase2("db_vik1", "zlec");
            }
        */
        //Login user = new Login();
        //user.zbudujGUI();
        DBConnect polacz=new DBConnect(null,null,"10.0.0.7");
        
        /*
        while(polacz.getusername()==null)
            {
            Login zaloguj = new Login();
            zaloguj.zbudujGUI();
            System.out.println("pusto!");
            }
        */

        polacz.setusername("V_LO");
        polacz.setuserpassword("12345678");
        
        
        String[] nkolumn = {
            /*01 ID*/       "id",
            /*02 b_nrzs*/   "Nr. zlec.",
            /*03 b_dpotw*/  "Data potw.",
            /*04 b_dreal*/  "Data real.", 
            /*05 b_dzak*/   "Data zak.",
            /*06 c_skrs*/   "Skrócenie",
            /*07 c_smth*/   "Pow. SMOOTH",
            /*08 c_fosc*/   "c_fosc",
            /*09 c_szlsk*/  "c_szlsk",
            /*10 c_wosc*/   "c_wosc",
            /*11 c_szlosc*/ "c_szlosc",
            /*12 c_dprz*/   "Data przekazania",
            /*13 c_wodb*/   "Potwierdzenie odbioru",
            /*14 d_witr*/   "d_witr",
            /*15 d_dwprz*/  "d_dwprz",
            /*16 d_wodb*/   "d_wodb",
            /*17 w_laksk*/  "w_laksk",
            /*18 w_lakosc*/ "w_lakosc",
            /*19 w_sch*/    "w_sch",
            /*20 w_ospak*/  "w_ospak",
            /*21 w_mont*/   "w_mont",
            /*22 w_dwprz*/  "w_dwprz",
            /*23 w_wodb*/   "w_wodb"
        };
        
        JTable wyniki = new JTable(polacz.readDataBase2("db_vik1", "zlec"));
        JScrollPane wynikiscroll = new JScrollPane(wyniki);
        p1_oknogl.add(wynikiscroll);
        
        //przyciski - zerzniete z poradnika oracle
        JPanel buttonPane = new JPanel();
        
        //PRZYCISK DODANIA
        JButton addButton = new JButton("Dodaj");
        addButton.setMaximumSize(new Dimension(150, 50));
        
        
        
        
        
        //PRZYCISK EDYCJI
        JButton editButton = new JButton("Edytuj");
        editButton.setMaximumSize(new Dimension(150, 50));
        editButton.addActionListener((ActionEvent e) -> {
            if(wyniki.getSelectedRow()>=0)
                {
                try {
                    //wywolanie okna edycji
                    
                    System.out.println("Wybrany ID: "+wyniki.getSelectedRow());
                    //DBEdit edytowany = new DBEdit();
                    
                    DBEdit edytowany2 = new DBEdit(new DBobject((wyniki.getSelectedRow()+1), wyniki),polacz);
                    
                    
                    //ResultSet wyniki2=null;
                    //wyniki2= polacz.readSelectedRow("db_vik1", "zlec", wyniki.getSelectedRow());
                    //System.out.println("Wartosci dla id "+wyniki.getSelectedRow()+" wynosza: "+wyniki2.getString(2));
                } catch (Exception ex) {
                    Logger.getLogger(BBRn1.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                }
            else
                {
                //wyswietlenie komunikatu o koniecznoscy wybrania wiersza
                System.out.println("Wybierz pozycje do edycji");
                JOptionPane.showMessageDialog(buttonPane, "Wybierz pozycje do edycji");
                }
            });
        //PRZYCISK EDYCJI
        
        
        //PRZYCISK ODSWIEZ - pobiera ponownie dane z tabeli!
        JButton refrButton = new JButton("Odśwież");
        refrButton.setMaximumSize(new Dimension(150, 50));
        refrButton.addActionListener((ActionEvent e)->{
            wyniki.clearSelection();
            //FUNKCJa ODSWIEZAJACA DANE W TABELI
            
        });
        //PRZYCISK ODSWIEZ - pobiera ponownie dane z tabeli!
        
        
        //PRZYCISK ZAMKNIJ
        JButton closeButton = new JButton("Zamknij");
        closeButton.setMaximumSize(new Dimension(150, 50));//zablokowanie rozmiaru przyciskow
        closeButton.addActionListener(e -> System.exit(0));
        //PRZYCISK ZAMKNIJ
        
        
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(addButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));//dystans miedzy przyciskami o okreslony wymiar
        buttonPane.add(editButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));//dystans miedzy przyciskami o okreslony wymiar
        buttonPane.add(refrButton);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));//dystans miedzy przyciskami o okreslony wymiar
        buttonPane.add(closeButton);

        p1_oknogl.add(buttonPane);
        
        
        oknogl.add(p1_oknogl);
        oknogl.setVisible(true);
        
        //dodac sortowanie i mozliwosc wyswietlenia zakonczonych
        /*
        System.out.println("The columns in the table are: ");
        System.out.println("Table: " + daneSQL.getMetaData().getTableName(1));
        for  (int i = 1; i<= daneSQL.getMetaData().getColumnCount(); i++)
            {
            System.out.println("Column " +i  + " "+ daneSQL.getMetaData().getColumnName(i));
            }            
          */  
        
        //resultset to swoista jednokierunkowa tablica wskaznikowa
        //dane wyswietlic w jtable
        //przycisk umozliwiajacy edycje

        //polacz.readDataBase();
        //dodac mozliwosc logowania w trybie wsadowym, czyli uruchamiajac program z loginem i haslem
        
        }
    }

