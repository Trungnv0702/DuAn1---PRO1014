/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author admin
 */
public class Question {
   String Noidungcauhoi,Dapansai1,Dapansai2,Dapansai3,Dapandung;

    public Question(String Noidungcauhoi, String Dapansai1, String Dapansai2, String Dapansai3, String Dapandung) {
        this.Noidungcauhoi = Noidungcauhoi;
        this.Dapansai1 = Dapansai1;
        this.Dapansai2 = Dapansai2;
        this.Dapansai3 = Dapansai3;
        this.Dapandung = Dapandung;
    }

    public Question() {
    }

    public String getNoidungcauhoi() {
        return Noidungcauhoi;
    }

    public void setNoidungcauhoi(String Noidungcauhoi) {
        this.Noidungcauhoi = Noidungcauhoi;
    }

    public String getDapansai1() {
        return Dapansai1;
    }

    public void setDapansai1(String Dapansai1) {
        this.Dapansai1 = Dapansai1;
    }

    public String getDapansai2() {
        return Dapansai2;
    }

    public void setDapansai2(String Dapansai2) {
        this.Dapansai2 = Dapansai2;
    }

    public String getDapansai3() {
        return Dapansai3;
    }

    public void setDapansai3(String Dapansai3) {
        this.Dapansai3 = Dapansai3;
    }

    public String getDapandung() {
        return Dapandung;
    }

    public void setDapandung(String Dapandung) {
        this.Dapandung = Dapandung;
    }
    
}
