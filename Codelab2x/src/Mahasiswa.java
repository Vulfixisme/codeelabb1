public class Mahasiswa {
    private String nim;
    private String jurusan;
    private String nama;

    // Constructor
    public Mahasiswa(String nim, String jurusan, String nama) {
        this.nim = nim;
        this.jurusan = jurusan;
        this.nama = nama;
    }

    // Getter
    public String cobaNim() {
        return nim;
    }

    public String cobaJurusan() {
        return jurusan;
    }

    public String cobaNama() {
        return nama;
    }

    // Static method to display universitas information
    public static void tampilUniversitas() {
        System.out.println("Universitas MUHAMMADIYAH MALANG");
    }

    // Validate NIM
    public static boolean Nimbnr(String nim) {
        return nim != null && nim.length() == 15 && nim.matches("\\d+");
    }
}