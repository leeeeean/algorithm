package programmers;
// https://programmers.co.kr/learn/courses/30/lessons/60057

public class Solution60057 {
    public static void main(String[] args) {
//        String[] strs = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd"};
        String[] strs = {"aa"};
        for (String s : strs) {
            System.out.println(solution(s));
        }
    }

    public static int solution(String s) {
        int answer = 1000;
        for (int i = 1; i <= s.length()/2; i++) {
            answer = Math.min(answer, calc(i, s));
        }
        if (s.length()==1) answer = 1;

        return answer;
    }

    public static int calc(int mount, String s) {
        int end = s.length()-(s.length()%mount);
        StringBuilder sb = new StringBuilder();
        String sub = s.substring(0, mount);
        int cnt =0;
//        System.out.println("=====  mount : "+mount+" | sub : "+sub+" =====");
        for (int i = 0; i < end; i+=mount) {
            String substring = s.substring(i, i + mount);
            if (sub.equals(substring)) {
                cnt++;
            } else {
                if (cnt == 1) {
                    sb.append(sub);
                } else {
                    sb.append(cnt);
                    sb.append(sub);
                }
                sub = substring;
                cnt = 1;
            }
//            System.out.println(sb.toString());
        }
        if (cnt == 1) {
            sb.append(sub);
        } else {
            sb.append(cnt);
            sb.append(sub);
        }
        sb.append(s.substring(end, s.length()));
//        System.out.println("rs ==> "+sb.toString());
        return sb.length();
    }
}

/*
다른 풀이 : programmers 송동훈 님 ,choiyeonseok 님
class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i=1; i<=(s.length()/2)+1; i++){
            int result = getSplitedLength(s, i, 1).length();
            answer = i==1 ? result : (answer>result?result:answer);
        }

        return answer;
    }

    public String getSplitedLength(String s, int n, int repeat){
        if(s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if(!postString.startsWith(preString)){
            if(repeat ==1) return result += preString + getSplitedLength(postString, n, 1);
            return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
        }

        return result += getSplitedLength(postString, n, repeat+1);
    }
}
다른 풀이 : programmers 황재익 님, 김봉한님, Yu Zi 님, - 님, 재재 님 외 1명
class Solution {
    public int solution(String s) {
        int min = s.length();
        int len = s.length()/2+1;
        for(int i = 1; i < len; i++) {
            String before = "";
            int sum = 0;
            int cnt = 1;
            for(int j = 0; j < s.length();) {
                int start = j;
                j = (j+i > s.length()) ? s.length():j+i;
                String temp = s.substring(start, j);
                if(temp.equals(before)) {
                    cnt++;
                } else {
                    if(cnt != 1) {
                        sum += (int)Math.log10(cnt)+1;
                    }
                    cnt = 1;
                    sum+=before.length();
                    before = temp;
                }
            }
            sum+=before.length();
            if(cnt != 1) {
                sum += (int)Math.log10(cnt)+1;
            }
            min = (min > sum) ? sum : min;
        }

        return min;
    }
}
 */