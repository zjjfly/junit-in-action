package com.github.zjjfly.jia.ch02;

/**
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/1/10
 */
public class WordCounter {

    public int countWords(String sentence) {
        return sentence.split(" ").length;
    }
}
