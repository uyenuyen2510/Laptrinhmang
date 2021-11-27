/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinhVien;



import java.util.Scanner;

/**
 *
 * @author Duc Hieu IT
 */
public class Sinhvien {

    /**
     * @param args the command line arguments
     */
    static Scanner sc= new Scanner(System.in);
    static void Menu()
        {
            System.out.print("=================MENU================\n");
            System.out.print("1. Nhập!\n");
            System.out.print("2. Xuất!\n");
            System.out.print("3. Thêm!\n");
            System.out.print("4. Sửa!\n");
            System.out.print("5. Xóa!\n");
            System.out.print("6. Tìm Kiếm MSV!\n");
            System.out.print("7. Sắp xếp!\n");
            System.out.print("8. Thoat!!!\n");
            System.out.print("=====================================\n");
        }
        static int ChonMenu()
        {
            int chon = 0;
            System.out.print("\n\nChon menu: ");
            chon = sc.nextInt();
            if (chon > 0 || chon < 7)
                return chon;
            else return ChonMenu();
        }
    public static void main(String[] args) {
        // TODO code application logic here
        ListSV qlds=new ListSV();
        
        Menu();
            while (true)
            {
                int so = ChonMenu();
                switch (so)
                {
                    case 1:
                        int m; 
                        System.out.print("Nhap SL SV: ");
                        m= sc.nextInt();
                        
                                for (int i=0;i<m;i++)
                                {
                                    sv c=new sv(); 
                                    c.Nhap();
                                    qlds.addsv(c);
                                }
                                
                        break;
                    case 2:
                        System.out.printf("%1s %5s %5s %4s %5s\n","MSV","Ten","Nam","DC","Lop\n");
                        for(int i=0;i<qlds.dssv.size();i++){
                            qlds.dssv.get(i).Xuat();
                            System.out.println("");
                        }
                        break;

                    case 3:
                        System.out.println("Nhập TT cần thêm:");
                        sv c=new sv();
                        c.Nhap();
                        qlds.addsv(c);
                        break;
                    case 4:
                        System.out.print("Nhập vị trí cần sửa: ");
                        int vt=sc.nextInt();
                        System.out.println("Nhập TT cần thêm:");
                        c=new sv();
                        c.Nhap();
                        qlds.sua(vt,c);
                        break;
                    case 5:
                        System.out.print("Nhập Msv cần Xóa: ");
                        String s1=sc.next();
                        qlds.xoa(s1);
                        break; 
                    case 6:
                        System.out.print("Nhập Msv cần Tìm: ");
                        String s2=sc.next();
                        System.out.println("MSV cần tìm là: ");
                        System.out.printf("%1s %5s %5s %4s %5s\n","MSV","Ten","Nam","DC","Lop\n");
                        sv x=qlds.timkiem(s2);   
                        break; 
                     case 7:
                         System.out.println("D/s sắp xếp tên là: ");
                         qlds.sapxep();
                         
                        break; 
                    case 8:
                        System.exit(0);
                        break;
                }
            }
    }
    
}
