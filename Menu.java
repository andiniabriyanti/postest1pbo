package com.mycompany.src.menu;

import java.util.HashMap;
import java.util.Map;

public final class Menu {
    private final Map<String, Integer> daftarMenu;

    public Menu() {
        daftarMenu = new HashMap<>();
        tambahMenu("Nasi Goreng", 15000);
        tambahMenu("Mie Goreng", 12000);
        tambahMenu("Sate Ayam", 20000);
    }

    // Create: Tambah menu
    public void tambahMenu(String nama, int harga) {
        daftarMenu.put(nama, harga);
    }

    // Read: Lihat semua menu
    public Map<String, Integer> getDaftarMenu() {
        return daftarMenu;
    }

    // Update: Ubah harga menu
    public void updateMenu(String nama, int hargaBaru) {
        if (daftarMenu.containsKey(nama)) {
            daftarMenu.put(nama, hargaBaru);
        } else {
            System.out.println("Menu tidak ditemukan.");
        }
    }

    // Delete: Hapus menu
    public void hapusMenu(String nama) {
        if (daftarMenu.containsKey(nama)) {
            daftarMenu.remove(nama);
        } else {
            System.out.println("Menu tidak ditemukan.");
        }
    }

    public void tampilkanMenu() {
        System.out.println("Daftar Menu:");
        for (Map.Entry<String, Integer> entry : daftarMenu.entrySet()) {
            System.out.println(entry.getKey() + ": Rp " + entry.getValue());
        }
    }
}
