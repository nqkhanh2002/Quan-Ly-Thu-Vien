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
public class mdl_thongtinsach {
     private int MASACH;
    private String TENSACH;

    public mdl_thongtinsach(int MS, String TS) {
        this.MASACH = MS;
        this.TENSACH = TS;
    }
    
    public int getMASACH() {
        return MASACH;
    }

    public void setMASACH(int MASACH) {
        this.MASACH = MASACH;
    }

    public String getTENSACH() {
        return TENSACH;
    }

    public void setTENSACH(String TENSACH) {
        this.TENSACH = TENSACH;
    }
}
