/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1lab03;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Products {
	private String tenHangHoa;
	private String nhaSanXuat;
	private float giaBan;
	 int max=0;
	ArrayList<Products> product = new ArrayList<>();
     Scanner scanner=  new Scanner(System.in);
	
     
        @SuppressWarnings("empty-statement")
	public void sort() {
		Collections.sort(product, new Comparator<Products>() {

			@Override
			public int compare(Products o1, Products o2) {
				
				return o1.getGiaBan()>o2.getGiaBan() ? 1 : -1 ;
			}
		});;
		System.out.println("danh sách sau khi sắp xếp theo giá bán :");
		for (Products product2 : product) {
			System.out.println(product2.toString());
		}
	}
  
	public  void Max() {
		for (Products product2 : product) {
			if (max<product2.getGiaBan()) {
				max=(int) product2.getGiaBan();
			}
		}
		for (Products product2 : product) {
			if (product2.getGiaBan()==max) {
				System.out.println("mạt hàng có giá bán cao nhất là :"+product2.toString());
			}
		}
	}

	public void hienthi() {
  for (Products product2 : product) {
	System.out.println(product2.toString());
}
	}

	public void nhap()  {
		
		System.out.println("nhập số sản phẩm cần nhập");
		int so=scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < so; i++) {
			System.out.println("nhập tên hàng hóa :");
		    tenHangHoa=scanner.nextLine();
		
			System.out.println("nhập nhà sản xuất : ");
			nhaSanXuat=scanner.nextLine();
			
			System.out.println("nhập giá bán :");
			giaBan=scanner.nextInt();
			scanner.nextLine();
			
			product.add(new Products(tenHangHoa,nhaSanXuat,giaBan, product));
		}
		
	}

	
	
	public void timTheoTenHangHoa(String name) {
		
		for (Products product2 : product) {
			if (product2.getTenHangHoa().equals(name)) {
			  System.out.println(product2.toString());
			}
			else {
				System.out.println("không có hàng cần tìm");
			}
		}
	}


	public Products(String tenHangHoa, String nhaSanXuat, float giaBan, ArrayList<Products> product) {
		
		super();
		this.tenHangHoa = tenHangHoa;
		this.nhaSanXuat = nhaSanXuat;
		this.giaBan = giaBan;
		this.product = product;
		
	}

	@Override
	public String toString() {
		return "Product [tenHangHoa=" + tenHangHoa + ", nhaSanXuat=" + nhaSanXuat + ", giaBan=" + giaBan + "]";
	}
	
	public Products() {
		
	}

	public String getTenHangHoa() {
		return tenHangHoa;
	}

	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}

	public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public float getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}

	
}