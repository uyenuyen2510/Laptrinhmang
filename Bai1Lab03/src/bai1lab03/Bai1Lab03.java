/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1lab03;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class Bai1Lab03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int n = 0;
		ArrayList<Products> product = new ArrayList<>();

		Products product2 = new Products();
		do {
			menu();
			System.out.println();
			System.out.println("Nhap vao lua chon cua ban :");
			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());

			switch (n) {
			case 1:
				product2.nhap();
				break;

			case 2:
				product2.hienthi();
				break;

			case 3:
				product2.sort();
				break;

			case 4:
				System.out.println("nhập tên hàng hóa cần tìm kiếm ");
				String name = sc.nextLine();
				product2.timTheoTenHangHoa(name);
				break;
            
				case 5:
					product2.Max();
					break;
			default:
				System.out.println("nhập sai lựa chọn . Mời bạn nhập lại");
				break;
			}

		} while (n != 6);
	}

	public static void menu() {
		System.out.println("1. Nhập thông tin cho n sản phẩm");
		System.out.println("2. Hiển thị thông tin vừa nhập");
		System.out.println("3. Sắp xếp thông tin giảm dần theo giá và hiển thị");
		System.out.println("4.Tìm kiếm theo tên hàng hóa");
		System.out.println("5.mặt hàng có giá max");
		System.out.println("6.Exit");
	}
}