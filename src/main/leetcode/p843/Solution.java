package p843;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test3() {
        String secret = "hbaczn";
        int[] cnt = new int[1];
        Master master = new Master() {
            @Override
            public int guess(String word) {
                cnt[0]++;
                return similar(word, secret);
            }
        };
        String[] words =
            {"gaxckt", "trlccr", "jxwhkz", "ycbfps", "peayuf", "yiejjw", "ldzccp", "nqsjoa", "qrjasy", "pcldos",
                "acrtag", "buyeia", "ubmtpj", "drtclz", "zqderp", "snywek", "caoztp", "ibpghw", "evtkhl", "bhpfla",
                "ymqhxk", "qkvipb", "tvmued", "rvbass", "axeasm", "qolsjg", "roswcb", "vdjgxx", "bugbyv", "zipjpc",
                "tamszl", "osdifo", "dvxlxm", "iwmyfb", "wmnwhe", "hslnop", "nkrfwn", "puvgve", "rqsqpq", "jwoswl",
                "tittgf", "evqsqe", "aishiv", "pmwovj", "sorbte", "hbaczn", "coifed", "hrctvp", "vkytbw", "dizcxz",
                "arabol", "uywurk", "ppywdo", "resfls", "tmoliy", "etriev", "oanvlx", "wcsnzy", "loufkw", "onnwcy",
                "novblw", "mtxgwe", "rgrdbt", "ckolob", "kxnflb", "phonmg", "egcdab", "cykndr", "lkzobv", "ifwmwp",
                "jqmbib", "mypnvf", "lnrgnj", "clijwa", "kiioqr", "syzebr", "rqsmhg", "sczjmz", "hsdjfp", "mjcgvm",
                "ajotcx", "olgnfv", "mjyjxj", "wzgbmg", "lpcnbj", "yjjlwn", "blrogv", "bdplzs", "oxblph", "twejel",
                "rupapy", "euwrrz", "apiqzu", "ydcroj", "ldvzgq", "zailgu", "xgqpsr", "wxdyho", "alrplq", "brklfk"};
        Solution solution = new Solution();
        solution.findSecretWord(words, master);
        System.out.println(cnt[0]);
    }

    public static void test2() {
        String secret = "acckzz";
        int[] cnt = new int[1];
        Master master = new Master() {
            @Override
            public int guess(String word) {
                cnt[0]++;
                return similar(word, secret);
            }
        };
        String[] words = {"acckzz", "ccbazz", "eiowzz", "abcczz"};
        Solution solution = new Solution();
        solution.findSecretWord(words, master);
        System.out.println(cnt[0]);
    }

    public static void test1() {
        String secret = "ccoyyo";
        int[] cnt = new int[1];
        Master master = new Master() {
            @Override
            public int guess(String word) {
                cnt[0]++;
                return similar(word, secret);
            }
        };
        String[] words =
            {"wichbx", "oahwep", "tpulot", "eqznzs", "vvmplb", "eywinm", "dqefpt", "kmjmxr", "ihkovg", "trbzyb",
                "xqulhc", "bcsbfw", "rwzslk", "abpjhw", "mpubps", "viyzbc", "kodlta", "ckfzjh", "phuepp", "rokoro",
                "nxcwmo", "awvqlr", "uooeon", "hhfuzz", "sajxgr", "oxgaix", "fnugyu", "lkxwru", "mhtrvb", "xxonmg",
                "tqxlbr", "euxtzg", "tjwvad", "uslult", "rtjosi", "hsygda", "vyuica", "mbnagm", "uinqur", "pikenp",
                "szgupv", "qpxmsw", "vunxdn", "jahhfn", "kmbeok", "biywow", "yvgwho", "hwzodo", "loffxk", "xavzqd",
                "vwzpfe", "uairjw", "itufkt", "kaklud", "jjinfa", "kqbttl", "zocgux", "ucwjig", "meesxb", "uysfyc",
                "kdfvtw", "vizxrv", "rpbdjh", "wynohw", "lhqxvx", "kaadty", "dxxwut", "vjtskm", "yrdswc", "byzjxm",
                "jeomdc", "saevda", "himevi", "ydltnu", "wrrpoc", "khuopg", "ooxarg", "vcvfry", "thaawc", "bssybb",
                "ccoyyo", "ajcwbj", "arwfnl", "nafmtm", "xoaumd", "vbejda", "kaefne", "swcrkh", "reeyhj", "vmcwaf",
                "chxitv", "qkwjna", "vklpkp", "xfnayl", "ktgmfn", "xrmzzm", "fgtuki", "zcffuv", "srxuus", "pydgmq"};

        Solution solution = new Solution();
        solution.findSecretWord(words, master);
        System.out.println(cnt[0]);
    }

    public void findSecretWord(String[] wordlist, Master master) {
        if (wordlist == null || wordlist.length == 0) {
            return;
        }
        Arrays.sort(wordlist);
        String first = wordlist[0];

        int ret = master.guess(first);
        if (ret == 6) {
            return;
        }

        String[] next = new String[wordlist.length - 1];

        int j = 0;
        for (int i = 0; i < wordlist.length; i++) {
            if (wordlist[i].equals(first)) {
                continue;
            }
            int tmp = similar(first, wordlist[i]);
            if (tmp == ret) {
                next[j++] = wordlist[i];
            }
        }
        next = Arrays.copyOf(next, j);
        findSecretWord(next, master);
    }

    private static int similar(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}


interface Master {
    int guess(String word);
}
