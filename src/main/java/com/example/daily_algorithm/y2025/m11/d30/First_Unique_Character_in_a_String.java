package com.example.daily_algorithm.y2025.m11.d30;

import java.util.HashMap;
import java.util.Map;

public class First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        char[] ch = new char[s.length()];

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            ch[i] = s.charAt(i);

            if(map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i]) + 1);
            } else{
                map.put(ch[i], 1);
            }
        }

        for(int j=0; j < s.length(); j++){
            if(map.get(ch[j]) == 1){
                return j;
            }
        }

        return -1;

    }
}
