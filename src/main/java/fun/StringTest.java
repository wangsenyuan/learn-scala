package fun;

/**
 * Created by senyuanwang on 15/7/28.
 */
public class StringTest implements Clock {
    private int i = 0;
    public void testString() {
        String str = new String();
        int j = i;
        for(; i < j + 40000; i++) {
            str += String.valueOf(i);
        }
    }

    public void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        int j = i;
        for(; i < j + 40000; i++) {
            sb.append(String.valueOf(i));
        }
    }

    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        int j = i;
        for(; i < j + 40000; i++) {
            sb.append(String.valueOf(i));
        }
    }

    public static void main(String[] args) {
        StringTest test = new StringTest();

        test.stamp("String", test::testString);
        test.stamp("StringBuffer", test::testStringBuffer);
        test.stamp("StringBuilder", test::testStringBuilder);

        test.stamp("String", test::testString);
        test.stamp("StringBuffer", test::testStringBuffer);
        test.stamp("StringBuilder", test::testStringBuilder);

        test.stamp("String", test::testString);
        test.stamp("StringBuffer", test::testStringBuffer);
        test.stamp("StringBuilder", test::testStringBuilder);
    }
}
