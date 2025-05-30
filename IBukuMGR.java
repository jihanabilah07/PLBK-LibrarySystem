import java.util.Set;

public interface IBukuMGR {
    boolean cekKetersediaanBuku(String idBuku);
    boolean updateStatusBuku(String idBuku, String status);
    boolean tambahBuku(Buku buku);
    Set<Buku> cariBukuByJudul(String judul);
    Set<Buku> cariBukuByPenulis(String penulis);
    boolean hapusBuku(String idBuku);
    Set<Buku> getBukuTersedia();
    Set<Buku> getBukuDipinjam();
    Buku getBukuById(String idBuku);
    boolean perbaruiBuku(String idBuku, Buku bukuBaru);
} 