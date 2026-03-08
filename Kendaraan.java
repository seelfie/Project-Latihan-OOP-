public class Kendaraan {
    private String merk;
    private int kecepatan;
    private String warna;
    
    public Kendaraan () {

    }

    public Kendaraan (String merk, int kecepatan, String warna) {
        this.merk = merk;
        this.kecepatan = kecepatan;
        this.warna = warna;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
    public void setKecepatan (int kecepatan) {
        this.kecepatan = kecepatan;
    }
    public void setWarna (String warna) {
        this.warna = warna;
    }

    public String getMerk () {
        return merk;
    }
    public int getKecepatan () {
        return kecepatan;
    }
    public String getWarna () {
        return warna;
    }

    public void jalan() {
        System.out.println("Kendaraan sedang melaju.");
    }

    public static void main (String []args) throws Exception {
        Mobil mobil = new Mobil();
            mobil.setMerk("honda");
            mobil.setKecepatan(80);
            mobil.setWarna("putih");

            System.out.println("Sub-class Mobil");
            System.out.println("Merk: " + mobil.getMerk());
            System.out.println("Kecepatan: " + mobil.getKecepatan());
            System.out.println("Warna: " + mobil.getWarna());
            mobil.jalan();
            mobil.usingAC();

        Motor motor = new Motor();
            motor.setMerk("vario");
            motor.setKecepatan(60);
            motor.setWarna("hitam");

            System.out.println("");
            System.out.println("Sub-class Motor");
            System.out.println("Merk: " + motor.getMerk());
            System.out.println("Kecepatan: " + motor.getKecepatan());
            System.out.println("Warna: " + motor.getWarna()); 
            motor.jalan();
            motor.wheelie();
    }
}

class Mobil extends Kendaraan {
    public void usingAC () {
        System.out.println("AC sedang digunakan.");
    }
}

class Motor extends Kendaraan {
    public void wheelie () {
        System.out.println("Motor sedang wheelie!");
    }
}

