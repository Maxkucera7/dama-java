/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dama;

/**
 *
 * @author majky
 */
public class Skok {
    CustomJPanel skokando;
    int nepritelx;
    int nepritely;
    int skokx;
    int skoky;
    public Skok(CustomJPanel skokando,int nepritelx,int nepritely,int skokx,int skoky){
        this.skokando=skokando;
        this.nepritelx=nepritelx;
        this.nepritely=nepritely;
        this.skokx=skokx;
        this.skoky=skoky;
    }

    public CustomJPanel getSkokando() {
        return skokando;
    }

    public void setSkokando(CustomJPanel skokando) {
        this.skokando = skokando;
    }

    public int getNepritelx() {
        return nepritelx;
    }

    public void setNepritelx(int nepritelx) {
        this.nepritelx = nepritelx;
    }

    public int getNepritely() {
        return nepritely;
    }

    public void setNepritely(int nepritely) {
        this.nepritely = nepritely;
    }

    public int getSkokx() {
        return skokx;
    }

    public void setSkokx(int skokx) {
        this.skokx = skokx;
    }

    public int getSkoky() {
        return skoky;
    }

    public void setSkoky(int skoky) {
        this.skoky = skoky;
    }
    
}
