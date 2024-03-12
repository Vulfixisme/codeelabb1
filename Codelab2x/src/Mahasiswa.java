public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;


    public Mahasiswa(String cobanama, String cobaNim, String cobaJurusan) {
        nim = cobaNim;
        jurusan = cobaJurusan;
        nama = cobanama;
    }

    public static void tampilUniversitas() {
        System.out.println("Universitas Universitas Muhammadiyah Malang");
    }

    public String cobaNim() {
        return nim;
    }

    public String cobaJurusan() {
        return jurusan;
    }

    public String cobaNama() {
        return nama;
    }

    public static boolean Nimbnr(String nim) {
        return nim != null && nim.length() == 15 && nim.matches("\\d+");
    }
}