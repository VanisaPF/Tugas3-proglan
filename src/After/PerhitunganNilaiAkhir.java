package After;
import java.util.Scanner;


public class PerhitunganNilaiAkhir implements Penilaian {

    private final double bobotTugas = 0.20;
    private final double bobotQuiz = 0.15;
    private final double bobotUTS = 0.30;
    private final double bobotUAS = 0.35;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PROGRAM PERHITUNGAN NILAI AKHIR MAHASISWA");
        System.out.println("================================================");

        // RENAME VARIABLE
        // Ubah nama biar lebih deskriptif dan sesuai konvensi Java.
        System.out.print("Nama Mahasiswa : ");
        String namaMahasiswa = scanner.nextLine(); // sebelumnya: nama

        System.out.print("NIM : ");
        String nomorInduk = scanner.nextLine(); // sebelumnya: nim

        System.out.print("Mata Kuliah : ");
        String matkul = scanner.nextLine(); // sebelumnya: mataKuliah

        // EXTRACT METHOD
        KomponenNilai nilai = inputKomponenNilai(scanner);
        PerhitunganNilaiAkhir program = new PerhitunganNilaiAkhir();
        double nilaiAkhir = program.hitungNilaiAkhir(nilai);
        String grade = program.tentukanGrade(nilaiAkhir);
        String status = program.tentukanStatus(nilaiAkhir);

        System.out.println("\nHASIL PERHITUNGAN");
        System.out.println("================================================");
        System.out.println("Nama              : " + namaMahasiswa);
        System.out.println("NIM               : " + nomorInduk);
        System.out.println("Mata Kuliah       : " + matkul);
        System.out.println("------------------------------------------------");
        System.out.printf("Nilai Akhir       : %.2f\n", nilaiAkhir);
        System.out.println("Grade             : " + grade);
        System.out.println("Status            : " + status);
        System.out.println("================================================");

        scanner.close();
    }

    //  EXTRACT METHOD
    // Method baru untuk input komponen nilai biar main() lebih ringkas.
    private static KomponenNilai inputKomponenNilai(Scanner scanner) {
        System.out.println("\nMASUKKAN KOMPONEN NILAI");
        System.out.print("Nilai Tugas (0-100): ");
        double tugas = scanner.nextDouble();
        System.out.print("Nilai Quiz (0-100): ");
        double quiz = scanner.nextDouble();
        System.out.print("Nilai UTS (0-100): ");
        double uts = scanner.nextDouble();
        System.out.print("Nilai UAS (0-100): ");
        double uas = scanner.nextDouble();
        return new KomponenNilai(tugas, quiz, uts, uas);
    }

    // INTRODUCE PARAMETER OBJECT digunakan di sini
    public double hitungNilaiAkhir(KomponenNilai nilai) {
        return (nilai.tugas * bobotTugas)
                + (nilai.quiz * bobotQuiz)
                + (nilai.uts * bobotUTS)
                + (nilai.uas * bobotUAS);
    }

    @Override
    public double hitungNilaiAkhir() {
        return 0; // tidak dipakai, hanya untuk memenuhi kontrak interface
    }
    //inline
    @Override
    public String tentukanGrade(double nilaiAkhir) {
        if (nilaiAkhir >= 85) return "A (SANGAT BAIK)";
        else if (nilaiAkhir >= 70) return "B (BAIK)";
        else if (nilaiAkhir >= 60) return "C (CUKUP)";
        else if (nilaiAkhir >= 50) return "D (KURANG)";
        else return "E (GAGAL)";
    }

    @Override
    public String tentukanStatus(double nilaiAkhir) {
        return (nilaiAkhir >= 60) ? "LULUS" : "TIDAK LULUS";
}
}