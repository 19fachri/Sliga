/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sliga;

/**
 *
 * @author fachri
 */
public class GajiPokok extends Gaji{
    private String jabatan;
    private String keterangan;
    
    public void setTotal(double t) {
        total=t;
    }
    public void setJabatan(String j){
        jabatan=j;
    }
    public void setKeterangan(String k){
        keterangan=k;
    }
    @Override
    public double getTotal() {
        //To change body of generated methods, choose Tools | Templates.
        return total;
    }
    public String getJabatan(){
        return jabatan;
    }
    public String getKeterangan(){
        return keterangan;
    }
}