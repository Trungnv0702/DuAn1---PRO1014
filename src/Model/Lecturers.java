package Model;

public class Lecturers {

    String maGiangVien, tenGiangVien, soDienThoai, diachi, email, matKhau, role;

    public Lecturers() {
    }

    public Lecturers(String maGiangVien, String tenGiangVien, String soDienThoai, String diachi, String email, String matKhau, String role) {
        this.maGiangVien = maGiangVien;
        this.tenGiangVien = tenGiangVien;
        this.soDienThoai = soDienThoai;
        this.diachi = diachi;
        this.email = email;
        this.matKhau = matKhau;
        this.role = role;
    }


    
    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}
