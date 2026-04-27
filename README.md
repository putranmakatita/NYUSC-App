LAPORAN PROGRAM
Not Your Usual Scientific Calculator (NYUSC)
1. Latar Belakang
Perkembangan teknologi mobile memungkinkan berbagai perhitungan ilmiah dilakukan dengan mudah melalui aplikasi. Namun, sebagian besar kalkulator ilmiah hanya menyediakan fungsi dasar seperti aritmatika, trigonometri, atau logaritma.
Oleh karena itu, dibuatlah aplikasi Not Your Usual Scientific Calculator (NYUSC) yang menawarkan fitur-fitur perhitungan ilmiah yang lebih spesifik dan aplikatif, seperti kimia, matematika, dan geografi, dalam satu aplikasi berbasis Android.
2. Tujuan
Tujuan dari pembuatan aplikasi NYUSC adalah:
1.	Menyediakan alat bantu perhitungan ilmiah yang lebih variatif 
2.	Membantu mahasiswa dalam menyelesaikan soal terkait kimia, matematika, dan geografi 
3.	Mengintegrasikan berbagai rumus penting dalam satu aplikasi 
4.	Memberikan referensi teori dari setiap perhitungan yang tersedia 
3. Deskripsi Aplikasi
NYUSC merupakan aplikasi berbasis Android yang dikembangkan menggunakan bahasa pemrograman Kotlin dan IDE Android Studio.
Aplikasi ini terdiri dari beberapa halaman utama yang masing-masing memiliki fungsi berbeda.
4. Fitur Aplikasi
4.1 Home
Halaman utama yang berfungsi sebagai navigasi ke seluruh fitur dalam aplikasi.
4.2 Molar Mass Calculator
Fitur ini digunakan untuk menghitung massa molar suatu senyawa kimia berdasarkan rumus kimianya.
Contoh: Input H₂O, Output 18 g/mol.
Perhitungan dilakukan dengan menjumlahkan massa atom relatif dari setiap unsur.
4.3 Distance Calculator (Haversine Formula)
Digunakan untuk menghitung jarak antara dua titik di permukaan bumi berdasarkan koordinat lintang dan bujur.
Menggunakan rumus Haversine:
 
4.4 Probability Calculator
Fitur ini menghitung:
1.	Kombinasi (Combination) 
2.	Permutasi (Permutation) 
Rumus:
1.	Kombinasi: 
 
2.	Permutasi:
 
4.5 Calculus Calculator
Fitur ini menyediakan:
1.	Turunan (Derivative) 
2.	Integral (Integral) 
Digunakan untuk membantu perhitungan dasar dalam kalkulus.
4.6 Reference Page
Halaman ini berisi penjelasan singkat mengenai rumus-rumus yang digunakan dalam aplikasi serta tautan ke sumber eksternal seperti Wikipedia untuk pembelajaran lebih lanjut.
5. Teknologi yang Digunakan
1.	Bahasa Pemrograman: Kotlin 
2.	IDE: Android Studio 
3.	UI Framework: XML Layout 
4.	Library: Material Design Components 
5.	Data Source: JSON (untuk massa atom) 
6.	Openstreetmap
6. Struktur Aplikasi
Struktur package dalam aplikasi:
1.	ui.home 
2.	ui.molar 
3.	ui.distance 
4.	ui.probability 
5.	ui.calculus 
6.	ui.reference 
Setiap fitur memiliki Activity masing-masing untuk memudahkan pengelolaan kode.
7. Kelebihan Aplikasi
1.	Menggabungkan berbagai kalkulator ilmiah dalam satu aplikasi 
2.	Tampilan sederhana dan mudah digunakan 
3.	Mendukung pembelajaran dengan halaman referensi 
4.	Berbasis Android sehingga mudah diakses 
8. Kekurangan Aplikasi
1.	Fitur kalkulus masih terbatas pada operasi sederhana 
2.	Belum mendukung parsing rumus kompleks secara penuh 
3.	Belum menggunakan database online 
9. Kesimpulan
Aplikasi NYUSC berhasil dibuat sebagai solusi alternatif kalkulator ilmiah dengan fitur yang lebih spesifik dan edukatif. Aplikasi ini dapat membantu pengguna dalam melakukan berbagai perhitungan ilmiah dengan lebih praktis.
10. Saran Pengembangan
1.	Menambahkan grafik fungsi pada kalkulus 
2.	Integrasi API untuk data ilmiah 
3.	Menambahkan fitur penyimpanan hasil perhitungan 
4.	Mengembangkan UI yang lebih interaktif 
11. Referensi sumber kode
Sumber kode dapat diakses dan diunduh di platform github dengan link repository berikut:

