public class Book {
    private String maSach;
    private String tieuDeSach;
    private String tacGia;
    private int namXuatBan;
    private String theLoai;

    public Book() {
    }

    public Book(String maSach, String tieuDeSach, String tacGia, int namXuatBan, String theLoai) {
        this.maSach = maSach;
        this.tieuDeSach = tieuDeSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.theLoai = theLoai;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTieuDeSach() {
        return tieuDeSach;
    }

    public void setTieuDeSach(String tieuDeSach) {
        this.tieuDeSach = tieuDeSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookCode =" + maSach +
                ", BookTitle=" + tieuDeSach +
                ", Author='" + tacGia + '\'' +
                ", PublishingYear=" + namXuatBan +
                ", Category='" + theLoai + '\'' +
                '}';
    }
}
