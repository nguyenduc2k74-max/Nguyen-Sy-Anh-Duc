import java.util.ArrayList;
import java.util.Scanner;

class SachT6 {
    private String maSach;
    private String tenSach;
    private double gia;
    private int soLuong;

    public SachT6(String maSach, String tenSach, double gia, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }

    public String getTenSach() { return tenSach; }
    public void setTenSach(String tenSach) { this.tenSach = tenSach; }

    public double getGia() { return gia; }
    public void setGia(double gia) { this.gia = gia; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public void hienThiThongTin() {
        System.out.println("Mã sách: " + maSach + " | Tên sách: " + tenSach + " | Giá: " + gia + " | Số lượng: " + soLuong);
    }
}

public class QuanLyThuVienTuan6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SachT6> danhSachSach = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- QUẢN LÝ THƯ VIỆN - TUẦN 6 ---");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Tìm kiếm sách theo mã");
            System.out.println("4. Xóa sách theo mã");
            System.out.println("5. Sửa thông tin sách theo mã");
            System.out.println("6. Tính tổng số lượng sách");
            System.out.println("7. Tính tổng giá trị sách trong thư viện");
            System.out.println("8. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã sách: ");
                    String maSach = scanner.nextLine();
                    System.out.print("Nhập tên sách: ");
                    String tenSach = scanner.nextLine();
                    System.out.print("Nhập giá sách: ");
                    double gia = scanner.nextDouble();
                    System.out.print("Nhập số lượng sách: ");
                    int soLuong = scanner.nextInt();
                    scanner.nextLine();

                    danhSachSach.add(new SachT6(maSach, tenSach, gia, soLuong));
                    System.out.println("-> Thêm sách thành công!");
                    break;

                case 2:
                    System.out.println("\n--- DANH SÁCH SÁCH TRONG THƯ VIỆN ---");
                    if (danhSachSach.isEmpty()) {
                        System.out.println("Thư viện hiện chưa có sách nào!");
                    } else {
                        for (SachT6 s : danhSachSach) {
                            s.hienThiThongTin();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTim = scanner.nextLine();
                    boolean found = false;
                    for (SachT6 s : danhSachSach) {
                        if (s.getMaSach().equalsIgnoreCase(maTim)) {
                            s.hienThiThongTin();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("-> Không tìm thấy mã sách này!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = scanner.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < danhSachSach.size(); i++) {
                        if (danhSachSach.get(i).getMaSach().equalsIgnoreCase(maXoa)) {
                            danhSachSach.remove(i);
                            removed = true;
                            System.out.println("-> Xóa sách thành công!");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("-> Không tìm thấy mã sách để xóa!");
                    }
                    break;

                case 5:
                    System.out.print("Nhập mã sách cần sửa: ");
                    String maSua = scanner.nextLine();
                    boolean edited = false;
                    for (SachT6 s : danhSachSach) {
                        if (s.getMaSach().equalsIgnoreCase(maSua)) {
                            System.out.print("Nhập tên sách mới: ");
                            s.setTenSach(scanner.nextLine());
                            System.out.print("Nhập giá mới: ");
                            s.setGia(scanner.nextDouble());
                            System.out.print("Nhập số lượng mới: ");
                            s.setSoLuong(scanner.nextInt());
                            scanner.nextLine();

                            System.out.println("-> Cập nhật thông tin thành công!");
                            edited = true;
                            break;
                        }
                    }
                    if (!edited) {
                        System.out.println("-> Không tìm thấy mã sách cần sửa!");
                    }
                    break;

                case 6:
                    int tongSoLuong = 0;
                    for (SachT6 s : danhSachSach) {
                        tongSoLuong += s.getSoLuong();
                    }
                    System.out.println("-> Tổng số lượng sách trong thư viện: " + tongSoLuong);
                    break;

                case 7:
                    double tongGiaTri = 0;
                    for (SachT6 s : danhSachSach) {
                        tongGiaTri += s.getGia() * s.getSoLuong();
                    }
                    System.out.println("-> Tổng giá trị kho sách: " + tongGiaTri);
                    break;

                case 8:
                    System.out.println("-> Thoát chương trình!");
                    break;

                default:
                    System.out.println("-> Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 8.");
                    break;
            }
        } while (choice != 8);

        scanner.close();
    }
}