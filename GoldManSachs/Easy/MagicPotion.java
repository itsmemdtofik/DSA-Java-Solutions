package GoldManSachs.Easy;

public class MagicPotion {
    private static int magicPotion(String s1) {
        int count = 1;
        int i = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(s1.charAt(0));
        while (i < s1.length()) {
            if (s1.length() >= 2 * i && s1.charAt(i) == s1.charAt(0)) {
                if (s1.substring(0, i).equals(s1.substring(i, 2 * i))) {
                    i += i - 1;
                    sb.append("*");
                } else
                    sb.append(s1.charAt(i));
            } else {
                sb.append(s1.charAt(i));
            }
            count++;
            i++;
        }
        System.out.print(sb.toString() + " ");
        return count;

    }

    public static void main(String[] args) {
        
        System.out.println("Minimal steps: [ABCABCE] : " + magicPotion("ABCABCE"));
        System.out.println("Minimal steps: [ABABCABABCD] : " + magicPotion("ABABCABABCD"));
        System.out.println("Minimal steps: [ABCDABCE] : " + magicPotion("ABCDABCE"));
        System.out.println("Minimal steps: [ABABCABABCE] : " + magicPotion("ABABCABABCE"));
    }
}
