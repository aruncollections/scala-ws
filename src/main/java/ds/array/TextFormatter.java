package ds.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TextFormatter {

    public static int textFormatting(List<Integer> starting, List<Integer> ending, List<Character> style) {

        Map<Character, List<Integer>> charMap = new HashMap<>();

        if (starting.size() != ending.size() || starting.size() != style.size()) {
            throw new IllegalStateException("Indexes are not equal");
        } else {
            for (int i = 0; i < starting.size(); i++) {
                charMap.putIfAbsent(style.get(i), new ArrayList<>());
                charMap.get(style.get(i)).addAll(getList(starting.get(i), ending.get(i)));
            }
        }

        Map<Character, Integer> charMapCount = new HashMap<>();
        charMap.forEach((k, v) -> charMapCount.put(k, findConsecutiveLists(v.stream().distinct().sorted().collect(Collectors.toList()))));

        Map<List<Integer>, Set<Character>> invertedMap = new HashMap<>();
        charMap.forEach((k, v) -> {
            List<Integer> x = v.stream().distinct().sorted().collect(Collectors.toList());
            Set<Character> styleSet = invertedMap.getOrDefault(x, new HashSet<>());
            styleSet.add(k);
            invertedMap.put(x, styleSet);
        });

        int count = invertedMap.entrySet().stream().map(e -> {
            int n = findConsecutiveLists(e.getKey());
            return n + (n * e.getValue().size());
        }).collect(Collectors.summingInt(Integer::intValue));

        return count;
    }

    static int findConsecutiveLists(List<Integer> list) {
        int count = 1;

        for (int i = 0, j = 1; i < list.size() && j < list.size(); i++, j++) {
            int a = list.get(i) + 1;
            int b = list.get(j);

            if (a != b) {
                count++;
            }
        }

        return count;
    }

    static List<Integer> getList(int start, int end) {
        return IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }

    public static int textFormatting2(List<Integer> starting, List<Integer> ending, List<Character> style) {
        int count = 0;
        List<Integer> startEndList = new ArrayList<>(starting);
        startEndList.addAll(ending);
        System.out.println(startEndList);

        int max = startEndList.stream().mapToInt(v -> v).max().getAsInt();
        List<Format> article = new ArrayList<>();
        IntStream.range(0, max).forEach(i -> {
            article.add(i, new Format());
        });

        if (starting.size() != ending.size()) {
            throw new IllegalStateException();
        } else {
            for (int i = 0; i < starting.size(); i++) {
                int s = starting.get(i) - 1;
                int e = ending.get(i) - 1;
                System.out.println("s=" + s + ", e=" + e);

                for (int j = s; j <= e; j++) {
                    //System.out.println("B: Format " + article.get(j));
                    System.out.println("=> j=" + j + ", e=" + e + ", style: " + style.get(i));
                    Format.addStyle(article.get(j), style.get(i));
                    System.out.println("A: Format " + article.get(j));
                    System.out.println();
                }
                System.out.println("----------");
            }

        }

        System.out.println(article);

        return count;
    }

    public static void main(String[] args) {
        int result = textFormatting(
                new ArrayList<>(Arrays.asList(1, 17, 3, 3, 1, 13)),
                new ArrayList<>(Arrays.asList(5, 20, 8, 12, 1, 18)),
                new ArrayList<>(Arrays.asList('b', 'b', 'i', 'i', 'u', 'u')));

        int result2 = textFormatting(
                new ArrayList<>(Arrays.asList(1, 1, 3, 3, 3)),
                new ArrayList<>(Arrays.asList(6, 6, 8, 8, 8)),
                new ArrayList<>(Arrays.asList('b', 'b', 'b', 'i', 'u')));

        System.out.println("res: " + result);
        System.out.println("res: " + result2);

        /*System.out.println(getList(1,5));
        System.out.println(getList(0,5));
        System.out.println(getList(-1,2));*/
        //System.out.println(findConsecutiveLists(Arrays.asList(1,2,3,5,6,7,9,10)));
        //System.out.println(findConsecutiveLists(Arrays.asList(1,3,4,6,7,10,11,12,13,14)));

    }


    static class Format {
        private Character left;
        private Character right;
        private Character middle;

        static void addStyle(Format format, Character character) {
            if (character == null) {
                throw new IllegalStateException();
            }

            if (format.getLeft() == null) {
                format.setLeft(character);
            } else if (format.getMiddle() == null) {
                format.setMiddle(character);
            } else if (format.getRight() == null) {
                format.setRight(character);
            }
        }

        public Character getLeft() {
            return left;
        }

        public void setLeft(Character left) {
            this.left = left;
        }

        public Character getRight() {
            return right;
        }

        public void setRight(Character right) {
            this.right = right;
        }

        public Character getMiddle() {
            return middle;
        }

        public void setMiddle(Character middle) {
            this.middle = middle;
        }

        @Override
        public String toString() {
            return "(" + left + "," + middle + "," + right + ")";
        }
    }
}
