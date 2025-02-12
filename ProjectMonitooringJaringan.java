package projectmonitooringjaringan;
import java.util.Scanner;

public class ProjectMonitooringJaringan {

    static String[][] perangkatJaringan = {
        {"PC-1", "192.168.1.2", "Aktif"},
        {"PC-2", "192.168.1.3", "Tidak Aktif"},
        {"Server", "192.168.1.10", "Aktif"},
        {"Router", "192.168.1.1", "Aktif"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Lihat Daftar Perangkat");
            System.out.println("2. Cari Perangkat");
            System.out.println("3. Deteksi Perangkat Tidak Aktif");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan (1-4): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            if (pilihan == 1) {
                tampilkanPerangkat();
            } else if (pilihan == 2) {
                cariPerangkat(scanner);
            } else if (pilihan == 3) {
                deteksiTidakAktif();
            } else if (pilihan == 4) {
                System.out.println("Keluar dari program.");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }

    public static void tampilkanPerangkat() {
        System.out.println("\nDaftar Perangkat:");
        for (String[] perangkat : perangkatJaringan) {
            System.out.println("Nama: " + perangkat[0] + ", IP: " + perangkat[1] + ", Status: " + perangkat[2]);
        }
    }

    public static void cariPerangkat(Scanner scanner) {
        System.out.print("\nMasukkan nama atau IP perangkat: ");
        String keyword = scanner.nextLine();
        boolean ditemukan = false;

        System.out.println("\nHasil pencarian:");
        for (String[] perangkat : perangkatJaringan) {
            if (perangkat[0].contains(keyword) || perangkat[1].contains(keyword)) {
                System.out.println("Nama: " + perangkat[0] + ", IP: " + perangkat[1] + ", Status: " + perangkat[2]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Perangkat tidak ditemukan.");
        }
    }

    public static void deteksiTidakAktif() {
        System.out.println("\nPerangkat Tidak Aktif:");
        boolean adaTidakAktif = false;

        for (String[] perangkat : perangkatJaringan) {
            if ("Tidak Aktif".equals(perangkat[2])) {
                System.out.println("Nama: " + perangkat[0] + ", IP: " + perangkat[1]);
                adaTidakAktif = true;
            }
        }

        if (!adaTidakAktif) {
            System.out.println("Semua perangkat aktif.");
        }
    }
}