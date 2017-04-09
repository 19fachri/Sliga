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
public class Pegawai {
    private String nip;
    private String nama;
    private String golongan;
    private String jabatan;
    
    public void setNip(String n){
        nip=n;
    }
    public void setNama(String na){
        nama=na;
    }
    public void setGolongan(String g){
        golongan=g;
    }
    public void setJabatan(String j){
        jabatan=j;
    }
    public String getNip(){
        return nip;
    }
    public String getNama(){
        return nama;
    }
    public String getGolongan(){
        return golongan;
    }
    public String getJAbatan(){
        return jabatan;
    }
}