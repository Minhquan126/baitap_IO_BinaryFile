import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
List<Product> list = new ArrayList<>();
while (true){
    System.out.println("1.Them san pham \n" +
            "2 . Hien thi danh sach san pham \n" +
            "3 . Tim kiem san pham \n" +
            "4. Thoat \n");
    System.out.println("Nhap de chon chuc nang");
    int choice = Integer.parseInt(scanner.nextLine());
    switch (choice){
        case 1:
            createProduct(list,scanner);
            writeToFile("C:\\Users\\ADMIN\\Desktop\\java\\Bai tap\\baitap_IOBinaryFile_ProductManage\\src\\student.txt",list);
            break;
            case 2:
             display("C:\\Users\\ADMIN\\Desktop\\java\\Bai tap\\baitap_IOBinaryFile_ProductManage\\src\\student.txt");
            break;
            case 3:
                search(list,scanner);
            break;
            case 4:
                System.exit(0);
            break;
    }
}
    }
    public static void writeToFile(String path,List<Product> list){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        }catch (IOException ioe){
ioe.printStackTrace();
        }
    }
    public static List<Product> readObjFormFile(String path){
        List<Product> productList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
           productList =(List<Product>) ois.readObject();
        }catch (IOException | ClassNotFoundException ioe){
            ioe.printStackTrace();
        }
       return productList;
    }
public static void createProduct(List<Product> list, Scanner scanner){
    System.out.println("Số sản phẩm cần nhâp");
        int numb = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < numb; i++) {
        Product product = new Product();
        System.out.println("Nhập tên sản phẩm :");
        product.setProductName(scanner.nextLine());
        System.out.println("Nhập hãng sản phẩm :");
        product.setHangSanxuat(scanner.nextLine());
        System.out.println("Nhập giá sản phẩm :");
        product.setPrice(Float.parseFloat(scanner.nextLine()));
        if (list.size() == 0){
            product.setProductId(1);
        } else {
            product.setProductId(list.get(list.size() - 1).getProductId() - 1);
        }
        list.add(product);
    }
}
public static void search(List<Product> list,Scanner scanner){
    System.out.println("Nhap ten cam tim");
    String searchName = scanner.nextLine();
    List<Product> listSearch = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
        if (list.contains(searchName)){
            listSearch.add(list.get(i));
        }
    }
    writeToFile("C:\\Users\\ADMIN\\Desktop\\java\\Bai tap\\baitap_IOBinaryFile_ProductManage\\src\\search.txt",listSearch);
    List<Product> newList = readObjFormFile("C:\\Users\\ADMIN\\Desktop\\java\\Bai tap\\baitap_IOBinaryFile_ProductManage\\src\\search.txt");
    for (Product product:newList) {
        System.out.println(product);
    }
}
public static void display(String path){
       List<Product> list = readObjFormFile(path);
    for (Product product:list) {
        System.out.println(product);
    }
}
}