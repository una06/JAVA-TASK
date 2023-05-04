import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test.txt")) {
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
