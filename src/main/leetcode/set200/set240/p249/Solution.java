package set200.set240.p249;

import java.util.*;

/**
 * Created by senyuanwang on 15/8/22.
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String str : strings) {
            if (!map.containsKey(str.length())) {
                map.put(str.length(), new ArrayList<>());
            }
            map.get(str.length()).add(str);
        }

        for (List<String> sameLength : map.values()) {
            result.addAll(splitGroups(sameLength));
        }
        return result;
    }

    public List<List<String>> splitGroups(List<String> strings) {
        List<List<String>> groups = new ArrayList<>();
        for (String str : strings) {
            boolean inGroup = false;
            for (List<String> group : groups) {
                String head = group.get(0);
                int x = -1;
                int i = 0;
                for (; i < str.length(); i++) {
                    char a = str.charAt(i);
                    char b = head.charAt(i);
                    int y = a - b;
                    while (y < 0) {
                        y += 26;
                    }
                    if (x == -1) {
                        x = y;
                    } else if (x != y) {
                        break;
                    }
                }
                if (i == str.length()) {
                    inGroup = true;
                    group.add(str);
                    break;
                }
            }
            if (!inGroup) {
                List<String> group = new ArrayList<>();
                group.add(str);
                groups.add(group);
            }
        }

        for (List<String> group : groups) {
            Collections.sort(group);
        }

//        Collections.sort(groups);
        return groups;
    }

    public static void main(String[] args) {
        String[] strings = {"az", "yx"};
        Solution solution = new Solution();
        System.out.println(solution.groupStrings(strings));
    }
}
