package set000.set020.p022;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 16/7/2.
 */
public class SolutionJ {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        process(n, 0, new char[2 * n], 0, res);

        return res;
    }

    private void process(int toOpen, int toClose, char[] cs, int i, List<String> res) {
        if (i == cs.length) {
            res.add(new String(cs));
            return;
        }

        if (toOpen > 0) {
            cs[i] = '(';
            process(toOpen - 1, toClose + 1, cs, i + 1, res);
        }

        if (toClose > 0) {
            cs[i] = ')';
            process(toOpen, toClose - 1, cs, i + 1, res);
        }
    }
}
