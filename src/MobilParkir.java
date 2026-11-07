public class MobilParkir extends KendaraanParkir implements TiketElektronik, KeamananGedung {
    private int nomorLantai;
    private boolean parkirVip;

    public MobilParkir(String nomorTiket, String platNomor, int nomorLantai) {
        super(nomorTiket, platNomor);
        this.nomorLantai = nomorLantai;
        this.parkirVip = false;
    }

    public MobilParkir(String nomorTiket, String platNomor, int waktuMasukJam, double tarifPerJam, int nomorLantai, boolean parkirVip) {
        super(nomorTiket, platNomor, waktuMasukJam, tarifPerJam);
        this.nomorLantai = nomorLantai;
        this.parkirVip = parkirVip;
    }

    @Override
    public double hitungTarifParkir(int waktuKeluarJam) {
        int durasi = hitungDurasiParkir(waktuKeluarJam);
        double total;

        if (durasi > 5) {
            System.out.println("-> Durasi parkir mobil cukup lama (" + durasi + " jam), diskon flat 10% diterapkan.");
            total = (durasi * getTarifPerJam()) * 0.9;
        } else {
            total = durasi * getTarifPerJam();
        }

        if (parkirVip) {
            total += 20000.0;
        }

        return total;
    }

    @Override
    public void tampilkanInformasiParkir() {
        super.tampilkanInformasiParkir();
        System.out.println("Jenis          : Mobil (Roda 4)");
        System.out.println("Lokasi Lantai  : Lantai " + nomorLantai);
        System.out.println("Kategori       : " + (parkirVip ? "VIP Parking" : "Reguler"));
    }

    @Override
    public void cetakStrukParkir() {
        System.out.println("[STRUK DIGIT] Mobil " + getPlatNomor() + " | Barcode: " + generateBarcode());
    }

    @Override
    public String generateBarcode() {
        return "MBL-" + getNomorTiket() + "-FT";
    }

    @Override
    public boolean verifikasiPlatNomor(String platInput) {
        return getPlatNomor().equalsIgnoreCase(platInput);
    }

    @Override
    public void bukaPalangOtomatis() {
        System.out.println("Sensor Kamera Merekam Plat: " + getPlatNomor() + ". Palang Masuk Terbuka!");
    }

    public int getNomorLantai() { return nomorLantai; }
    public void setNomorLantai(int nomorLantai) { this.nomorLantai = nomorLantai; }
    public boolean isParkirVip() { return parkirVip; }
    public void setParkirVip(boolean parkirVip) { this.parkirVip = parkirVip; }
}
