package arrays;

public class ReverseString {

    public static String reverse(String aString) {
        if (aString == null || aString.length() < 2) {
            return aString;
        }

        StringBuilder revStr = new StringBuilder();

        for (int i = (aString.length() - 1); i >= 0; i--) {
            revStr.append(aString.charAt(i));
        }

        return revStr.toString();
    }

    public static String reverse1(String aString) {
        return new StringBuilder(aString).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("reverse->" + reverse("Clark Kent"));
        System.out.println("reverse1->" + reverse1("Clark Kent"));
    }
}
