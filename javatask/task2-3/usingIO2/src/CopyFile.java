import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            int c;
            while ((c = br.read()) != -1) {
                if (c == ' ') {
                    bw.write('-');
                } else {
                    bw.write(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Error copying file");
        }
    }
}

