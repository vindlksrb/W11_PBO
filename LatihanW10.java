import java.util.Scanner;

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

class LoanPeriodExceededException extends Exception {
    public LoanPeriodExceededException(String message) {
        super(message);
    }
}

class LatihanW10 {
    static String[] daftarBuku = {"B001", "B002", "B003"};

    public static void validasiIDBuku(String id) throws BookNotFoundException {
        boolean valid = false;
        for (String buku : daftarBuku) {
            if (buku.equalsIgnoreCase(id)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new BookNotFoundException("ID Buku tidak ditemukan: " + id);
        }
    }

    public static void validasiLamaPinjam(int hari) throws LoanPeriodExceededException {
        if (hari > 14) {
            throw new LoanPeriodExceededException("Lama pinjam melebihi batas maksimum 14 hari.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan nama pengguna: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan ID buku: ");
            String idBuku = scanner.nextLine();
            validasiIDBuku(idBuku);

            System.out.print("Masukkan lama peminjaman (hari): ");
            int lamaPinjam = scanner.nextInt();
            validasiLamaPinjam(lamaPinjam);

            System.out.println("\nPeminjaman berhasil!");
            System.out.println("Nama Peminjam: " + nama);
            System.out.println("ID Buku: " + idBuku);
            System.out.println("Lama Pinjam: " + lamaPinjam + " hari");

        } catch (BookNotFoundException | LoanPeriodExceededException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Input tidak valid. Pastikan Anda memasukkan data dengan benar.");
        } finally {
            scanner.close();
            System.out.println("Program selesai. Terima kasih.");
        }
    }
}
