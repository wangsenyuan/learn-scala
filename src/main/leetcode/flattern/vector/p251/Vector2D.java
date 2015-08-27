package flattern.vector.p251;

import java.util.List;

/**
 * Created by senyuanwang on 15/8/23.
 */
public class Vector2D {
    List<List<Integer>> vec2d;
    int x = 0;
    int y = 0;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        for (int i = 0; i < vec2d.size(); i++) {
            if (!vec2d.get(i).isEmpty()) {
                x = i;
                break;
            }
        }
    }

    public int next() {
        return vec2d.get(x).get(y++);
    }

    public boolean hasNext() {
        if (x == vec2d.size()) {
            return false;
        }
        if (y == vec2d.get(x).size()) {
            int i = x + 1;
            for (; i < vec2d.size(); i++) {
                if (!vec2d.get(i).isEmpty()) {
                    x = i;
                    break;
                }
            }
            if (i == vec2d.size()) {
                return false;
            }
            y = 0;
        }
        return true;
    }
}
