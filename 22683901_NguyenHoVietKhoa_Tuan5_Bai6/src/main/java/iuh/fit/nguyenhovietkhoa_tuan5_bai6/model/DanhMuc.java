package iuh.fit.nguyenhovietkhoa_tuan5_bai6.model;

public class DanhMuc {
    private Integer madm;
    private String tenDanhMuc;
    private String nguoiQuanLy;
    private String ghiChu;

    public DanhMuc() {}

    public DanhMuc(Integer madm, String tenDanhMuc, String nguoiQuanLy, String ghiChu) {
        this.madm = madm;
        this.tenDanhMuc = tenDanhMuc;
        this.nguoiQuanLy = nguoiQuanLy;
        this.ghiChu = ghiChu;
    }

    public Integer getMadm() { return madm; }
    public void setMadm(Integer madm) { this.madm = madm; }
    public String getTenDanhMuc() { return tenDanhMuc; }
    public void setTenDanhMuc(String tenDanhMuc) { this.tenDanhMuc = tenDanhMuc; }
    public String getNguoiQuanLy() { return nguoiQuanLy; }
    public void setNguoiQuanLy(String nguoiQuanLy) { this.nguoiQuanLy = nguoiQuanLy; }
    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}
