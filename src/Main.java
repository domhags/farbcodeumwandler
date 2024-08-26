import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie den Hexadezimalen Farbcode ein (mit oder ohne #):");
        String hexFarbe = scanner.nextLine().trim();

        // Entferne optionales # am Anfang des Strings
        if (hexFarbe.startsWith("#")) {
            hexFarbe = hexFarbe.substring(1);
        }

        // Überprüft die Gültigkeit der Eingabe
        if (!isValidHexColor(hexFarbe)) {
            System.out.println("Ungültiger Hexadezimaler Farbcode. Bitte geben Sie einen gültigen Code ein.");
        } else {
            int[] rgb = hexToRGB(hexFarbe);
            System.out.printf("Der RGB-Wert für %s ist: R = %d, G = %d, B = %d%n", hexFarbe, rgb[0], rgb[1], rgb[2]);
        }
    }

    // Methode zur Umrechnung eines hexadezimalen Farbwerts in den RGB-Farbraum
    public static int[] hexToRGB(String hex) {
        // Hexadezimale Zeichenfolge in Integer-Werte für Rot, Grün und Blau umwandeln
        int r = Integer.parseInt(hex.substring(0, 2), 16);  //16 für Hexadezimalsystem
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        // RGB-Werte als Array zurückgeben
        return new int[]{r, g, b};
    }

    // Methode zur Überprüfung der Gültigkeit des hexadezimalen Farbwerts
    public static boolean isValidHexColor(String hex) {
        // Überprüft, ob der String genau 6 Zeichen lang ist und nur gültige hexadezimale Zeichen enthält
        return hex.matches("^[0-9A-Fa-f]{6}$");
    }
}
