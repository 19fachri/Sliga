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
public class GajiTambahan extends Gaji{
    private double bonus;
    private double makan;
    private double tunjangan;
    private double pajak;
    private double kaspon;
    private double total;
    
    public void setBonus(double b){
        bonus=b;
    }
    public void setMakan(double m){
        makan=m;
    }
    public void setTunjangan(double t){
        tunjangan=t;
    }
    public void setPajak(double p){
        pajak=p;
    }
    public void setKaspon(double k){
        kaspon=k;
    }
    public double getBonus(){
        return bonus;
    }
    public double getMakan(){
        return makan;
    }
    public double getTunjangan(){
        return tunjangan;
    }
    public double getPajak(){
        return pajak;
    }
    public double getKaspon(){
        return kaspon;
    }
    public void reset(){
        setBonus(0);
        setMakan(0);
        setTunjangan(0);
        setPajak(0);
        kaspon=0;
        total=0;
    }
    @Override
    public double getTotal() {
        total=makan+tunjangan-pajak-kaspon;
        return total; //To change body of generated methods, choose Tools | Templates.
    }
}