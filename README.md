# Library Book Lending System

Sistem Peminjaman Buku Perpustakaan adalah aplikasi sederhana berbasis Java yang memungkinkan pengelolaan peminjaman dan pengembalian buku di perpustakaan.

## Pembuat Project

| Nama             | NPM            |
|------------------|----------------|
| Jihan Nabilah    | 2208107010035 |
| Qandila Ahmara   | 2208107010039 |

## Fitur

1. **Peminjaman Buku**
   - Validasi pengguna
   - Pengecekan ketersediaan buku
   - Pencatatan peminjaman

2. **Pengembalian Buku**
   - Validasi pengembalian
   - Pembaruan status buku
   - Pencatatan pengembalian

3. **Pencarian Buku**
   - Pencarian berdasarkan judul
   - Pencarian berdasarkan penulis

4. **Manajemen Buku**
   - Melihat daftar buku tersedia
   - Pengelolaan status buku

## Struktur Proyek

```
Library-Book-Lending-System/
├── src/
│   ├── Buku.java              # Class untuk entitas buku
│   ├── IBukuMGR.java         # Interface untuk manajemen buku
│   ├── BukuMGR.java          # Implementasi manajemen buku
│   ├── IPenggunaMGR.java     # Interface untuk manajemen pengguna
│   ├── PenggunaMGR.java      # Implementasi manajemen pengguna
│   └── LibrarySystem.java    # Class utama sistem perpustakaan
└── README.md
```

## Cara Menjalankan

1. Pastikan Java Development Kit (JDK) sudah terinstal di sistem Anda
2. Kompilasi semua file Java:
   ```bash
   javac *.java
   ```
3. Jalankan program:
   ```bash
   java LibrarySystem
   ```

## Penggunaan

Setelah menjalankan program, Anda akan melihat menu interaktif dengan opsi berikut:

1. **Pinjam Buku**
   - Masukkan ID Pengguna
   - Masukkan ID Buku yang ingin dipinjam

2. **Kembalikan Buku**
   - Masukkan ID Pengguna
   - Masukkan ID Buku yang ingin dikembalikan

3. **Cari Buku berdasarkan Judul**
   - Masukkan kata kunci judul buku

4. **Cari Buku berdasarkan Penulis**
   - Masukkan nama penulis

5. **Lihat Buku Tersedia**
   - Menampilkan semua buku yang tersedia

6. **Keluar**
   - Mengakhiri program

## Data Demo

Sistem ini dilengkapi dengan beberapa data buku demo:

| ID    | Judul            | Penulis      | Penerbit    | Tahun |
|-------|------------------|--------------|-------------|-------|
| B001  | Java Programming | John Doe     | Tech Press  | 2020  |
| B002  | Python Basics    | Jane Smith   | Code Books  | 2021  |
| B003  | Data Structures  | Bob Johnson  | Tech Press  | 2019  |
| B004  | Algorithms       | Alice Brown  | Code Books  | 2022  |

## Validasi

Sistem memiliki beberapa validasi:

- **Peminjaman Buku:**
  - ID Pengguna harus valid
  - Buku harus tersedia
  - Status buku harus "Tersedia"

- **Pengembalian Buku:**
  - ID Pengguna harus valid
  - Buku harus dalam status "Dipinjam"
  - Pengguna harus memiliki catatan peminjaman buku tersebut

## Status Buku

Buku dapat memiliki status berikut:
- Tersedia
- Dipinjam
- Dipesan
- Rusak

## Pengembangan

Sistem ini mengimplementasikan Object Constraint Language (OCL) untuk memastikan integritas data dan operasi yang valid. Beberapa constraint yang diimplementasikan:

- Validasi ID buku
- Validasi status buku
- Pengecekan ketersediaan buku
- Validasi informasi buku baru
- Validasi operasi pembaruan buku 