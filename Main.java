import java.util.Scanner;
import java.util.ArrayList;
class hinh{
    protected String color;
    public hinh(String color){
        this.color = color;
    }
    public String getcolor(){
        return color;
    }
    public void setcolor(String color){
        this.color = color;
    }
}
class hinhchunhat extends hinh{
    private float cd, cr;
    public hinhchunhat(String color, float cd, float cr){
        super(color);
        this.cd = cd;
        this.cr = cr;
    }
    public float getcd(){
        return cd;
    }
    public void setcd(float cd){
        this.cd = cd;
    }
    public float getcr(){
        return cr;
    }
    public void setcr(float cr){
        this.cr = cr;
    }
    public double dientich(){
        double dt;
        dt = cd * cr;
        return dt;
    }
    public String toString(){
        return "Hinhchunhat[Mausac=" + color + "," + "Chieudai=" + cd + "," + 
                "Chieurong=" + cr + "," + "Dientich=" + dientich() +"]";
    }
}
class hinhtron extends hinh{
    private float r;
    public hinhtron(String color, float r){
        super(color);
        this.r = r;
    }
    public float getr(){
        return r;
    }
    public void setr(){
        this.r = r;
    }
    public double dientich(){
        double dt ;
        dt = r*r*3.14;
        return dt;
    }
    public String toString(){
        return "Hinhtron[Mausac=" + color + "," + "Bankinh=" + r + "," + "Dientich=" + dientich() +"]";
    }
}
class danhsachhinh{
    ArrayList<hinh> listhinh;
    Scanner input;
    hinh h;
    int chon;
    public danhsachhinh(){
        listhinh = new ArrayList<>();
        input = new Scanner(System.in);
    }
    public void nhap(int n){
        for(int i = 0 ; i < n ; i++){
            System.out.println("1: Nhap hinh tron");
            System.out.println("2: Nhap hinh chu nhat");
            System.out.println("0: Thoat");
            chon = input.nextInt();
            switch(chon){
            case 1:
            {
                String color;
                float r;
                System.out.println("Nhap mau sac: ");
                input.nextLine();
                color = input.nextLine();
                System.out.println("Nhap ban kinh: ");
                r = input.nextFloat();
                h = new hinhtron(color, r);
                listhinh.add(h);
                System.out.println("Them hinh tron thanh cong");
            }
                break;

            case 2:
            {
                String color;
                float cd, cr;
                System.out.println("Nhap mau sac: ");
                input.nextLine();
                color = input.nextLine();
                System.out.println("Nhap chieu dai: ");
                cd = input.nextFloat();
                System.out.println("Nhap chieu rong; ");
                cr = input.nextFloat();
                h = new hinhchunhat(color, cd, cr);
                listhinh.add(h);
                System.out.println("Them hinh chu nhat thanh cong");
            }
                break;

            default:
                break;
            }
        }
    }
    public void inds(){
        for(hinh h : listhinh){
            System.out.println(h.toString());
        }
    }
}
class Main{
    public static void main(String[]args){
        danhsachhinh ds = new danhsachhinh();
        ds.nhap(2);
        ds.inds();
    }
}