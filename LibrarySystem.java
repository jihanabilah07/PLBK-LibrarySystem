/**
 * Class LibrarySystem
 * Komponen: Main Component
 * Deskripsi: Komponen utama yang mengoordinasikan seluruh sistem
 */
import java.util.Scanner;
import java.util.Set;

public class LibrarySystem {
    private IPenggunaMGR penggunaMGR;
    private IBukuMGR bukuMGR;

    public LibrarySystem() {
        this.penggunaMGR = new PenggunaMGR();
        this.bukuMGR = new BukuMGR();
    }

    public boolean pinjamBuku(String idUser, String idBuku) {
        // Validasi pengguna
        if (!penggunaMGR.validasiPengguna(idUser)) {
            System.out.println("Validasi pengguna gagal");
            return false;
        }

        // Cek ketersediaan buku
        if (!bukuMGR.cekKetersediaanBuku(idBuku)) {
            System.out.println("Buku tidak tersedia");
            return false;
        }

        // Update status buku menjadi "Dipinjam"
        if (!bukuMGR.updateStatusBuku(idBuku, "Dipinjam")) {
            System.out.println("Gagal memperbarui status buku");
            return false;
        }

        // Catat peminjaman
        ((PenggunaMGR) penggunaMGR).catatPeminjaman(idUser, idBuku);
        System.out.println("Peminjaman buku berhasil");
        return true;
    }

    public boolean kembalikanBuku(String idUser, String idBuku) {
        // Validasi pengembalian
        if (!penggunaMGR.validasiPengembalian(idUser, idBuku)) {
            System.out.println("Validasi pengembalian gagal");
            return false;
        }

        // Update status buku menjadi "Tersedia"
        if (!bukuMGR.updateStatusBuku(idBuku, "Tersedia")) {
            System.out.println("Gagal memperbarui status buku");
            return false;
        }

        // Catat pengembalian
        ((PenggunaMGR) penggunaMGR).catatPengembalian(idUser, idBuku);
        System.out.println("Pengembalian buku berhasil");
        return true;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Tambahkan beberapa buku untuk demo
        initializeDemoBooks();

        while (running) {
            System.out.println("\n==================================");
            System.out.println("         LIBRARY SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Kembalikan Buku");
            System.out.println("3. Cari Buku berdasarkan Judul");
            System.out.println("4. Cari Buku berdasarkan Penulis");
            System.out.println("5. Lihat Buku Tersedia");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handlePeminjamanBuku(scanner);
                    break;
                case "2":
                    handlePengembalianBuku(scanner);
                    break;
                case "3":
                    handleCariBukuByJudul(scanner);
                    break;
                case "4":
                    handleCariBukuByPenulis(scanner);
                    break;
                case "5":
                    handleLihatBukuTersedia();
                    break;
                case "6":
                    running = false;
                    System.out.println("Terima kasih telah menggunakan Library System.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }

    private void initializeDemoBooks() {
        // Tambahkan beberapa buku untuk demo
        bukuMGR.tambahBuku(new Buku("B001", "Java Programming", "John Doe", "Tech Press", 2020));
        bukuMGR.tambahBuku(new Buku("B002", "Python Basics", "Jane Smith", "Code Books", 2021));
        bukuMGR.tambahBuku(new Buku("B003", "Data Structures", "Bob Johnson", "Tech Press", 2019));
        bukuMGR.tambahBuku(new Buku("B004", "Algorithms", "Alice Brown", "Code Books", 2022));
    }

    private void handlePeminjamanBuku(Scanner scanner) {
        System.out.println("\n--- PEMINJAMAN BUKU ---");
        System.out.print("Masukkan ID Pengguna: ");
        String idUser = scanner.nextLine();
        System.out.print("Masukkan ID Buku: ");
        String idBuku = scanner.nextLine();

        if (pinjamBuku(idUser, idBuku)) {
            System.out.println("Buku berhasil dipinjam!");
        }
        
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    private void handlePengembalianBuku(Scanner scanner) {
        System.out.println("\n--- PENGEMBALIAN BUKU ---");
        System.out.print("Masukkan ID Pengguna: ");
        String idUser = scanner.nextLine();
        System.out.print("Masukkan ID Buku: ");
        String idBuku = scanner.nextLine();

        if (kembalikanBuku(idUser, idBuku)) {
            System.out.println("Buku berhasil dikembalikan!");
        }

        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    private void handleCariBukuByJudul(Scanner scanner) {
        System.out.println("\n--- CARI BUKU BERDASARKAN JUDUL ---");
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();

        Set<Buku> hasilPencarian = bukuMGR.cariBukuByJudul(judul);
        if (hasilPencarian.isEmpty()) {
            System.out.println("Tidak ditemukan buku dengan judul tersebut.");
        } else {
            System.out.println("\nHasil Pencarian:");
            for (Buku buku : hasilPencarian) {
                System.out.println("ID: " + buku.getId());
                System.out.println("Judul: " + buku.getJudul());
                System.out.println("Penulis: " + buku.getPenulis());
                System.out.println("Status: " + buku.getStatus());
                System.out.println("--------------------");
            }
        }

        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    private void handleCariBukuByPenulis(Scanner scanner) {
        System.out.println("\n--- CARI BUKU BERDASARKAN PENULIS ---");
        System.out.print("Masukkan nama penulis: ");
        String penulis = scanner.nextLine();

        Set<Buku> hasilPencarian = bukuMGR.cariBukuByPenulis(penulis);
        if (hasilPencarian.isEmpty()) {
            System.out.println("Tidak ditemukan buku dari penulis tersebut.");
        } else {
            System.out.println("\nHasil Pencarian:");
            for (Buku buku : hasilPencarian) {
                System.out.println("ID: " + buku.getId());
                System.out.println("Judul: " + buku.getJudul());
                System.out.println("Penulis: " + buku.getPenulis());
                System.out.println("Status: " + buku.getStatus());
                System.out.println("--------------------");
            }
        }

        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }

    private void handleLihatBukuTersedia() {
        System.out.println("\n--- DAFTAR BUKU TERSEDIA ---");
        Set<Buku> bukuTersedia = bukuMGR.getBukuTersedia();
        if (bukuTersedia.isEmpty()) {
            System.out.println("Tidak ada buku yang tersedia saat ini.");
        } else {
            for (Buku buku : bukuTersedia) {
                System.out.println("ID: " + buku.getId());
                System.out.println("Judul: " + buku.getJudul());
                System.out.println("Penulis: " + buku.getPenulis());
                System.out.println("Penerbit: " + buku.getPenerbit());
                System.out.println("Tahun Terbit: " + buku.getTahunTerbit());
                System.out.println("--------------------");
            }
        }
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.start();
    }
}