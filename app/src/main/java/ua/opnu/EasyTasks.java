package ua.opnu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EasyTasks {

    public static void main(String[] args) {
        // Тести запускати у TaskTest.java
    }

    // -------------------- Task 1 --------------------
    public List<Integer> doubling(List<Integer> nums) {
        List<Integer> result = new ArrayList<>(nums.size());
        for (Integer value : nums) {
            result.add(value * 2);
        }
        return result;
    }

    // -------------------- Task 2 --------------------
    public List<Integer> square(List<Integer> nums) {
        List<Integer> squared = new ArrayList<>(nums.size());
        for (Integer x : nums) {
            squared.add(x * x);
        }
        return squared;
    }

    // -------------------- Task 3 --------------------
    public List<String> moreY(List<String> strings) {
        List<String> out = new ArrayList<>(strings.size());
        for (String s : strings) {
            out.add("y" + s + "y");
        }
        return out;
    }

    // -------------------- Task 4 --------------------
    public List<Integer> noNeg(List<Integer> nums) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer n : nums) {
            if (n >= 0) {
                filtered.add(n);
            }
        }
        return filtered;
    }

    // -------------------- Task 5 --------------------
    public List<Integer> no9(List<Integer> nums) {
        List<Integer> res = new ArrayList<>();
        for (Integer n : nums) {
            if (Math.abs(n) % 10 != 9) {
                res.add(n);
            }
        }
        return res;
    }

    // -------------------- Task 6 --------------------
    public List<String> noZ(List<String> strings) {
        List<String> out = new ArrayList<>();
        for (String s : strings) {
            if (s.indexOf('z') == -1) {     // інший спосіб перевірки
                out.add(s);
            }
        }
        return out;
    }

    // -------------------- Task 7 --------------------
    public List<String> refinedStrings(List<String> strings) {

        // Видаляємо дублікати вручну, не через distinct()
        List<String> unique = new ArrayList<>();
        for (String s : strings) {
            if (!unique.contains(s)) {
                unique.add(s);
            }
        }

        // Сортуємо по довжині, найдовші спочатку
        unique.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return Integer.compare(b.length(), a.length());
            }
        });

        return unique;
    }

    // -------------------- Task 8 --------------------
    public List<String> flatten(List<String> strings) {
        List<String> words = new ArrayList<>();

        for (String line : strings) {
            int start = 0;
            for (int i = 0; i <= line.length(); i++) {
                if (i == line.length() || line.charAt(i) == ' ') {
                    if (i > start) {
                        words.add(line.substring(start, i));
                    }
                    start = i + 1;
                }
            }
        }
        return words;
    }
}
