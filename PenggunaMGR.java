import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PenggunaMGR implements IPenggunaMGR {
    private Map<String, Set<String>> peminjamanAktif; // Map dari idUser ke Set dari idBuku yang dipinjam

    public PenggunaMGR() {
        this.peminjamanAktif = new HashMap<>();
    }

    @Override
    public boolean validasiPengguna(String idUser) {
        // Untuk demo, kita anggap semua ID yang tidak null dan tidak kosong adalah valid
        return idUser != null && !idUser.trim().isEmpty();
    }

    @Override
    public boolean validasiPengembalian(String idUser, String idBuku) {
        // Validasi dasar
        if (!validasiPengguna(idUser) || idBuku == null || idBuku.trim().isEmpty()) {
            return false;
        }

        // Cek apakah pengguna memiliki peminjaman aktif
        Set<String> bukuDipinjam = peminjamanAktif.get(idUser);
        if (bukuDipinjam == null) {
            return false;
        }

        // Cek apakah buku yang akan dikembalikan memang dipinjam oleh pengguna
        return bukuDipinjam.contains(idBuku);
    }

    // Method tambahan untuk mencatat peminjaman
    public void catatPeminjaman(String idUser, String idBuku) {
        peminjamanAktif.computeIfAbsent(idUser, k -> new HashSet<>()).add(idBuku);
    }

    // Method tambahan untuk mencatat pengembalian
    public void catatPengembalian(String idUser, String idBuku) {
        Set<String> bukuDipinjam = peminjamanAktif.get(idUser);
        if (bukuDipinjam != null) {
            bukuDipinjam.remove(idBuku);
            if (bukuDipinjam.isEmpty()) {
                peminjamanAktif.remove(idUser);
            }
        }
    }
} 