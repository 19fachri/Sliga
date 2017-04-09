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
public class ProsesGajiPokok extends GajiPokok implements Proses{

    @Override
    public void masuk(String s) {
        Koneksi koneksi = new Koneksi();
        try{
            String query = "insert into gajiPokok (jabatan,gajiP,keterangan) values ('"+getJabatan()+"','"+getTotal()+"','"+getKeterangan()+"')";
            koneksi.st.executeUpdate(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }

    @Override
    public void ubah(String s) {
        Koneksi koneksi = new Koneksi();
        try{
            String query = "update gajiPokok set gajiP='"+getTotal()+"',keterangan='"+getKeterangan()+"' where jabatan='"+s+"'";
            koneksi.st.executeUpdate(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }

    @Override
    public void keluar(String s) {
        Koneksi koneksi = new Koneksi();
        try{
            String query = "select * from gajiPokok where jabatan="+"\""+s+"\""+"";
            koneksi.rs = koneksi.st.executeQuery(query);
            while (koneksi.rs.next()){
                setJabatan(koneksi.rs.getString("jabatan"));
                setKeterangan(koneksi.rs.getString("keterangan"));
                setTotal(koneksi.rs.getDouble("gajiP"));
            }
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }

    @Override
    public void hapus(String s) {
        Koneksi koneksi = new Koneksi();
        try{
            String query = "delete from gajiPokok where jabatan='"+s+"'";
            koneksi.st.executeUpdate(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }
    public DefaultTableModel gettabel(){
        Koneksi koneksi = new Koneksi();
        String[]judul={"jabatan","gajiPokok","keterangan"};
        DefaultTableModel tabel = new DefaultTableModel(null,judul);
        koneksi.start();
        try{
            String query = "select * from gajiPokok";
            koneksi.rs=koneksi.st.executeQuery(query);
            String data[]=new String[3];
            while(koneksi.rs.next()){
                data[0]=koneksi.rs.getString(1);
                data[1]=koneksi.rs.getString(2);
                data[2]=koneksi.rs.getString(3);
                tabel.addRow(data);
            }
        }
        catch(Exception e){};
        return tabel;
    }
    public void setAll(String j,String t,String k){
        setJabatan(j);
        setTotal(Double.parseDouble(t));
        setKeterangan(k);
    }
}
