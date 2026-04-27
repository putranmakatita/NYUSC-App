# 📱 LAPORAN PROGRAM  
## Not Your Usual Scientific Calculator (NYUSC)

---

## 1. Latar Belakang
Perkembangan teknologi mobile memungkinkan berbagai perhitungan ilmiah dilakukan dengan mudah melalui aplikasi. Namun, sebagian besar kalkulator ilmiah hanya menyediakan fungsi dasar seperti aritmatika, trigonometri, atau logaritma.  

Oleh karena itu, dibuatlah aplikasi **Not Your Usual Scientific Calculator (NYUSC)** yang menawarkan fitur perhitungan ilmiah yang lebih spesifik dan aplikatif, seperti kimia, matematika, dan geografi, dalam satu aplikasi berbasis Android.

---

## 2. Tujuan
Tujuan dari pembuatan aplikasi NYUSC adalah:
1. Menyediakan alat bantu perhitungan ilmiah yang lebih variatif  
2. Membantu mahasiswa dalam menyelesaikan soal terkait kimia, matematika, dan geografi  
3. Mengintegrasikan berbagai rumus penting dalam satu aplikasi  
4. Memberikan referensi teori dari setiap perhitungan yang tersedia  

---

## 3. Deskripsi Aplikasi
NYUSC merupakan aplikasi berbasis Android yang dikembangkan menggunakan:
- Bahasa: Kotlin  
- IDE: Android Studio  

Aplikasi ini terdiri dari beberapa halaman utama dengan fungsi berbeda.

---

## 4. Fitur Aplikasi

### 4.1 Home
Halaman utama yang berfungsi sebagai navigasi ke seluruh fitur dalam aplikasi.

---

### 4.2 Molar Mass Calculator
Digunakan untuk menghitung massa molar suatu senyawa kimia berdasarkan rumus kimianya.

Contoh:
- Input: H2O  
- Output: 18 g/mol  

Perhitungan dilakukan dengan menjumlahkan massa atom relatif tiap unsur.

---

### 4.3 Distance Calculator (Haversine Formula)
Digunakan untuk menghitung jarak antara dua titik di permukaan bumi berdasarkan koordinat lintang dan bujur.

Rumus Haversine:
d = 2r × arcsin( √( sin²(Δφ/2) + cos(φ1) × cos(φ2) × sin²(Δλ/2) ) )

---

### 4.4 Probability Calculator
Digunakan untuk menghitung:
- Kombinasi (Combination)  
- Permutasi (Permutation)  

Rumus:

Kombinasi:  
C(n, r) = n! / (r! × (n - r)!)

Permutasi:  
P(n, r) = n! / (n - r)!

---

### 4.5 Calculus Calculator
Menyediakan perhitungan dasar:
- Turunan (Derivative)  
- Integral (Integral)  

Digunakan untuk membantu perhitungan dasar dalam kalkulus.

---

### 4.6 Reference Page
Halaman ini berisi:
- Penjelasan rumus  
- Tautan ke sumber eksternal (misalnya Wikipedia)  

---

## 5. Teknologi yang Digunakan
- Bahasa Pemrograman: Kotlin  
- IDE: Android Studio  
- UI Framework: XML Layout  
- Library: Material Design Components  
- Data Source: JSON (massa atom)  
- Map Source: OpenStreetMap  

---

## 6. Struktur Aplikasi
Struktur package dalam aplikasi:

ui.home  
ui.molar  
ui.distance  
ui.probability  
ui.calculus  
ui.reference  

Setiap fitur memiliki Activity masing-masing untuk memudahkan pengelolaan kode.

---

## 7. Kelebihan Aplikasi
1. Menggabungkan berbagai kalkulator ilmiah dalam satu aplikasi  
2. Tampilan sederhana dan mudah digunakan  
3. Mendukung pembelajaran dengan halaman referensi  
4. Berbasis Android sehingga mudah diakses  

---

## 8. Kekurangan Aplikasi
1. Fitur kalkulus masih terbatas pada operasi sederhana  
2. Belum mendukung parsing rumus kompleks secara penuh  
3. Belum menggunakan database online  

---

## 9. Kesimpulan
Aplikasi NYUSC berhasil dibuat sebagai solusi alternatif kalkulator ilmiah dengan fitur yang lebih spesifik dan edukatif. Aplikasi ini membantu pengguna dalam melakukan berbagai perhitungan ilmiah dengan lebih praktis.

---

## 10. Saran Pengembangan
1. Menambahkan grafik fungsi pada kalkulus  
2. Integrasi API untuk data ilmiah  
3. Menambahkan fitur penyimpanan hasil perhitungan  
4. Mengembangkan UI yang lebih interaktif  

---

## 11. Repository
Sumber kode dapat diakses melalui repository GitHub:

👉 (masukkan link repo kamu di sini)
