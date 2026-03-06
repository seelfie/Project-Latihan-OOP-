# Project-Latihan-OOP
- Nama: Silfi Rochmatul Auliyah 
- NRP: 5027251008

---
## 1. Enkapsulasi
Enkapsulasi merupakan proses pembungkusan variabel dan method menjadi satu unit tunggal (Class) yang juga bertujuan untuk menyembunyikan detail data dari pihak luar. Dengan enkapsulasi, isi dan cara kerja di dalam sebuah class tidak perlu diketahui oleh orang luar. Konsep ini membuat kode lebih mudah diatur dan diubah tanpa mengganggu bagian lain. Selain itu, setiap class jadi punya tugasnya masing-masing sehingga program lebih rapi dan mudah diperbaiki kalau ada masalah. 

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
    public String getNama () {
        return nama; 
    }
    public int getNilai () {
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
