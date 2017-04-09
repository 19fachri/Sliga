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
public class ProsesHutang extends GajiTambahan implements Proses{

    @Override
    public void masuk(String s) {
        Koneksi koneksi = new Koneksi();
        try{
            String query = "insert into hutang (nip,kasbon) values ('"+s+"','"+getKaspon()+"')";
            koneksi.st.executeUpdate(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }

    @Override
    public void ubah(String s) {
        Koneksi koneksi = new Koneksi();
        try{
            String query = "update hutang set kasbon='"+getKaspon()+"' where nip='"+s+"'";koneksi.st.executeUpdate(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }

    public void keluar(String s){
        ProsesPegawai p = new ProsesPegawai();
        Koneksi koneksi = new Koneksi();
        reset();
        p.keluar(s);
        try{
            String query = "select * from hutang where nip="+s+"";
            koneksi.rs = koneksi.st.executeQuery(query);
            while (koneksi.rs.next()){
                setKaspon(koneksi.rs.getDouble("kasbon"));
            }
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }
    @Override
    public void hapus(String s) {
        Koneksi koneksi = new Koneksi();
        try{
            String query = "delete from hutang where nip='"+s+"'";
            koneksi.rs = koneksi.st.executeQuery(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }
    public DefaultTableModel gettabel(){
        Koneksi koneksi = new Koneksi();
        String[]judul={"NIP","NAMA","JABATAN","GOLONGAN"};
        DefaultTableModel tabel = new DefaultTableModel(null,judul);
        koneksi.start();
        try{
            String query = "select * from pegawai";
            koneksi.rs=koneksi.st.executeQuery(query);
            String data[]=new String[4];
            while(koneksi.rs.next()){
                data[0]=koneksi.rs.getString(1);
                data[1]=koneksi.rs.getString(2);
                data[2]=koneksi.rs.getString(3);
                data[3]=koneksi.rs.getString(4);
                tabel.addRow(data);
            }
        }
        catch(Exception e){};
        return tabel;
    }
    public void setAll(String h){
        setKaspon(Double.parseDouble(h));
    }
}
