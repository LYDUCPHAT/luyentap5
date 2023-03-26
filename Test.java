import java.util.Scanner;
import java.util.ArrayList;
class chuyenxe{
    private String maso, tentaixe, soxe;
    private double doanhthu;
    public chuyenxe(String maso, String tentaixe, String soxe, double doanhthu){
        /*super();*/
        this.maso = maso;
        this.tentaixe = tentaixe;
        this.soxe = soxe;
        this.doanhthu = doanhthu;
    }
    public String getmaso(){
        return maso;
    }
    public void setmaso(String maso){
        this.maso = maso;
    }
    public String gettentaixe(){
        return tentaixe;
    }
    public void settentaixe(String tentaixe){
        this.tentaixe = tentaixe;
    }
    public String getsoxe(){
        return soxe;
    }
    public void setsoxe(String soxe){
        this.soxe = soxe;
    }
    public double getdoanhthu(){
        return doanhthu;
    }
    public void setdoanhthu(double doanhthu){
        this.doanhthu = doanhthu;
    }
    public String toString(){
        return "Chuyenxe [Maso=" + maso + "," + "Tentaixe=" + tentaixe + ","
                + "Soxe=" + soxe + "," + "Doanhthu=" + doanhthu + "]";
    }
}
class chuyenxenoithanh extends chuyenxe{
    private int sotuyen, sokmdidc;
    public chuyenxenoithanh(String maso, String tentaixe, String soxe, double doanhthu,
            int sotuyen, int sokmdidc){
        super(maso, tentaixe, soxe, doanhthu);
        this.sotuyen = sotuyen;
        this.sokmdidc = sokmdidc;
    }
    public int getsotuyen(){
        return sotuyen;
    }
    public void setsotuyen(int sotuyen){
        this.sotuyen = sotuyen;
    }
    public int getsokmdidc(){
        return sokmdidc;
    }
    public void setsokmdidc(int sokmdidc){
        this.sokmdidc = sokmdidc;
    }
    public String toString(){
        return super.toString() + "Chuyenxenoithanh[sotuyen=" + sotuyen +
                "," + "sokmdidc=" + sokmdidc +"]";
    }
}
class chuyenxengoaithanh extends chuyenxe{
    private String noiden;
    private int songaydidc;
    public chuyenxengoaithanh(String maso, String tentaixe, String soxe, double doanhthu,
            String noiden, int songaydidc){
        super(maso, tentaixe, soxe, doanhthu);
        this.noiden = noiden;
        this.songaydidc = songaydidc;
    }
    public String getnoiden(){
        return noiden;
    }
    public void setnoiden(String noiden){
        this.noiden = noiden;
    }
    public int getsongaydidc(){
        return songaydidc;
    }
    public void setsongaydidc(int songaydidc){
        this.songaydidc = songaydidc;
    }
    public String toString(){
        return super.toString() + "Chuyenxengoaithanh[noiden=" + noiden + "," +
                "songaydidc=" + songaydidc + "]";
    }
}
class quanlychuyenxe{
    ArrayList<chuyenxe> listchuyenxe;
    Scanner input;
    chuyenxe cx;
    int chon;
    public quanlychuyenxe(){
        /*super();*/
        listchuyenxe = new ArrayList<>();
        input = new Scanner(System.in);
    }
    public void nhap(int n){
        for(int i = 0 ; i < n ; i++){
            System.out.println("1: Chuyen xe noi thanh");
            System.out.println("2: Chuyen xe ngoai thanh");
            System.out.println("0: Thoat");
            chon = input.nextInt();
            switch(chon){
            case 1:
            {
                String maso;
                String tentaixe;
                String soxe;
                double doanhthu;
                int sotuyen;
                int sokmdidc;
                System.out.println("Nhap ma so: ");
                input.nextLine();
                maso = input.nextLine();
                System.out.println("Nhap ten tai xe: ");
                tentaixe = input.nextLine();
                System.out.println("Nhap so xe: ");
                soxe = input.nextLine();
                System.out.println("Nhap doanh thu: ");
                doanhthu = input.nextDouble();
                System.out.println("Nhap so tuyen: ");
                sotuyen = input.nextInt();
                System.out.println("Nhap so km di dc: ");
                sokmdidc = input.nextInt();
                chuyenxe cx = new chuyenxenoithanh(maso, tentaixe, soxe, doanhthu, sotuyen, sokmdidc);
                listchuyenxe.add(cx);
                System.out.println("them thanh cong chuyen xe noi thanh");
            }
                break;

            case 2:
            {
                String maso;
                String tentaixe;
                String soxe;
                double doanhthu;
                String noiden;
                int songaydidc;
                System.out.println("Nhap ma so: ");
                input.nextLine();
                maso = input.nextLine();
                System.out.println("Nhap ten tai xe: ");
                tentaixe = input.nextLine();
                System.out.println("Nhap so xe: ");
                soxe = input.nextLine();
                System.out.println("Nhap doanh thu: ");
                doanhthu = input.nextDouble();
                System.out.println("Nhap noi den: ");
                input.nextLine();
                noiden = input.nextLine();
                System.out.println("Nhap so ngay di dc: ");
                songaydidc = input.nextInt();
                chuyenxe cx = new chuyenxengoaithanh(maso, tentaixe, soxe, doanhthu, noiden, songaydidc);
                listchuyenxe.add(cx);
                System.out.println("them thanh cong chuyen xe ngoai thanh");
            }
                break;

            default:
                break;
            }
        }
    }
    public void xuat(){
        for(chuyenxe cx : listchuyenxe){
            System.out.println(cx.toString());
        }
    }
    public void tongdoanhthutungloai(){
        double doanhthunoithanh = 0, doanhthungoaithanh = 0;
        double tongdoanhthu;
        for(chuyenxe cx : listchuyenxe){
            if(cx instanceof chuyenxenoithanh){
                doanhthunoithanh += cx.getdoanhthu();
            }
            if(cx instanceof chuyenxengoaithanh){
                doanhthungoaithanh += cx.getdoanhthu();
            }
        }
        tongdoanhthu = doanhthunoithanh + doanhthungoaithanh;
        System.out.println("Tong doanh thu chuyen xe noi thanh: "+doanhthunoithanh);
        System.out.println("Tong doanh thu chuyen xe ngoai thanh: "+doanhthungoaithanh);
        System.out.println("Tong doanh thu hai chuyen: "+tongdoanhthu);
    }
}
class Test{
    public static void main(String[]args){
        quanlychuyenxe qlcx = new quanlychuyenxe();
        qlcx.nhap(3);
        qlcx.xuat();
        qlcx.tongdoanhthutungloai();
    }
}
