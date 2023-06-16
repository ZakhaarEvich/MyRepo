import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacAdressValidation {
    public static void main(String args[]) {
        String str = "aE:dC:cA:56:76:54";
        String pattern = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }
}
