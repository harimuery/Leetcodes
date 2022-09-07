package com.harimuery.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author harimuery
 * @description: https://leetcode.cn/problems/rearrange-spaces-between-words/
 * @since 20220907
 */
public class daliy20220907 {

    /**
     * 题解：先用List存单词, 然后用字符长度减去List中每个单词长度, 就是空格的个数了
     * 之后需要做拼接：非末尾单词要拼的空格个数 = 空格总数 / (单词数 - 1)
     *              末尾单词要拼的空格个数 = 空格总数 % (单词数 - 1)
     * @param text　输入
     */
    public String reorderSpaces(String text) {
        int blankNums = 0, head = -1, tail = -1;
        List<String> words = new ArrayList();
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == ' ') {
                blankNums++;
                if (head != -1) {
                    words.add(text.substring(head, tail + 1));
                    head = -1; tail = -1;
                }
            } else {
                if (head == -1) head = i;
                tail = i;
                if (i == text.length() - 1) {
                    words.add(text.substring(head, tail + 1));
                }
            }
        }

        String bStr = blankString(blankNums / (words.size() == 1 ? 1 : words.size() - 1));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            result.append(words.get(i));
            if (i != words.size() - 1) result.append(bStr);
            else result.append(blankString(text.length() - result.length()));
        }
        return result.toString();
    }

    public String blankString(int nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums; i++) sb.append(" ");
        return sb.toString();
    }


    public static void main(String[] args) {

    }
}

