Program menghitung nilai akhir mahasiswa berdasarkan komponen ( Tugas, Quiz, UTS dan UAS) dengan bobot tertentu.
Struktur program 1. class > PerhitunganNilaiAkhir merupakan class utama yang mengimplementasikan interface penilaian dan menangani logika perhitungan nilai, terlihat bobot yang sudah ditentukan disitu.
Refactoring :
1. Rename Variabel : diubah agar lebih deskriptif
2. Extract Method : pemisahan logika input komponen nilai ke method terpisah.
3. Introduce Parameter Object : Menggunakan object KomponenNilai untuk menggantikan multiple parameters.
4. Inline : Mengembalikan hasil kondisi secara langsung tanpa variabel temporary.

Dibagi jadi 2 package before dan after, dimana after adalah hasil refactoring ang sudah ditentukan. Ada 4 class yang pertama Before/PerhitunganNilaiAkhir lalu kedua After/PerhitunganNilaiAkhir, ke 3 ada KomponenNilai dan yang terakhir ada class interface dengan nama penilaian.
Class before berisi program atau codingan utuk penilaian nilai akhir mahasiswa, class after hanya ditambahkan refactoring, class KomponenNilai berisi 


