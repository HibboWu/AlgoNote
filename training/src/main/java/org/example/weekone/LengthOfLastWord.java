package org.example.weekone;

import java.util.Locale;

/**
 * @Author: Haibo
 * @Date: 2022/2/20 15:19
 */
public class LengthOfLastWord {
    public static int solution(String word) {
        int count = 0;
        int length = word.length();
        String trimWord = word.trim().toLowerCase(Locale.ROOT);
        for(int i = trimWord.length()-1; i >= 0; i--) {
            if (trimWord.charAt(i) > 'a' && trimWord.charAt(i) < 'z') {
                count++;
            }else if(trimWord.charAt(i) == ' '){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        LengthOfLastWord.solution("   fly me   to   the moon ");
        String substring = "abcdefg".substring(0, 2);
    }
}
