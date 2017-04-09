/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sliga;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fachri
 */
public class ProsesTunjangan extends GajiTambahan implements Proses{

    @Override
    public void masuk(String s) {
        Koneksi koneksi = new Koneksi();
        try{
            String query = "insert into tunjangan (golongan,tunjangan) values ('"+s+"','"+getTunjangan()+"')";
            koneksi.st.executeUpdate(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }

    @Override
    public void ubah(String s) {
        Koneksi koneksi = new Koneksi();
        try{
            String query = "update tunjangan set tunjangan='"+getTunjangan()+"' where golongan='"+s+"'";
            koneksi.st.executeUpdate(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }

    public void keluar(String s){
        ProsesPegawai p = new ProsesPegawai();
        Koneksi koneksi = new Koneksi();
        reset();
        p.keluar(s);
        try{
            String query = "select * from tunjangan where golongan='"+s+"'";
            koneksi.rs = koneksi.st.executeQuery(query);
            while (koneksi.rs.next()){
                setTunjangan(koneksi.rs.getDouble("tunjangan"));
            }
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }
    @Override
    public void hapus(String s) {
        Koneksi koneksi = new Koneksi();
        try{
            String query = "delete from tunjangan where golongan='"+s+"'";
            koneksi.st.executeUpdate(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }
    public DefaultTableModel gettabel(){
        Koneksi koneksi = new Koneksi();
        String[]judul={"golongan","tunjangan"};
        DefaultTableModel tabel = new DefaultTableModel(null,judul);
        koneksi.start();
        try{
            String query = "select * from tunjangan";
            koneksi.rs=koneksi.st.executeQuery(query);
            String data[]=new String[2];
            while(koneksi.rs.next()){
                data[0]=koneksi.rs.getString(1);
                data[1]=koneksi.rs.getString(2);
                tabel.addRow(data);
            }
        }
        catch(Exception e){};
        return tabel;
    }
    public void setAll(String t){
        setTunjangan(Double.parseDouble(t));
    }
}
