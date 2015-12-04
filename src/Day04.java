import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author daniel.rejment@tacton.com (2015-12-04)
 */
public class Day04 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "yzbqklnj";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        int i = 0;
        while (!DatatypeConverter.printHexBinary(md5.digest((input + i).getBytes())).startsWith("00000")) i++;
        System.out.println(i);

        while (!DatatypeConverter.printHexBinary(md5.digest((input + i).getBytes())).startsWith("000000")) i++;
        System.out.println(i);
    }
}
