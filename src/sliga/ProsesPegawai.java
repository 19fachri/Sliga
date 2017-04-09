/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sliga;
import interaceSliga.interfacePegawai;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fachri
 */
public class ProsesPegawai extends Pegawai implements Proses{
    Koneksi koneksi = new Koneksi();
    
    
    @Override
    public void masuk(String s) {
        koneksi.start();
        try{
            String query = "insert into pegawai (Nama,golongan,jabatan) values ('"+getNama()+"','"+getGolongan()+"','"+getJAbatan()+"')";
            koneksi.st.executeUpdate(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }

    @Override
    public void ubah(String s) {
        koneksi.start();
        try{
            String query = "update pegawai set Nama='"+getNama()+"',golongan='"+getGolongan()+"',jabatan='"+getJAbatan()+"' where nip="+s+"";
            koneksi.st.executeUpdate(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }

    @Override
    public void keluar(String s) {
        koneksi.start();
        try{
            String query = "select * from pegawai where nip="+s+"";
            koneksi.rs = koneksi.st.executeQuery(query);
            while (koneksi.rs.next()){
                setNama(koneksi.rs.getString("nama"));
                setNip(koneksi.rs.getString("nip"));
                setGolongan(koneksi.rs.getString("golongan"));
                setJabatan(koneksi.rs.getString("jabatan"));
            }
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }

    @Override
    public void hapus(String s) {
        koneksi.start();
        try{
            String query = "delete from pegawai where nip="+s+"";
            koneksi.st.executeUpdate(query);
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
    }
    public String login(String u){
        koneksi.start();
        String p = "sliga";
        try{
            String query = "select password from admin where username='"+u+"'";
            koneksi.st.executeUpdate(query);
            while (koneksi.rs.next()){
                p=koneksi.rs.getString("password");
            }
        }catch(Exception e){ System.out.println(e);}
        koneksi.stop();
        return p;
    }
    public DefaultTableModel gettabel(){
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
    public void setALL(String ni,String na, String j, String g){
        setNip(ni);
        setNama(na);
        setJabatan(j);
        setGolongan(g);
    }
}
