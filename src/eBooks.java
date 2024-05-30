public class eBooks extends Book {

    private double kichThuocTep;
    private String dinhDangTep;

    eBooks(String maSach, String tieuDeSach, String tacGia, int namXuatBan, String theLoai, double kichThuocTep, String dinhDangTep) {
        super(maSach, tieuDeSach, tacGia, namXuatBan, theLoai);
        this.kichThuocTep = kichThuocTep;
        this.dinhDangTep = dinhDangTep;
    }

    public eBooks() {

    }

    public double getKichThuocTep() {
        return kichThuocTep;
    }

    public void setKichThuocTep(double kichThuocTep) {
        this.kichThuocTep = kichThuocTep;
    }

    public String getDinhDangTep() {
        return dinhDangTep;
    }

    public void setDinhDangTep(String dinhDangTep) {
        this.dinhDangTep = dinhDangTep;
    }

    @Override
    public String toString() {
        return "eBooks{ " +
                "BookCode = " + getMaSach() +
                ", BookTitle = " + getTieuDeSach() +
                ", Author = '" + getTacGia() + '\'' +
                ", PublishingYear = " + getNamXuatBan() +
                ", Category = '" + getTheLoai() + '\'' +
                ", FileSize = " + kichThuocTep +
                ", FileFormat = '" + dinhDangTep + '\'' +
                '}';
    }
}
