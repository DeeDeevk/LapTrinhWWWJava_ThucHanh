package iuh.fit.nguyenhovietkhoa_tuan5_bai6.model;

public class TinTuc {
    private Integer matt;
    private String tieuDe;
    private String noiDung;
    private String lienKet;
    private Integer madm;

    public TinTuc() {}

    public TinTuc(Integer matt, String tieuDe, String noiDung, String lienKet, Integer madm) {
        this.matt = matt;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.lienKet = lienKet;
        this.madm = madm;
    }

    public Integer getMatt() { return matt; }
    public void setMatt(Integer matt) { this.matt = matt; }
    public String getTieuDe() { return tieuDe; }
    public void setTieuDe(String tieuDe) { this.tieuDe = tieuDe; }
    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }
    public String getLienKet() { return lienKet; }
    public void setLienKet(String lienKet) { this.lienKet = lienKet; }
    public Integer getMadm() { return madm; }
    public void setMadm(Integer madm) { this.madm = madm; }
}
