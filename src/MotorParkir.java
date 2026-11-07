public class MotorParkir extends KendaraanParkir implements TiketElektronik {
    private boolean penitipanHelm;

    public MotorParkir(String nomorTiket, String platNomor, boolean penitipanHelm) {
        super(nomorTiket, platNomor);
        this.penitipanHelm = penitipanHelm;
    }

    public MotorParkir(String nomorTiket, String platNomor, int waktuMasukJam, double tarifPerJam, boolean penitipanHelm) {
        super(nomorTiket, platNomor, waktuMasukJam, tarifPerJam);
        this.penitipanHelm = penitipanHelm;
    }

    @Override
    public double hitungTarifParkir(int waktuKeluarJam) {
        int durasi = hitungDurasiParkir(waktuKeluarJam);
        double total = durasi * getTarifPerJam();

        if (penitipanHelm) {
            total += 5000.0;
        }
        return total;
    }

    @Override
    public void tampilkanInformasiParkir() {
        super.tampilkanInformasiParkir();
        System.out.println("Jenis          : Motor (Roda 2)");
        System.out.println("Titip Helm     : " + (penitipanHelm ? "Ya (+Rp 5.000)" : "Tidak"));
    }

    @Override
    public void cetakStrukParkir() {
        System.out.println("[STRUK DIGIT] Motor " + getPlatNomor() + " | Barcode: " + generateBarcode());
    }

    @Override
    public String generateBarcode() {
        return "MTR-" + getNomorTiket() + "-FT";
    }

    public boolean isPenitipanHelm() { return penitipanHelm; }
    public void setPenitipanHelm(boolean penitipanHelm) { this.penitipanHelm = penitipanHelm; }
}