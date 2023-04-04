import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\java\\Bai tap\\baitap_IOBinaryFile_ProductManage\\src\\source.txt");
            FileOutputStream fos = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\java\\Bai tap\\baitap_IOBinaryFile_ProductManage\\src\\target.txt");
            int i;
            byte[] arr = new byte[1024];
            while ((i = fis.read(arr)) != -1){
                fos.write(arr,0,i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
