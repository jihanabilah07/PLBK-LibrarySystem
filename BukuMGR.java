import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BukuMGR implements IBukuMGR {
    private Map<String, Buku> bukuList;
    private static final Set<String> VALID_STATUS = new HashSet<>(Set.of("Tersedia", "Dipinjam", "Dipesan", "Rusak"));

    public BukuMGR() {
        this.bukuList = new HashMap<>();
    }

    @Override
    public boolean cekKetersediaanBuku(String idBuku) {
        if (!bukuList.containsKey(idBuku)) {
            return false;
        }
        return bukuList.get(idBuku).getStatus().equals("Tersedia");
    }

    @Override
    public boolean updateStatusBuku(String idBuku, String status) {
        if (!bukuList.containsKey(idBuku) || !VALID_STATUS.contains(status)) {
            return false;
        }
        bukuList.get(idBuku).setStatus(status);
        return true;
    }

    @Override
    public boolean tambahBuku(Buku buku) {
        if (bukuList.containsKey(buku.getId()) ||
            buku.getJudul() == null || buku.getJudul().isEmpty() ||
            buku.getPenulis() == null || buku.getPenulis().isEmpty() ||
            buku.getPenerbit() == null ||
            buku.getTahunTerbit() <= 0) {
            return false;
        }
        bukuList.put(buku.getId(), buku);
        return true;
    }

    @Override
    public Set<Buku> cariBukuByJudul(String judul) {
        if (judul == null || judul.isEmpty()) {
            return new HashSet<>();
        }
        return bukuList.values().stream()
            .filter(b -> b.getJudul().toLowerCase().contains(judul.toLowerCase()))
            .collect(Collectors.toSet());
    }

    @Override
    public Set<Buku> cariBukuByPenulis(String penulis) {
        if (penulis == null || penulis.isEmpty()) {
            return new HashSet<>();
        }
        return bukuList.values().stream()
            .filter(b -> b.getPenulis().toLowerCase().contains(penulis.toLowerCase()))
            .collect(Collectors.toSet());
    }

    @Override
    public boolean hapusBuku(String idBuku) {
        if (!bukuList.containsKey(idBuku) || 
            bukuList.get(idBuku).getStatus().equals("Dipinjam")) {
            return false;
        }
        bukuList.remove(idBuku);
        return true;
    }

    @Override
    public Set<Buku> getBukuTersedia() {
        return bukuList.values().stream()
            .filter(b -> b.getStatus().equals("Tersedia"))
            .collect(Collectors.toSet());
    }

    @Override
    public Set<Buku> getBukuDipinjam() {
        return bukuList.values().stream()
            .filter(b -> b.getStatus().equals("Dipinjam"))
            .collect(Collectors.toSet());
    }

    @Override
    public Buku getBukuById(String idBuku) {
        return bukuList.get(idBuku);
    }

    @Override
    public boolean perbaruiBuku(String idBuku, Buku bukuBaru) {
        if (!bukuList.containsKey(idBuku) ||
            bukuBaru.getJudul() == null || bukuBaru.getJudul().isEmpty() ||
            bukuBaru.getPenulis() == null || bukuBaru.getPenulis().isEmpty() ||
            bukuBaru.getPenerbit() == null ||
            bukuBaru.getTahunTerbit() <= 0) {
            return false;
        }
        
        Buku bukuLama = bukuList.get(idBuku);
        bukuLama.setJudul(bukuBaru.getJudul());
        bukuLama.setPenulis(bukuBaru.getPenulis());
        bukuLama.setPenerbit(bukuBaru.getPenerbit());
        bukuLama.setTahunTerbit(bukuBaru.getTahunTerbit());
        return true;
    }
} 