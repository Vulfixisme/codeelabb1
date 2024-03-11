import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "mahasiswa.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Menu :");
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

        // Simpan data
        simpanDataMahasiswa(new Mahasiswa(nama,nim, jurusan));
    }

    public static void simpanDataMahasiswa(Mahasiswa mahasiswa) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bufferedWriter.write(mahasiswa.cobaNim() + "," + mahasiswa.cobaJurusan() + "," + mahasiswa.cobaNama());
            bufferedWriter.newLine();
            System.out.println("Data Mahasiswa berhasil ditambahkan!");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis data mahasiswa: " + e.getMessage());
        }
    }

    public static void tampilkanDataMahasiswa() {
        try (BufferedReader pembaca = new BufferedReader(new FileReader)) {
            String line;
            System.out.println("Data Mahasiswa:");
            while ((line = pembaca.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    System.out.println("NIM: " + data[0] + ", Jurusan: " + data[1] +" Nama: " + data[2] );
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File data mahasiswa tidak ditemukan.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca data mahasiswa: " );
        }
    }
}