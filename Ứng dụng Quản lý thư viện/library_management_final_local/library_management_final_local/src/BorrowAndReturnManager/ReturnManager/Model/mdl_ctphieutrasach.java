/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BorrowAndReturnManager.ReturnManager.Model;

/**
 *
 * @author Admin
 */
public class mdl_ctphieutrasach {
    private int MACTPHIEUTRASACH;
    private int MAPHIEUTRASACH;
    private int SONGAYTRATRE;
    private double TIENPHAT;

    public mdl_ctphieutrasach(int MCTPTS, int MPTS, int SNTT, double TP) {
        this.MACTPHIEUTRASACH = MCTPTS;
        this.MAPHIEUTRASACH = MPTS;
        this.SONGAYTRATRE = SNTT;
        this.TIENPHAT = TP;
    }
    
    public int getCTMAPHIEUTRASACH() {
        return MACTPHIEUTRASACH;
    }

    public void setMACTPHIEUTRASACH(int MACTPHIEUTRASACH) {
        this.MACTPHIEUTRASACH = MACTPHIEUTRASACH;
    }

    public int getSONGAYTRATRE() {
        return SONGAYTRATRE;
    }

    public void setSONGAYTRATRE(int SONGAYTRATRE) {
        this.SONGAYTRATRE = SONGAYTRATRE;
    }

    public double getTIENPHAT() {
        return TIENPHAT;
    }

    public void setTIENPHAT(int TIENPHAT) {
        this.TIENPHAT = TIENPHAT;
    }
    
    public int getMAPHIEUTRASACH(){
        return MAPHIEUTRASACH;
    }
    
    public void setMAPHIEUTRASACH(int MAPHIEUTRASACH){
        this.MAPHIEUTRASACH = MAPHIEUTRASACH;
    }
}
