/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BorrowAndReturnManager.BorrowManager.Model;

/**
 *
 * @author Admin
 */
public class mdl_ctphieumuonsach {
     private int MACTPHIEUMUONSACH;
    private int MAPHIEUMUONSACH;
    private int MASACH;

    public mdl_ctphieumuonsach(int MCTPMS, int MPMS, int MS) {
        this.MACTPHIEUMUONSACH = MCTPMS;
        this.MAPHIEUMUONSACH = MPMS;
        this.MASACH = MS;
    }
    
    public int getCTMAPHIEUMUONSACH() {
        return MACTPHIEUMUONSACH;
    }

    public void setMACTPHIEUMUONSACH(int MACTPHIEUMUONSACH) {
        this.MACTPHIEUMUONSACH = MACTPHIEUMUONSACH;
    }

    public int getMAPHIEUMUONSACH() {
        return MAPHIEUMUONSACH;
    }

    public void setMAPHIEUMUONSACH(int MAPHIEUMUONSACH) {
        this.MAPHIEUMUONSACH = MAPHIEUMUONSACH;
    }

    public int getMASACH() {
        return MASACH;
    }

    public void setMASACH(int MASACH) {
        this.MASACH = MASACH;
    }
}
