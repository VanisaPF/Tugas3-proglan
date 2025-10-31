package Before;
import java.util.Scanner;

public class PerhitunganNilaiAkhir {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("================================================");
        System.out.println("   PROGRAM PERHITUNGAN NILAI AKHIR MAHASISWA");
        System.out.println("================================================");
        System.out.println();

        System.out.print("Nama Mahasiswa    : ");
        String nama = input.nextLine();

        System.out.print("NIM               : ");
        String nim = input.nextLine();

        System.out.print("Mata Kuliah       : ");
        String mataKuliah = input.nextLine();

        System.out.println();
        System.out.println("MASUKKAN KOMPONEN NILAI");
        System.out.print("Nilai Tugas (0-100)       : ");
        double nilaiTugas = input.nextDouble();

        System.out.print("Nilai Quiz (0-100)        : ");
        double nilaiQuiz = input.nextDouble();

        System.out.print("Nilai UTS (0-100)         : ");
        double nilaiUTS = input.nextDouble();

        System.out.print("Nilai UAS (0-100)         : ");
        double nilaiUAS = input.nextDouble();
        double bobotTugas = 0.20;  // 20%
        double bobotQuiz = 0.15;   // 15%
        double bobotUTS = 0.30;    // 30%
        double bobotUAS = 0.35;    // 35%

        double nilaiAkhir = (nilaiTugas * bobotTugas) +
                (nilaiQuiz * bobotQuiz) +
                (nilaiUTS * bobotUTS) +
                (nilaiUAS * bobotUAS);

        String grade;
        String keterangan;

        if (nilaiAkhir >= 85) {
            grade = "A";
            keterangan = "SANGAT BAIK";
        } else if (nilaiAkhir >= 70) {
            grade = "B";
            keterangan = "BAIK";
        } else if (nilaiAkhir >= 60) {
            grade = "C";
            keterangan = "CUKUP";
        } else if (nilaiAkhir >= 50) {
            grade = "D";
            keterangan = "KURANG";
        } else {
            grade = "E";
            keterangan = "GAGAL";
        }
        String status = (nilaiAkhir >= 60) ? "LULUS" : "TIDAK LULUS";

        System.out.println();
        System.out.println("              HASIL PERHITUNGAN");
        System.out.println("================================================");
        System.out.println("Nama              : " + nama);
        System.out.println("NIM               : " + nim);
        System.out.println("Mata Kuliah       : " + mataKuliah);
        System.out.println("------------------------------------------------");
        System.out.println("Nilai Tugas (20%) : " + nilaiTugas);
        System.out.println("Nilai Quiz (15%)  : " + nilaiQuiz);
        System.out.println("Nilai UTS (30%)   : " + nilaiUTS);
        System.out.println("Nilai UAS (35%)   : " + nilaiUAS);
        System.out.println("------------------------------------------------");
        System.out.printf("NILAI AKHIR       : %.2f\n", nilaiAkhir);
        System.out.println("GRADE             : " + grade);
        System.out.println("KETERANGAN        : " + keterangan);
        System.out.println("STATUS            : " + status);
        System.out.println("================================================");

        input.close();
    }
}
