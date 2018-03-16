package topcoder.practice.abba;

public class ABBA {

    public String canObtain(String src, String dst) {
        if (dst.length() < src.length()) {
            return "Impossible";
        }

        int dir = 1;
        int end = dst.length() - 1;
        int begin = 0;
        while (end - begin + 1 > src.length()) {
            if (dir > 0) {
                if (dst.charAt(end) == 'B') {
                    dir = -dir;
                }
                end--;
            } else {
                if (dst.charAt(begin) == 'B') {
                    dir = -dir;
                }
                begin++;
            }
        }

        if (dir > 0) {
            for (int i = begin, j = 0; i <= end; i++, j++) {
                if (src.charAt(j) != dst.charAt(i)) {
                    return "Impossible";
                }
            }
            return "Possible";
        }
        for (int i = end, j = 0; i >= begin; i--, j++) {
            if (src.charAt(j) != dst.charAt(i)) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    public boolean processRec(String src, byte[] dst, int begin, int end, int dir) {
        int len = end - begin + 1;
        if (len < src.length()) {
            return false;
        }
        if (len == src.length()) {
            if (dir > 0) {
                for (int i = begin; i <= end; i++) {
                    if (src.charAt(i - begin) != dst[i]) {
                        return false;
                    }
                }
            } else {
                for (int i = end, j = 0; i >= begin; i--, j++) {
                    if (src.charAt(j) != dst[i]) {
                        return false;
                    }
                }
            }
            return true;
        }

        if (dir > 0) {
            if (dst[end] == 'A') {
                return processRec(src, dst, begin, end - 1, dir);
            }
            return processRec(src, dst, begin, end - 1, -dir);
        }

        if (dst[begin] == 'A') {
            return processRec(src, dst, begin + 1, end, dir);
        }
        return processRec(src, dst, begin + 1, end, -dir);
    }
}
