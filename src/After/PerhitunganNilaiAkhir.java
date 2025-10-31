package After;
import java.util.Scanner;

/**
 * Kelas {@code PerhitunganNilaiAkhir} digunakan untuk menghitung nilai akhir mahasiswa.
 * <p>
 * Kelas ini mengimplementasikan interface {@code Penilaian} dan memanfaatkan bobot
 * penilaian yang telah ditentukan untuk setiap komponen (tugas, quiz, UTS, dan UAS).
 * </p>
 *
 * <ul>
 *     <li>Tugas = 20%</li>
 *     <li>Quiz = 15%</li>
 *     <li>UTS = 30%</li>
 *     <li>UAS = 35%</li>
 * </ul>
 *
 * Program ini juga menampilkan hasil berupa nilai akhir, grade, dan status kelulusan.
 *
 * @author Van
 * @version 1.0
 * @since 2025-10-31
 * */
public class PerhitunganNilaiAkhir implements Penilaian {

    private final double bobotTugas = 0.20;
    private final double bobotQuiz = 0.15;
    private final double bobotUTS = 0.30;
    private final double bobotUAS = 0.35;

    /**
     * Metode utama (entry point) dari program.
     * <p>Menangani input data mahasiswa, nilai-nilai komponen, dan menampilkan hasil akhir.</p>
     * @param args argumen baris perintah (tidak digunakan)
    **/
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

    /**
     * Metode bantu untuk menginput nilai komponen dari pengguna.
     * @param scanner objek Scanner untuk menerima input dari pengguna
     * @return objek {@link KomponenNilai} yang menyimpan nilai tugas, quiz, UTS, dan UAS
     */

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

    /**
     * Menghitung nilai akhir mahasiswa berdasarkan bobot tiap komponen.
     *
     * @param nilai objek {@link KomponenNilai} yang berisi nilai tugas, quiz, UTS, dan UAS
     * @return nilai akhir hasil perhitungan
     */
    public double hitungNilaiAkhir(KomponenNilai nilai) {
        return (nilai.tugas * bobotTugas)
                + (nilai.quiz * bobotQuiz)
                + (nilai.uts * bobotUTS)
                + (nilai.uas * bobotUAS);
    }
    /**
     * Implementasi dari interface {@link Penilaian}.
     * Tidak digunakan secara langsung dalam program ini.
     * @return selalu mengembalikan 0
     */
    @Override
    public double hitungNilaiAkhir() {
        return 0; // tidak dipakai, hanya untuk memenuhi kontrak interface
    }
    /**
     * Menentukan grade berdasarkan nilai akhir.
     *
     * @param nilaiAkhir nilai akhir mahasiswa
     * @return grade berupa huruf (A–E) dan deskripsi singkat
     */
    @Override
    public String tentukanGrade(double nilaiAkhir) {
        if (nilaiAkhir >= 85) return "A (SANGAT BAIK)";
        else if (nilaiAkhir >= 70) return "B (BAIK)";
        else if (nilaiAkhir >= 60) return "C (CUKUP)";
        else if (nilaiAkhir >= 50) return "D (KURANG)";
        else return "E (GAGAL)";
    }
    /**
     * Menentukan status kelulusan mahasiswa.
     *
     * @param nilaiAkhir nilai akhir mahasiswa
     * @return "LULUS" jika nilai ≥ 60, selain itu "TIDAK LULUS"
     */
    @Override
    public String tentukanStatus(double nilaiAkhir) {
        return (nilaiAkhir >= 60) ? "LULUS" : "TIDAK LULUS";
}
}