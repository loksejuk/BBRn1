/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbrn1;

import java.sql.Date;
import javax.swing.JTable;

/**
 *
 * @author Konserwator
 */

public class DBobject 
    {
    /*01*/ int id;         //Numer ID rekordu w bazie - unikalny, niezmienny
    /*02*/ String b_nrzs;  //numer zlecenia
    /*03*/ Date b_dpotw;   //data potwierdzenia
    /*04*/ Date b_dreal;   //Data rozpoczęcia realizacji
    /*05*/ Date b_dzak;    //   "Data zak.",
    /*06*/ int c_skrs;     //  "Skrócenie",
    /*07*/ int c_smth;     //"Pow. SMOOTH",
    /*08*/ int c_fosc;     //"c_fosc",
    /*09*/ int c_szlsk;    //"Szlif skrzydła?",
    /*10*/ int c_wosc;     //"c_wosc",
    /*11*/ int c_szlosc;   //"Szlif ościeżnicy",
    /*12*/ Date c_dprz;    //"Data przekazania",
    /*13*/ int c_wodb;     //"Potwierdzenie odbioru",
    /*14*/ int d_witr;    // Czy jest witraż?
    /*15*/ Date d_dwprz;   //"d_dwprz",                - CZEGO, GDZIE?
    /*16*/ int d_wodb;    //"d_wodb",                 - CZEGO?
    /*17*/ int w_laksk;    //"Lakierowanie skrzydła",
    /*18*/ int w_lakosc;   //Lakierowanie ościeżnicy
    /*19*/ int w_sch;      //Schnięcie,
    /*20*/ int w_ospak;    //Osadzanie pakietu
    /*21*/ int w_mont;     //Montaż                     - CZEGO?
    /*22*/ Date w_dwprz;   //Data przyjęcia             - GDZIE?
    /*23*/ int w_wodb;     //Potwierdzenie odbioru
    
    //METODY
    public int getid()
        {
        return id;
        }
    /**
    * Ustawia numer ZS - zlecenia sprzedazy
    * 
    */
    public void setnrzs(String nrzs)
        {

        b_nrzs=nrzs;
        }
    /**
    * Zwraca numer ZS - zlecenia sprzedazy
    */
    public String getnrzs()
        {
        return b_nrzs;
        }
    
    /**
     * Ustawia date potwierdzenia zlecenia
     * @param dpotw 
     */
    public void setdpotw(Date dpotw)
        {
        b_dpotw=dpotw;
        }
    public Date getdpotw()
        {
        return b_dpotw;
        }
    
    public void setdreal(Date dreal)
        {
        b_dreal=dreal;
        }
    public Date getdreal()
        {
        return b_dreal;
        }
    
    public void setdzak(Date dzak)
        {
        b_dzak=dzak;
        }
    public Date getdzak()
        {
        return b_dzak;
        }
    
    public void setskrs(int skrs)
        {
        c_skrs=skrs;
        }
    public int getskrs()
        {
        return c_skrs;
        }
    
    public void setsmth(int smth)
        {
        c_smth=smth;
        }
    public int getsmth()
        {   
        return c_smth;
        }
    
    public void setfosc(int fosc)
        {
        c_fosc = fosc;
        }
    public int getfosc()
        {
        return c_fosc;
        }
    
    public void setszlsk(int szlsk)
        {
        c_szlsk = szlsk;
        }
    public int getszlsk()
        {
        return c_szlsk;
        }
    
    public void setwosc(int wosc)
        {
        c_wosc = wosc;
        }
    public int getwosc()
        {
        return c_wosc;
        }
    
    public void setszlosc(int szlosc)
        {
        c_szlosc = szlosc;
        }
    public int getszlosc()
        {
        return c_szlosc;
        }
    
    public void setc_dprz(Date dprz)
        {
        c_dprz=dprz;
        }
    public Date getc_dprz()
        {
        return c_dprz;
        }
    
    public void setc_wodb(int wodb)
        {
        c_wodb = wodb;
        }
    public int getc_wodb()
        {
        return c_wodb;
        }
    public void setwitr(int witr)
        {
        d_witr = witr;
        
        if(witr == 0)
            {
            d_dwprz=null;
            d_wodb=0;
            }
        }
    public int getwitr()
        {
        return d_witr;
        }
    
    public void setd_dprz(Date dprz)
        {
        d_dwprz=dprz;
        }
    public Date getd_dprz()
        {
        return d_dwprz;
        }
    
    public void setd_wodb(int wodb)
        {
        d_wodb = wodb;
        }
    public int getd_wodb()
        {
        return d_wodb;
        }
    
    public void setlaksk(int laksk)
        {
        w_laksk = laksk;
        }
    public int getlaksk()
        {
        return w_laksk;
        }
    
    public void setlakosc(int lakosc)
        {
        w_lakosc = lakosc;
        }
    public int getlakosc()
        {
        return w_lakosc;
        }
    
    public void setsch(int sch)
        {
        w_sch = sch;
        }
    public int getsch()
        {
        return w_sch;
        }

    public void setospak(int ospak)
        {
        w_ospak = ospak;
        }
    public int getospak()
        {
        return w_ospak;
        }
   
    public void setmont(int mont)
        {
        w_mont = mont;
        }
    public int getmont()
        {
        return w_mont;
        }
    
    public void setw_dprz(Date dprz)
        {
        w_dwprz=dprz;
        }
    public Date getw_dprz()
        {
        return w_dwprz;
        }
    
    public void setw_wodb(int wodb)
        {
        w_wodb = wodb;
        }
    public int getw_wodb()
        {
        return w_wodb;
        }
    
    
    /*
    Jak robi sie opis metody?
    */
    ////METODY
    
    //KONSTRUKTORY
    DBobject(int id, String nrzs)//konstruktor przy tworzeniu nowego obiektu
    //obiekt musi mieć przynajmniej id i numer ZS
    //informacja w miarę istotna - czy będzie miał witraż?
            
        {
        this.id=id;
        this.b_nrzs=nrzs;
        }//DBobject string
    
    
    DBobject (int id, JTable tabela)//wypełnienie tworzonego obiektu danymi z tabeli
        {
        this.id=id;
        //UZUPELNIC DANYMI Z TABELI
        
        
        //this.id = tabela.
        }//DBobject jtable
    ////KONSTRUKTORY
    }
