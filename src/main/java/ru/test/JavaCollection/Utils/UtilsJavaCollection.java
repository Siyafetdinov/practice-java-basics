package ru.test.JavaCollection.Utils;

import java.util.*;

public class UtilsJavaCollection {

    public static ArrayList<Integer> getRandomIntList(int min, int max){
        Random rnd = new Random();
        int[] fiveRandomNumbers = rnd.ints(20, min, max+1).toArray();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < fiveRandomNumbers.length; i++) {
            list.add(Integer.valueOf(fiveRandomNumbers[i]));
        }
        return (ArrayList<Integer>) list;
    }

    public static Character[] getCharacterArray(String str){
        Character[] characterArray = new Character[str.toCharArray().length];
        for (int i = 0; i < str.toCharArray().length; i++) {
            characterArray[i] = str.toCharArray()[i];
        }
        return characterArray;
    }

    public static List<Map<String, String>> getNewListAndMap(){
        List<Map<String, String>> result = new ArrayList<>();
        Map<String, String> newMapOne = new HashMap<>() {{
            put("aaaa", "aa");
            put("bbbbb", "bb");
            put("cccccc", "cc");
            put("ddddddd", "dd");
        }};
        Map<String, String> newMapTwo = new HashMap<>() {{
            put("ee", "eeee");
            put("fff", "fffff");
            put("rrrr", "rrrrrr");
            put("yyyyy", "yyyyyyy");
        }};
        result.add(newMapOne);
        result.add(newMapTwo);
        return result;
    }

    public static List<String> getNewList(List<Map<String, String>> list){
        List<String> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++)
        {
            Map<String, String> tmpMap = list.get(i);
            for (var entry:tmpMap.entrySet())
            {
                result.add(entry.getKey());
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
