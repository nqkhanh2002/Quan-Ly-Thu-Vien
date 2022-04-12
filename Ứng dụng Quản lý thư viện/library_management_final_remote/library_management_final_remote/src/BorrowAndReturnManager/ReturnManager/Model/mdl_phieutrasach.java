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
public class mdl_phieutrasach {
    private int MAPHIEUTRASACH;
    private String NGAYTRA;
    private int MAPHIEUMUONSACH;
    private int TIENPHATKYNAY;
    private int TIENNOKYNAY;
    private int TONGNO;

    public mdl_phieutrasach(int MPTS, String NT, int MPMS, int TPKN, int TNKN, int TN) {
        this.MAPHIEUTRASACH = MPTS;
        this.NGAYTRA = NT;
        this.MAPHIEUMUONSACH = MPMS;
        this.TIENPHATKYNAY = TPKN;
        this.TIENNOKYNAY = TNKN;
        this.TONGNO = TN;
    }
    
    public int getMAPHIEUMUONSACH() {
        return MAPHIEUMUONSACH;
    }

    public void setMAPHIEUMUONSACH(int MAPHIEUMUONSACH) {
        this.MAPHIEUMUONSACH = MAPHIEUMUONSACH;
    }

    public String getNGAYTRA() {
        return NGAYTRA;
    }

    public void setNGAYMUON(String NGAYTRA) {
        this.NGAYTRA = NGAYTRA;
    }

    public int getMAPHIEUTRASACH() {
        return MAPHIEUTRASACH;
    }

    public void setMAPHIEUTRASACH(int MAPHIEUTRASACH) {
        this.MAPHIEUTRASACH = MAPHIEUTRASACH;
    }
    
    public double getTIENPHATKYNAY() {
        return TIENPHATKYNAY;
    }

    public void setTIENPHATKYNAY(int TIENPHATKYNAY) {
        this.TIENPHATKYNAY = TIENPHATKYNAY;
    }
    
    public double getTIENNOKYNAY() {
        return TIENNOKYNAY;
    }

    public void setTIENNOKYNAY(int TIENNOKYNAY) {
        this.TIENNOKYNAY = TIENNOKYNAY;
    }
    
    public double getTONGNO() {
        return TONGNO;
    }

    public void setTONGNO(int TONGNO) {
        this.TONGNO = TONGNO;
    }
}
