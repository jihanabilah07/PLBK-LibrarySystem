public interface IPenggunaMGR {
    /**
     * Memvalidasi apakah pengguna valid
     * @param idUser ID pengguna yang akan divalidasi
     * @return true jika pengguna valid, false jika tidak
     */
    boolean validasiPengguna(String idUser);

    /**
     * Memvalidasi apakah pengguna dapat mengembalikan buku tertentu
     * @param idUser ID pengguna
     * @param idBuku ID buku yang akan dikembalikan
     * @return true jika pengguna dapat mengembalikan buku tersebut, false jika tidak
     */
    boolean validasiPengembalian(String idUser, String idBuku);
} 