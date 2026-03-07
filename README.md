# Project-Latihan-OOP
- Nama: Silfi Rochmatul Auliyah 
- NRP: 5027251008

---
## 1. Enkapsulasi
Enkapsulasi merupakan proses pembungkusan variabel dan method menjadi satu unit tunggal (Class) yang juga bertujuan untuk menyembunyikan detail data dari pihak luar. Dengan konsep ini, isi dan cara kerja di dalam sebuah class tidak perlu diketahui oleh orang luar. 

Dalam project saya `Class Mahasiswa` memiliki atribut `nama` dan `nilai` yang menggunakan private, sehingga tidak bisa diakses langsung dari luar class. 
```java
    private String nama;
    private int nilai;
```

Lalu agar dapat membaca datanya harus lewat getter yaitu `getNama()` dan `getNilai()`, sedangkan untuk mengubahnya harus lewat setter yaitu `setNama()` dan `setNilai()`. Pada `setNilai()` terdapat validasi sehingga nilai tidak bisa diisi sembarangan di luar range 0-100.
- Setter
```java
    public void setNama (String nama) { 
        this.nama =  nama;
    }
    public void setNilai (int nilai) {
        if (nilai > 100 || nilai < 0) {
            System.out.println("Error! Nilai diluar jangkauan range (0-100).");
            return;
        } else {
        this.nilai = nilai;
        }
    }
```
- Getter
```java
    public String getNama() {
        return nama; 
    }
    public int getNilai() {
        return nilai;
    }
```

Berikut kode lengkap dari project latihan enkapsulasi.
```java
public class Mahasiswa {
    private String nama;
    private int nilai;
    
    public Mahasiswa (String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public void setNama (String nama) { 
        this.nama =  nama;
    }

    public void setNilai (int nilai) {
        if (nilai > 100 || nilai < 0) {
            System.out.println("Error. Please insert score in range 0-100.");
            return;
        } else {
        this.nilai = nilai;
        }
    }

    public String getNama () {
        return nama; 
    }
   
    public int getNilai () {
        return nilai;
    }

    public static void main (String[]args) throws Exception {
        Mahasiswa mhs1 = new Mahasiswa("Raelle", 85);
        System.out.println("Nama: " + mhs1.getNama());
        System.out.println("Nilai: " + mhs1.getNilai());

        mhs1.setNilai(105); //mengetes apakah setter setNilai berfungsi 
        System.out.println("Nilai: " + mhs1.getNilai());
        }
}
```


## 2. Inheritance 
Inheritance merupakan konsep yang memungkinkan suatu kelas untuk mewarisi properti dan perilaku dari kelas lain. Konsep ini membantu menciptakan kelas baru dari sebuah kelas yang sudah ada, mendorong penggunaan kembali kode, dan membantu mengorganisasi kode dengan lebih baik. 

Pada project latihan inheritance ini saya membuat `class Kendaraan` sebagai base class dan untuk subclassnya terdiri dari `class Mobil` dan `class Motor`. 

```java
public class Kendaraan {
    private String merk;
    private int kecepatan;
    private String warna;
    
    public Kendaraan() {}

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

    public String getMerk() {
        return merk;
    }
    public int getKecepatan() {
        return kecepatan;
    }
    public String getWarna() {
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
    public void usingAC() {
        System.out.println("AC sedang digunakan.");
    }
}

class Motor extends Kendaraan {
    public void wheelie() {
        System.out.println("Motor sedang wheelie!");
    }
}
```


## 3. Polymorphism 
Polymorphism merupakan suatu konsep yang memungkinkan sebuah method yang sama memiliki penerapan yang berbeda di setiap class turunannya. 

Pada latihan ini, class induk yaitu `class Shape` memiliki method `hitungLuas()` yang juga akan digunakan oleh subclass. Namun perhitungan di dalamnya dioverride tergantung rumus masing-masing subclass. Berikut kode lengkap project latihan saya terkait penerapan konsep polymorphism.
```java
public class Shape {
    public Shape() {

    }
    public double hitungLuas (double x) {
        return x * x;
    }

    public static void main (String []args) throws Exception {
        Circle circle = new Circle();
        System.out.println("area of circle: " + circle.hitungLuas(7));

        Square square = new Square();
        System.out.println("area of square: " + square.hitungLuas(6));
    }
}

class Circle extends Shape {
    double r;

    public double hitungLuas (double r) {
        return 3.14 * r * r;
    }
}

class Square extends Shape {
    double s;

    public double hitungLuas (double s) {
        return s * s;
    }
}
```

## 4. Abstraction 
Abstraction merupakan konsep di mana detail proses yang rumit disembunyikan dan hanya menampilkan fungsionalitas yang diperlukan. 

Dalam latihan, saya menerapkan konsep ini dengan membuat method `sajikan()` di `class Menu` sebagai template method yang harus diisi oleh `class Makanan` dan `class Minuman` sesuai jenisnya. `class Makanan` mengisi method tersebut dengan menampilkan nama dan porsi, sedangkan `class Minuman` menampilkan nama dan suhu minumannya.

```java
public class Menu {
    private String namaMenu;
    private int harga;
    private boolean ketersediaan = true;

    public Menu () {

    }

    public Menu (String namaMenu, int harga, boolean ketersediaan) {
        this.namaMenu = namaMenu;
        this.harga = harga;
        this.ketersediaan = ketersediaan;
    }
    public  void setKetersediaan(boolean ketersediaan) {
        this.ketersediaan = ketersediaan;
    }
    public void setNama (String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getNama() {
        return namaMenu;
    }
    public boolean getKetersediaan() {
        return ketersediaan;
    }
    public int getHarga() {
        return harga;
    }

    public void setHarga (int harga) {
        if (harga < 0) {
            System.out.println("Harga tidak valid!");
        } else {
            this.harga = harga;
        }
    }
    public void sajikan()  {

    }

    public void menuInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("Harga: Rp" + getHarga());
        System.out.println("Tersedia: " + (ketersediaan ? "Ya" : "Tidak"));
    }
    
    public static void main (String[]args) throws Exception {
        Makanan makanan = new Makanan("Nasi Goreng", 13000, true, "sedang");
        makanan.menuInfo();
        makanan.sajikan();
        makanan.tambahPorsi();

        Minuman minuman = new Minuman("Es Jeruk", 10000, true, "dingin");
        minuman.menuInfo();
        minuman.sajikan();
        minuman.tambahEs();
    } 

}

class Makanan extends Menu {
    private String porsi;

    public Makanan(String namaMenu, int harga, boolean ketersediaan, String porsi) {
        super(namaMenu, harga, ketersediaan); 
        this.porsi = porsi;
    }

    public void sajikan(String namaMenu) {
        System.out.println("Menyajikan " + namaMenu + "porsi " + porsi);
    }

    public void tambahPorsi() {
        System.out.println("Porsi " + getNama() + " ditambah!");
    }
}

class Minuman extends Menu {
    private String suhu;

    public String getSuhu() {
        return suhu;
    }

    public Minuman(String namaMenu, int harga, boolean ketersediaan, String suhu) {
        super(namaMenu, harga, ketersediaan); 
        this.suhu = suhu;
    }

    public void sajikan(String namaMenu, String suhu) {
        System.out.println("Menyajikan " + namaMenu + getSuhu());
    }

    public void tambahEs() {
        if (getSuhu().equals("dingin")) {
            System.out.println("Es ditambakan!");
        } else {
            System.out.println("Minuman panas tidak dapat menambah es.");
        }
    }
}

```
