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
public class mdl_phieumuonsach {
    private int MAPHIEUMUONSACH;
    private String HOTEN;
    
    public mdl_phieumuonsach(int MAPHIEUMUONSACH,String HOTEN) {
        this.MAPHIEUMUONSACH = MAPHIEUMUONSACH;
        this.HOTEN = HOTEN;
    }
    
    public int getMAPHIEUMUONSACH() {
        return MAPHIEUMUONSACH;
    }
    
    public String getHOTEN() {
        return HOTEN;
    }
}
