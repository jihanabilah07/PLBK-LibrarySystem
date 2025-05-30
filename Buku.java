public class Buku {
    private String id;
    private String judul;
    private String penulis;
    private String penerbit;
    private int tahunTerbit;
    private String status;

    public Buku(String id, String judul, String penulis, String penerbit, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.status = "Tersedia"; // Default status
    }

    // Getters
    public String getId() { return id; }
    public String getJudul() { return judul; }
    public String getPenulis() { return penulis; }
    public String getPenerbit() { return penerbit; }
    public int getTahunTerbit() { return tahunTerbit; }
    public String getStatus() { return status; }

    // Setters
    public void setJudul(String judul) { this.judul = judul; }
    public void setPenulis(String penulis) { this.penulis = penulis; }
    public void setPenerbit(String penerbit) { this.penerbit = penerbit; }
    public void setTahunTerbit(int tahunTerbit) { this.tahunTerbit = tahunTerbit; }
    public void setStatus(String status) { this.status = status; }
} 