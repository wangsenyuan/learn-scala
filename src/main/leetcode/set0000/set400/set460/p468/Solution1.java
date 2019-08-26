package set0000.set400.set460.p468;

/**
 * Created by senyuanwang on 2016/12/11.
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        //System.out.println(solution.validIPAddress("172.16.254.1"));
        System.out.println(solution1.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }

    public String validIPAddress(String IP) {
        if (validIPv4(IP)) {
            return "IPv4";
        }

        if (validIPv6(IP)) {
            return "IPv6";
        }

        return "Neither";
    }

    private boolean validIPv6(String ip) {
        String[] parts = ip.split(":");
        if (parts.length != 8) {
            return false;
        }

        for (String part : parts) {
            if (!validIPv6Part(part)) {
                return false;
            }
        }
        return true;
    }

    private boolean validIPv6Part(String part) {
        if (part.length() == 0 || part.length() > 4) {
            return false;
        }

        for (int i = 0; i < part.length(); i++) {
            char c = part.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean validIPv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            if (!validIPv4Part(part)) {
                return false;
            }
        }

        return true;
    }

    private boolean validIPv4Part(String part) {
        int num = 0;

        int i = 0;
        while (i < part.length()) {
            char c = part.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }

            if (i == 0 && i < part.length() - 1 && c == '0') {
                return false;
            }
            num = num * 10 + (c - '0');
            i++;
        }

        return num <= 255;
    }
}
