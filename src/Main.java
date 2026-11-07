public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  SISTEM MANAGEMENT SMART GARAGE   ");
        System.out.println("==================================================\n");

        MobilParkir mobil1 = new MobilParkir("TK-001", "R 1234 AB", 8, 5000.0, 2, true);
        MotorParkir motor1 = new MotorParkir("TK-002", "R 5678 CD", 9, 2000.0, true);

        System.out.println("--- 1. INFORMASI PARKIR AWAL ---");
        mobil1.tampilkanInformasiParkir();
        System.out.println();
        motor1.tampilkanInformasiParkir();

        System.out.println("\n--- 2. LOGIKA STATE PERCABANGAN & ABSTRACT METHOD ---");
        int waktuKeluar = 15;
        double totalBiayaMobil = mobil1.hitungTarifParkir(waktuKeluar);
        double totalBiayaMotor = motor1.hitungTarifParkir(waktuKeluar);

        System.out.println("Total Tarif Mobil " + mobil1.getPlatNomor() + " (Keluar jam 15:00): Rp " + totalBiayaMobil);
        System.out.println("Total Tarif Motor " + motor1.getPlatNomor() + " (Keluar jam 15:00): Rp " + totalBiayaMotor);

        System.out.println("\n--- 3. POLIMORFISME INTERFACE ---");
        TiketElektronik tiketMobil = mobil1;
        tiketMobil.cetakStrukParkir();

        KeamananGedung keamananMobil = mobil1;
        keamananMobil.bukaPalangOtomatis();
        System.out.println("Verifikasi Plat [R 1234 AB]: " + (keamananMobil.verifikasiPlatNomor("R 1234 AB") ? "COCOK" : "SALAH"));

        TiketElektronik tiketMotor = motor1;
        tiketMotor.cetakStrukParkir();

        System.out.println("\n--- 4. UPDATE STATE KENDARAAN KELUAR ---");
        mobil1.keluarParkir();
        motor1.keluarParkir();

        System.out.println("\n==================================================");
        System.out.println("   PENGUJIAN KODE SELESAI - SELURUH REQ TERPENUHI");
        System.out.println("==================================================");
    }
}