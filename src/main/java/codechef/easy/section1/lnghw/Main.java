package codechef.easy.section1.lnghw;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        public char nextChar() throws IOException {
            byte c = read();
            while (c <= ' ')
                c = read();
            return (char) c;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }


    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int q = reader.nextInt();
        int m = reader.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            long num = reader.nextLong();
            items[i] = new Item(i + 1, num);
        }

        Arrays.sort(items);

        ArrayList<Integer>[] indexes = new ArrayList[m];
        for (int i = 0; i < n; i++) {
            Item item = items[i];
            long num = item.value;
            int reminder = (int) (num % m);
            if (indexes[reminder] == null) {
                indexes[reminder] = new ArrayList<>();
            }
            indexes[reminder].add(item.origin);
        }

        for (int j = 0; j < q; j++) {
            int i = reader.nextInt();
            int r = reader.nextInt();
            if (r >= m || indexes[r] == null) {
                System.out.println(-1);
                continue;
            }
            ArrayList<Integer> vals = indexes[r];
            if (i > vals.size()) {
                System.out.println(-1);
                continue;
            }
            System.out.println(vals.get(i - 1));
        }
    }

    static class Item implements Comparable<Item> {
        final int origin;
        final long value;

        Item(int origin, long value) {
            this.origin = origin;
            this.value = value;
        }

        @Override
        public int compareTo(Item that) {
            if (this.value < that.value) {
                return -1;
            } else if (this.value > that.value) {
                return 1;
            }
            return 0;
        }
    }
}
