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
public class mdl_thedocgia {
    private int MADOCGIA;
    private String HOTEN;

    public mdl_thedocgia(int MDG, String HT) {
        this.MADOCGIA = MDG;
        this.HOTEN = HT;
    }
    
    public int getMADOCGIA() {
        return MADOCGIA;
    }

    public void setMADOCGIA(int MADOCGIA) {
        this.MADOCGIA = MADOCGIA;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }
}
