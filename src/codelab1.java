import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class codelab1{
    public static void main(String[]args){
        System.out.print("nama :");
        Scanner masukkan = new Scanner(System.in);
        String nama;
        nama = masukkan.nextLine();

        System.out.print("Jenis Kelamin (p/l) :");
        char jeniskelamin;
        jeniskelamin = masukkan.next().charAt(0);
        String jeniskelaminstr = "";
        if (jeniskelamin =='p'){
            jeniskelaminstr = "Perempuan";
        } else if (jeniskelamin =='l'){
            jeniskelaminstr = "Laki-Laki";
        }

        System.out.println("Inputkan tanggal lahir(yyyy-mm-dd)");
        String tanggallahir;
        tanggallahir= masukkan.next();
        LocalDate dob = LocalDate.parse(tanggallahir);
        LocalDate sekarang = LocalDate.now();
        int jarak = Period.between(dob,sekarang).getYears();
        int selisih = Period.between(dob,sekarang).getMonths();

        System.out.println("nama ; "+nama);
        System.out.println("jenis kelamin :" +jeniskelaminstr);
        System.out.println("Umur anda " +jarak+" Tahun " +selisih +" Bulan");
        masukkan.close();

    }

}