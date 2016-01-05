/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbrn1;

import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Konserwator
 */
public class DBEdit 
    {
    
    
    public DBEdit(/*DBobject zlecenie, DBConnect polaczenie*/)//konstruktor
        {
            JFrame oknoed = new JFrame();
            JPanel p1_oknogl = new JPanel();
            oknoed.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//okienko znika, ale czy to tak powinno dzialac? funkcja ma zamykac okno bez wprowadzania zmian i zamykania wlasciwego programu!
            oknoed.setSize(300, 600);
        
            
            
            
            
            oknoed.setVisible(true);
        }

    DBEdit(DBobject dBobject, DBConnect polacz) 
        {
        JFrame oknoed = new JFrame();
        JPanel p1_oknoed = new JPanel();
        oknoed.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//okienko znika, ale czy to tak powinno dzialac? funkcja ma zamykac okno bez wprowadzania zmian i zamykania wlasciwego programu!
        oknoed.setSize(300, 600);
        //dodac ramki i ustawic jakis layout
        p1_oknoed.setLayout(new BoxLayout(p1_oknoed, BoxLayout.Y_AXIS));
        p1_oknoed.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        
        System.out.println("obiekt o numerze: "+dBobject.getid());    
        
        
        //do każdego utworzyc JPANEL skladajacy sie z tekstu i pola
        JLabel t_skrs = new JLabel("Skrócenie skrzydła");
        JComboBox cbskrs = new JComboBox();
        //WYPEŁNIENIE WARTOŚCIAMI
        cbskrs.setSize(100, 20);
        JPanel p_skrs = new JPanel();
        p_skrs.add(t_skrs);
        p_skrs.add(cbskrs);
        
        
    /*01*/ int eid;         //Numer ID rekordu w bazie - unikalny, niezmienny
    
    
    /*02*/ String eb_nrzs;  //numer zlecenia
    
    
    /*03*/ Date eb_dpotw;   //data potwierdzenia
    
    
    /*04*/ Date eb_dreal;   //Data rozpoczęcia realizacji
    
    
    /*05*/ Date eb_dzak;    //   "Data zak.",
    
    
    /*06*/ int ec_skrs;     //  "Skrócenie",
    
    
    /*07*/ int ec_smth;     //"Pow. SMOOTH",
    
    
    /*08*/ int ec_fosc;     //"c_fosc",
    
    
    /*09*/ int ec_szlsk;    //"Szlif skrzydła?",
    
    
    /*10*/ int ec_wosc;     //"c_wosc",
    
    
    /*11*/ int ec_szlosc;   //"Szlif ościeżnicy",
    
    
    /*12*/ Date ec_dprz;    //"Data przekazania",
    
    
    /*13*/ int ec_wodb;     //"Potwierdzenie odbioru",
    
    
    /*14*/ int ed_witr;    // Czy jest witraż?
    
    
    /*15*/ Date ed_dwprz;   //"d_dwprz",                - CZEGO, GDZIE?
    
    
    /*16*/ int ed_wodb;    //"d_wodb",                 - CZEGO?
    
    
    /*17*/ int ew_laksk;    //"Lakierowanie skrzydła",
    
    
    /*18*/ int ew_lakosc;   //Lakierowanie ościeżnicy
    
    
    /*19*/ int ew_sch;      //Schnięcie,
    
    
    /*20*/ int ew_ospak;    //Osadzanie pakietu
    
    
    /*21*/ int ew_mont;     //Montaż                     - CZEGO?
    
    
    /*22*/ Date ew_dwprz;   //Data przyjęcia             - GDZIE?
    
    
    /*23*/ int ew_wodb;     //Potwierdzenie odbioru
        
        
        
        
        
        
        
        
        
        
        
        ///DATA - przyklad
        UtilDateModel model = new UtilDateModel();
        //model.setDate(20,04,2014);
        // Need this...
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        // Don't know about the formatter, but there it is...
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        //przejrzec, co tu sie dzieje!
 
        
        
        p1_oknoed.add(p_skrs);
        p1_oknoed.add(datePicker);
            
        //dodac przyciski: wyslij, anuluj, ewentualnie jeszcze przywroc wartosci poczatkowe; obok przyciskow moga byc przyciski z ? wyswietlajace pomoc
        oknoed.add(p1_oknoed);
        oknoed.setVisible(true);    
        }
    
    }
