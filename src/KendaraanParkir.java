public abstract class KendaraanParkir {
    public static final String NAMA_GEDUNG = "Smart Garage FT Unsoed";
    private final String nomorTiket;

    private String platNomor;
    private int waktuMasukJam;
    private double tarifPerJam;
    private boolean statusParkir;

    public KendaraanParkir(String nomorTiket, String platNomor) {
        this(nomorTiket, platNomor, 8, 3000.0);
    }

    public KendaraanParkir(String nomorTiket, String platNomor, int waktuMasukJam, double tarifPerJam) {
        this.nomorTiket = nomorTiket;
        this.platNomor = platNomor;
        this.waktuMasukJam = waktuMasukJam;
        this.tarifPerJam = tarifPerJam;
        this.statusParkir = true;
    }

    public int hitungDurasiParkir(int waktuKeluarJam) {
        if (waktuKeluarJam <= waktuMasukJam) {
            return 1;
        }
        return waktuKeluarJam - waktuMasukJam;
    }

    public void keluarParkir() {
        this.statusParkir = false;
        System.out.println("Kendaraan [" + platNomor + "] telah meninggalkan area parkir.");
    }

    public abstract double hitungTarifParkir(int waktuKeluarJam);

    public void tampilkanInformasiParkir() {
        System.out.println("=== SISTEM PARKIR (" + NAMA_GEDUNG + ") ===");
        System.out.println("No. Tiket      : " + nomorTiket);
        System.out.println("Plat Nomor     : " + platNomor);
        System.out.println("Waktu Masuk    : Jam " + waktuMasukJam + ":00");
        System.out.println("Status Parkir  : " + (statusParkir ? "Aktif di Garasi" : "Sudah Keluar"));
    }

    public String getNomorTiket() { return nomorTiket; }

    public String getPlatNomor() { return platNomor; }
    public void setPlatNomor(String platNomor) { this.platNomor = platNomor; }

    public int getWaktuMasukJam() { return waktuMasukJam; }
    public void setWaktuMasukJam(int waktuMasukJam) { this.waktuMasukJam = waktuMasukJam; }

    public double getTarifPerJam() { return tarifPerJam; }
    public void setTarifPerJam(double tarifPerJam) { this.tarifPerJam = tarifPerJam; }

    public boolean isStatusParkir() { return statusParkir; }
    public void setStatusParkir(boolean statusParkir) { this.statusParkir = statusParkir; }
}
