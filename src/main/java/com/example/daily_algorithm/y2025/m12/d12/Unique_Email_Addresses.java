package com.example.daily_algorithm.y2025.m12.d12;

import java.util.HashSet;
import java.util.Set;

public class Unique_Email_Addresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String email : emails) {
            int atIdx = email.indexOf('@');
            String local = email.substring(0, atIdx);
            String domain = email.substring(atIdx + 1);

            int plusIdx = local.indexOf('+');
            if (plusIdx != -1){
                local = local.substring(0, plusIdx);
            }

            local = local.replace(".", "");

            unique.add(local + "@" + domain);
        }

        return unique.size();
    }
}
