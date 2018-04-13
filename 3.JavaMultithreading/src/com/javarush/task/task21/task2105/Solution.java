package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        if (o == null || getClass() != o.getClass()) return false;
        Solution s1 = (Solution) o;
        return s1.first == first && s1.last == last;
    }

    public int hashCode() {
        int resultat = first != null ? first.hashCode() : 0;
        resultat = 31 * resultat + (last != null ? last.hashCode() : 0);
        return resultat;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
