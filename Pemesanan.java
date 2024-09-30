package com.mycompany.src.pemesanan;

import com.mycompany.src.menu.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Pemesanan {
    private int totalHarga;
    private final Menu menu;
    private static List<String> daftarPesanan;

    public Pemesanan(Menu menu) {
        this.totalHarga = 0;
        this.menu = menu;
        daftarPesanan = new ArrayList<>();
    }

    public void prosesPesanan() {
        Scanner scanner = new Scanner(System.in);
        String pilihan;

        while (true) {
            System.out.println("\nPilihan:");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Hapus Pesanan");
            System.out.println("3. Perbarui Pesanan");
            System.out.println("4. Tampilkan Pesanan");
            System.out.println("5. Selesai");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    tambahPesanan(scanner);
                    break;
                case "2":
                    hapusPesanan(scanner);
                    break;
                case "3":
                    perbaruiPesanan(scanner);
                    break;
                case "4":
                    tampilkanDaftarPesanan();
                    break;
                case "5":
                    System.out.println("Total harga yang harus dibayar: Rp " + totalHarga);
                    return; // Keluar dari loop
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void tambahPesanan(Scanner scanner) {
        System.out.print("Masukkan nama menu yang ingin dipesan: ");
        String pilihan = scanner.nextLine().trim().toLowerCase();

        // Cari menu yang sesuai dengan input pengguna
        for (Map.Entry<String, Integer> entry : menu.getDaftarMenu().entrySet()) {
            if (entry.getKey().toLowerCase().equals(pilihan)) {
                System.out.print("Berapa porsi " + entry.getKey() + " yang ingin dipesan?: ");
                int jumlah = Integer.parseInt(scanner.nextLine());
                totalHarga += entry.getValue() * jumlah;
                for (int i = 0; i < jumlah; i++) {
                    daftarPesanan.add(entry.getKey());
                }
                System.out.println("Pesanan " + jumlah + " porsi " + entry.getKey() + " ditambahkan.");
                return;
            }
        }

        System.out.println("Menu tidak ditemukan.");
    }

    private void hapusPesanan(Scanner scanner) {
        if (daftarPesanan.isEmpty()) {
            System.out.println("Daftar pesanan kosong.");
            return;
        }
        tampilkanDaftarPesanan();
        System.out.print("Masukkan nomor pesanan yang ingin dihapus (1-" + daftarPesanan.size() + "): ");
        int nomor = Integer.parseInt(scanner.nextLine()) - 1;

        if (nomor >= 0 && nomor < daftarPesanan.size()) {
            String menuHapus = daftarPesanan.remove(nomor);
            totalHarga -= menu.getDaftarMenu().get(menuHapus);
            System.out.println("Pesanan " + menuHapus + " telah dihapus.");
        } else {
            System.out.println("Nomor pesanan tidak valid.");
        }
    }

    private void perbaruiPesanan(Scanner scanner) {
        if (daftarPesanan.isEmpty()) {
            System.out.println("Daftar pesanan kosong.");
            return;
        }
        tampilkanDaftarPesanan();
        System.out.print("Masukkan nomor pesanan yang ingin diperbarui (1-" + daftarPesanan.size() + "): ");
        int nomor = Integer.parseInt(scanner.nextLine()) - 1;

        if (nomor >= 0 && nomor < daftarPesanan.size()) {
            String menuLama = daftarPesanan.get(nomor);
            System.out.println("Pesanan yang diperbarui: " + menuLama);

            System.out.print("Masukkan nama menu baru: ");
            String menuBaru = scanner.nextLine().trim().toLowerCase();

            // Cari menu baru yang sesuai
            for (Map.Entry<String, Integer> entry : menu.getDaftarMenu().entrySet()) {
                if (entry.getKey().toLowerCase().equals(menuBaru)) {
                    totalHarga -= menu.getDaftarMenu().get(menuLama);
                    daftarPesanan.set(nomor, entry.getKey());
                    totalHarga += entry.getValue();
                    System.out.println("Pesanan diperbarui menjadi " + entry.getKey());
                    return;
                }
            }

            System.out.println("Menu baru tidak ditemukan.");
        } else {
            System.out.println("Nomor pesanan tidak valid.");
        }
    }

    public static void tampilkanDaftarPesanan() {
        System.out.println("Daftar Pesanan:");
        if (daftarPesanan.isEmpty()) {
            System.out.println("Tidak ada pesanan.");
        } else {
            for (int i = 0; i < daftarPesanan.size(); i++) {
                System.out.println((i + 1) + ". " + daftarPesanan.get(i));
            }
        }
    }

    public int getTotalHarga() {
        return totalHarga;
    }
}
