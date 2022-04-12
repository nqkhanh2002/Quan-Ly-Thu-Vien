/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DebtNote;


public class FineList {
    
    private int id;
    private int idReader;
    private int tiendong;
    private int conlai;
    
    public FineList(int id, int idReader, int tiendong, int conlai) {
        this.id = id;
        this.idReader = idReader;
        this.tiendong = tiendong;
        this.conlai = conlai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReader() {
        return idReader;
    }

    public void setIdReader(int idReader) {
        this.idReader = idReader;
    }

    public int getTiendong() {
        return tiendong;
    }

    public void setTiendong(int tiendong) {
        this.tiendong = tiendong;
    }

    public int getConlai() {
        return conlai;
    }

    public void setConlai(int conlai) {
        this.conlai = conlai;
    }
   
    
    
}
