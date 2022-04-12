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
public class mdl_phieumuonsach {
     private int MAPHIEUMUONSACH;
    private String NGAYMUON;
    private int MADOCGIA;

    public mdl_phieumuonsach(int MPMS, String NM, int MDG) {
        this.MAPHIEUMUONSACH = MPMS;
        this.NGAYMUON = NM;
        this.MADOCGIA = MDG;
    }
    
    public int getMAPHIEUMUONSACH() {
        return MAPHIEUMUONSACH;
    }

    public void setMAPHIEUMUONSACH(int MAPHIEUMUONSACH) {
        this.MAPHIEUMUONSACH = MAPHIEUMUONSACH;
    }

    public String getNGAYMUON() {
        return NGAYMUON;
    }

    public void setNGAYMUON(String NGAYMUON) {
        this.NGAYMUON = NGAYMUON;
    }

    public int getMADOCGIA() {
        return MADOCGIA;
    }

    public void setMADOCGIA(int MADOCGIA) {
        this.MADOCGIA = MADOCGIA;
    }
}
