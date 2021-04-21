package programmers;
// https://programmers.co.kr/learn/courses/30/lessons/72410

import java.util.Scanner;

public class Solution72410 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String new_id = sc.next();
//
        String a1 = "...!@BaT#*..y.abcdefghijklm";
        String a2 = "z-+.^.";
        String a3 = "=.=";
        String a4 = "123_.def";
        String a5 = "abcdefghijklmn.p";
        String[] as = {a1, a2, a3, a4, a5};

        for (String a: as) {
            System.out.println(solution(a));
        }
    }

    public static String solution(String new_id) {
        StringBuilder answer;
        String rs;

        // step 1.
        rs = new_id.toLowerCase();
//        System.out.println("step 1 : "+rs);

        // step 2.
        rs = rs.replaceAll("[^a-z0-9_.-]", "");
//        System.out.println("step 2 : "+rs);

        // step 3.
        rs = rs.replaceAll("\\.[.]+", ".");
//        System.out.println("step 3 : "+rs);

        // step 4.
        rs = rs.replaceAll("^\\.|\\.$", "");
//        System.out.println("step 4 : "+rs);

        // step 5.
        if (rs.length() == 0) answer = new StringBuilder("a");
        else answer = new StringBuilder(rs);
//        System.out.println("step 5 : "+answer);

        // step 6.
        if (answer.length() >= 16) {
            answer.delete(15,answer.length());
        }
//        System.out.println("step 6-1 : "+answer);
        if (answer.charAt(answer.length() - 1) == '.') {
            answer.delete(answer.length() - 1, answer.length());
        }
//        System.out.println("step 6-2 : "+answer);

        // step 7.
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer.append(answer.charAt(answer.length() - 1));
            }
        }
//        System.out.println("step 7 : "+answer);
        return answer.toString();
    }
}
/*
깔끔한 풀이 방법 : programmers  -님
class Solution {
    public String solution(String new_id) {

        String s = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();


        return s;
    }

    private static class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }
}
*/