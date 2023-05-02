package com.example.loginpage;

import java.util.ArrayList;

public class Urunler {
    private String urunIsmi,urunAciklamasi;
    private int urunResim;

    public Urunler(String urunIsmi, String urunAciklamasi, int urunResim) {
        this.urunIsmi = urunIsmi;
        this.urunAciklamasi = urunAciklamasi;
        this.urunResim = urunResim;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUrunAciklamasi() {
        return urunAciklamasi;
    }

    public void setUrunAciklamasi(String urunAciklamasi) {
        this.urunAciklamasi = urunAciklamasi;
    }

    public int getUrunResim() {
        return urunResim;
    }

    public void setUrunResim(int urunResim) {
        this.urunResim = urunResim;
    }

    public Urunler(){}

    static public ArrayList<Urunler> getData(){
        ArrayList<Urunler>urunlerList= new ArrayList<>();
        String[] urunler={"Monitor","AirPods","iPhone","Televizyon","Mouse","Klavye","Kasa","Mikrofon","Macbook","Playstation5"};
        String[] urunAciklamasi={"ASUS TUF ZX-11 MONITOR IPS PANEL 27' 280 HZ FIYAT 6600₺","AIRPODS PRO 2.NESIL Fiyat 5200₺","14 PRO DEEP PURPLE Fiyat 43000₺","SAMSUNG QLED TV 82' Fiyat 20000₺","LOGITECH SUPERLIGHT X 63 GRAM MOUSE Fiyat 2700₺","" +
                "Razer Deathadder X-Q46 BLACK SWITCH Fiyat 1200₺","I7 10.NESIL CPU, RTX 3060 GPU, 1 TB SSD Fiyat: 20000₺","STEELSERIES BROADCASTER MIKROFON Fiyat 2000₺","Pro 16'Ekran M2 ISLEMCI Fiyat 50000₺","CALL OF DUTY MW2-FIFA 2023-2 ADET DUALSHOCK Fiyat 170000₺"};
        int[] resimler={R.drawable.monitor,R.drawable.airpods,R.drawable.iphone14pro,
                R.drawable.televizyon,R.drawable.superlight,R.drawable.klavye,R.drawable.kasa,
                R.drawable.mikrofon,R.drawable.macbook,R.drawable.playstation5};
        for (int i = 0; i < urunler.length; i++){
            Urunler urun= new Urunler();
            urun.setUrunIsmi(urunler[i]);
            urun.setUrunAciklamasi(urunAciklamasi[i]);
            urun.setUrunResim(resimler[i]);
            urunlerList.add(urun);
        }
        return urunlerList;
    }
}
