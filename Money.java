import java.util.Scanner;
import java.util.ArrayList;
class giaodich{
    private String magiaodich;
    protected int ngaygiaodich, dongia, soluong;
    public giaodich(String magiaodich, int ngaygiaodich, int dongia, int soluong){
        this.magiaodich = magiaodich;
        this.ngaygiaodich = ngaygiaodich;
        this.dongia = dongia;
        this.soluong = soluong;
    }
    public String getmagiaodich(){
        return magiaodich;
    }
    public void setmagiaodich(String magiaodich){
        this.magiaodich = magiaodich;
    }
    public int getngaygiaodich(){
        return ngaygiaodich;
    }
    public void setngaygiaodich(int ngaygiaodich){
        this.ngaygiaodich = ngaygiaodich;
    }
    public int getdongia(){
        return dongia;
    }
    public void setdongia(int dongia){
        this.dongia = dongia;
    }
    public int getsoluong(){
        return soluong;
    }
    public void setsoluong(int soluong){
        this.soluong = soluong;
    }
    public String toString(){
        return "Giaodich [Magiaodich=" + magiaodich + ", Ngaygiaodich=" + ngaygiaodich
                + ", Dongia=" + dongia + ", Soluong=" + soluong +"]";
    }
}
class vang extends giaodich{
    private String loaivang;
    public vang(String magiaodich, int ngaygiaodich, int dongia, int soluong, String loaivang){
        super(magiaodich, ngaygiaodich, dongia, soluong);
        this.loaivang = loaivang;
    }
    public String getloaivang(){
        return loaivang;
    }
    public void setloaivang(String loaivang){
        this.loaivang = loaivang;
    }
    public int thanhtien(){
        int tien;
        tien = soluong * dongia;
        return tien;
    }
    public String toString(){
        return super.toString() + "Giaodichvang [Loaivang=" + loaivang +
                ", Thanhtien=" + thanhtien() +"]"; 
    }
}
class tiente extends giaodich{
    private float tigia;
    public tiente(String magiaodich, int ngaygiaodich, int dongia, int soluong, float tigia){
        super(magiaodich, ngaygiaodich, dongia, soluong);
        this.tigia = tigia;
    }
    public float gettigia(){
        return tigia;
    }
    public void settigia(float tigia){
        this.tigia = tigia;
    }
    public float dola(){
        float usd;
        usd = soluong * dongia * tigia;
        return usd;
    }
    public float euro(){
        float euro;
        euro = soluong * dongia * tigia;
        return euro;
    }
    public float vndong(){
        float dong;
        dong = soluong * dongia;
        return dong;
    }
    public String toString(){
        return super.toString() + "Giaodichtien [Tigia=" + tigia + ", Dola=" + dola()
                + ", Euro=" + euro() + ", VNdong=" + vndong() +"]"; 
    }
}
class dsgiaodich{
    ArrayList<giaodich> listgiaodich;
    Scanner input;
    giaodich gd;
    int chon;
    public dsgiaodich(){
        listgiaodich = new ArrayList<>();
        input = new Scanner(System.in);
    }
    public void nhap(int n){
        for(int i = 0 ; i < n ; i++){
            System.out.println("1: Giao dich vang");
            System.out.println("2: Giao dich tien te");
            System.out.println("0: Thoat");
            chon = input.nextInt();
            switch(chon){
            case 1:
            {
                String magiaodich;
                int ngaygiaodich;
                int dongia;
                int soluong;
                String loaivang;
                System.out.println("Nhap ma giao dich: ");
                input.nextLine();
                magiaodich = input.nextLine();
                System.out.println("Nhap ngay giao dich: ");
                ngaygiaodich = input.nextInt();
                System.out.println("Nhap don gia: ");
                dongia = input.nextInt();
                System.out.println("Nhap so luong: ");
                soluong = input.nextInt();
                System.out.println("Nhap loai vang: ");
                input.nextLine();
                loaivang = input.nextLine();
                gd = new vang(magiaodich, ngaygiaodich, dongia, soluong, loaivang);
                listgiaodich.add(gd);
                System.out.println("Giao dich vang thanh cong");
            }
                break;

            case 2:
            {
                String magiaodich;
                int ngaygiaodich;
                int dongia;
                int soluong;
                float tigia;
                System.out.println("Nhap ma giao dich: ");
                input.nextLine();
                magiaodich = input.nextLine();
                System.out.println("Nhap ngay giao dich: ");
                ngaygiaodich = input.nextInt();
                System.out.println("Nhap don gia: ");
                dongia = input.nextInt();
                System.out.println("Nhap so luong: ");
                soluong = input.nextInt();
                System.out.println("Nhap ti gia: ");
                tigia = input.nextFloat();
                gd = new tiente(magiaodich, ngaygiaodich, dongia, soluong, tigia);
                listgiaodich.add(gd);
                System.out.println("Giao dich tien te thanh cong");
            }
                break;
            
            default:
                break;
            }
        }
    }
    public void inds(){
        for(giaodich gd : listgiaodich){
            System.out.println(gd.toString());
        }
    }
    public void tongsoluong(){
        int soluongvang = 0, soluongtien = 0;
        for(giaodich gd : listgiaodich){
            if(gd instanceof vang){
                soluongvang += gd.getsoluong();
            }
            if(gd instanceof tiente){
                soluongtien += gd.getsoluong();
            }
        }
        System.out.println("Tong so luong vang: "+soluongvang);
        System.out.println("Tong so luong tien: "+soluongtien);
    }
    public void inds1(){
        for(giaodich gd : listgiaodich){
            if(gd.getdongia() > 1000000000){
                System.out.println("Don gia > 1 ty:");
                System.out.println(gd.toString());
            }
        }
    }
}
class Money{
    public static void main(String[]args){
        dsgiaodich dsgd = new dsgiaodich();
        dsgd.nhap(3);
        dsgd.inds();
        dsgd.tongsoluong();
        dsgd.inds1();
    }
}