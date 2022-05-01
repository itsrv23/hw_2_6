package com.itsrv23.hw_2_6;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //region task 1
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        //var 1
        System.out.println("task 1 var 1");
        nums.stream().filter(p -> p % 2 == 0).forEach(System.out::println);
        //var2
        System.out.println("task 1 var 2");
        for (Integer num : nums) {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
        System.out.println("");
        //endregion


        // region task 2
        List<Integer> nums2 = new ArrayList<>(List.of(99, 103, 104, 1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        //var1
        System.out.println("task 2 var 1");
        nums2.stream().collect(Collectors.toSet()).stream().filter(p -> p % 2 != 0).sorted()
                .forEach(System.out::println);

        //var1.1
        System.out.println("task 2 var 1.1");
        nums2.stream().distinct().filter(p -> p % 2 != 0).sorted().forEach(System.out::println);
        //var2
        System.out.println("task 2 var 2");
        Set<Integer> setInt = new HashSet<>(nums2);
        nums2.clear();
        nums2 = new ArrayList<>(setInt);
        nums2.sort(Integer::compareTo);
        for (Integer integer : nums2) {
            if (integer % 2 != 0) {
                System.out.println(integer);
            }
        }

        // endregion

        // region task 3
        String txt = "AAAA, BBBB, СССС,СССС99 a9 Напишите код, который выводит в консоль все уникальные слова из списка слов, в котором могут встречаться дубли. " +
                "В качестве отладочной информации возьмите произвольный набор слов или текст, в котором встречаются повторения. " +
                "Код должен работать с любой последовательностью и объемом списка слов. MIRONOV 1234";
        //Так как нужно выводить уникальные слова, то НЕ нужно учитывать регистр
        //Можно было написать более красивую регулярку, но не хотел слишком много времени тратить
        //Или как вариант воспользоваться SB, и собрать через регулярку только буквы, в одну строку
        String formatedText = txt.toLowerCase(Locale.ROOT).replaceAll("[,. \\d]", " ");
        System.out.println("formatedText = " + formatedText);
        //task3 var 1
        System.out.println("task 3 var 1");
        List<String> listString = new ArrayList<>(List.of(formatedText.split(" ")));
        List<String> collect = listString.stream()
                .distinct()
                .sorted()
                .filter(p -> !p.equals(""))
                .peek(c -> System.out.print(c + ", "))
                .collect(Collectors.toList());

        System.out.println(" ");
        //task3 var 2
        System.out.println("task 3 var 2");
        Set<String> setOfStrings = new HashSet<>();

        for (String s : formatedText.split(" ")) {
            if (!s.equals("")) {
                setOfStrings.add(s);
            }
        }
        System.out.println(setOfStrings);
        // endregion

        // region task 4
        System.out.println("task 4 var 1");
        Map<String, Long> collect1 = listString.stream()
                .filter(p -> !p.equals(""))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        System.out.println("collect1 = " + collect1);

        System.out.println("task 4 var 2");
        List<String> listString2 = new ArrayList<>(List.of(formatedText.split("( )")));
        Map<String, Long> collect2 = new HashMap<>();
        int count = 1;
        for (int i = 0; i < listString2.size(); i++) {
            if (!listString2.get(i).equals("")) {
                for (int j = 0; j < listString2.size() ; j++) {
                    if (listString2.get(i).equals(listString2.get(j))) {
                        count++;
                    }
                }
                collect2.put(listString2.get(i), (long) count);
            }
            count = 0;
        }

        System.out.println("collect2 = " + collect2);

        // endregion
    }
}
