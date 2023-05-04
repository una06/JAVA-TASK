import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BankFinder {
    private static Map<String, String> bankData;

    public static void main(String[] args) throws IOException {
        bankData = loadBankData();

        String bankNumber = getBankNumberFromUser();
        String bankName = getBankName(bankNumber);

        System.out.println("Your bank is: " + bankName);
    }

    private static String getBankNumberFromUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the first three digits of your bank account: ");
        return reader.readLine().trim();
    }

    private static String getBankName(String bankNumber) {
        String bankCode = bankNumber.substring(0, 4);
        String abbreviatedBankNumber = bankNumber.substring(4, 10);
        String key = bankCode + abbreviatedBankNumber;

        String bankName = bankData.get(key);
        if (bankName == null) {
            bankName = "Unknown bank";
        }
        return bankName;
    }

    private static Map<String, String> loadBankData() throws IOException {
        URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        Map<String, String> bankData = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length >= 2) {
                String bankCode = parts[0];
                String bankNumber = parts[1];
                bankData.put(bankCode + bankNumber, parts[2]);
            }
        }

        return bankData;
    }
}
