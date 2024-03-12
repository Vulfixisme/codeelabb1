import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda : ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.println("Data Mahasiswa");
                    Mahasiswa.tampilUniversitas();
                    tambahDataMahasiswa(scanner);
                    break;
                case 2:
                    tampilkanDataMahasiswa();
                    break;
                case 3:
                    System.out.println("Keluar...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-3.");
            }
        }

        scanner.close();
    }
    public static void tambahDataMahasiswa(Scanner scanner) {
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan NIM (harus 15 angka): ");
        String nim = scanner.nextLine();

        // Validasi NIM
        if (!Mahasiswa.Nimbnr(nim)) {
            System.out.println("NIM tidak valid. Harus 15 angka.");
            return;
        }

        System.out.print("Masukkan Jurusan: ");
        String jurusan = scanner.nextLine();


        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, jurusan);
        daftarMahasiswa.add(mahasiswa);

        System.out.println("Data Mahasiswa berhasil ditambahkan!");
    }

    public static void tampilkanDataMahasiswa() {
        System.out.println("Data Mahasiswa:");
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            System.out.println(" Nama: " + mahasiswa.cobaNama()+ "NIM: " + mahasiswa.cobaNim() + ", Jurusan: " + mahasiswa.cobaJurusan() );
        }
    }
}