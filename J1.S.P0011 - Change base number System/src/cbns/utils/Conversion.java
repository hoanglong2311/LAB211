package cbns.utils;

/**
 *
 * @author lamhnt
 */
public class Conversion {

    // declare
    public static final char[] HEXA_CHAR
            = {'0', '1', '2', '3', '4', '5', '6',
                '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    // convert from BINARY to DECIMAL
    public String convertBinaryToDecimal(String binaryNumber) {
        int decimalNumber = Integer.parseInt(binaryNumber, 2);
        return Integer.toString(decimalNumber);
    }

    // convert from DECIMAL to BINARY
    public String convertDecimalToBinary(String decimalNumber) {
        String binaryNumber = Integer.toBinaryString(Integer.parseInt(decimalNumber));
        return binaryNumber;
    }

    // convert from DECIMAL to HEXADECIMAL
    public String convertDecimalToHexadecimal(String decimalNumber) {
        // declare
        String hexadecimalNumber = "";

        int decimal = Integer.parseInt(decimalNumber);
        while (decimal != 0) {
            hexadecimalNumber = HEXA_CHAR[decimal % 16] + hexadecimalNumber;
            decimal = decimal / 16;
        }

        return hexadecimalNumber;
    }

    // convert from HEXADECIMAL to DECIMAL
    public int convertHexadecimalToDecimal(String hexadecimalNumber) {
        int decimalNumber = Integer.parseInt(hexadecimalNumber, 16);
        return decimalNumber;
    }

    // convert from BINARY to HEXADECIMAL
    public String convertBinaryToHexadecimal(String binaryNumber) {
        String decimalNumber = convertBinaryToDecimal(binaryNumber);
        String hexadecimalNumber = convertDecimalToHexadecimal(decimalNumber);
        return hexadecimalNumber;
    }

    // convert from HEXADECIMAL to BINARY
    public String convertHexadecimalToBinary(String hexadecimalNumber) {
        String binaryNumber = Integer.toBinaryString(convertHexadecimalToDecimal(hexadecimalNumber));
        return binaryNumber;
    }
}
