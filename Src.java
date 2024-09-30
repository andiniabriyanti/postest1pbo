package com.mycompany.src;

import com.mycompany.src.menu.Menu;
import com.mycompany.src.pemesanan.Pemesanan;

public class Src {

    public static void main(String[] args) {
        
        // Membuat menu baru
        Menu menu = new Menu();
        
        // Menambahkan beberapa item menu
        menu.tambahMenu("Nasi Goreng", 15000);
        menu.tambahMenu("Mie Goreng", 12000);
        menu.tambahMenu("Ayam Bakar", 20000);
        menu.tambahMenu("Es Teh", 5000);
        menu.tambahMenu("Es Jeruk", 7000);

        // Menampilkan menu yang tersedia
        System.out.println("Selamat datang di restoran!");
        System.out.println("Menu yang tersedia:");
        menu.tampilkanMenu();

        // Membuat pemesanan berdasarkan menu yang sudah ada
        Pemesanan pemesanan = new Pemesanan(menu);

        // Memproses pemesanan
        System.out.println("\nSilakan lakukan pemesanan:");
        pemesanan.prosesPesanan();

        // Output: menampilkan total harga dan daftar pesanan
        System.out.println("\nTotal harga yang harus dibayar: Rp " + pemesanan.getTotalHarga());
        pemesanan.tampilkanDaftarPesanan();
    }
}
