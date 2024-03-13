package org.usecases;

public class TextAnalysisResult {
    private final int wordCount;
    private final int charCount;
    private final int helloCount;
    private final String modifiedText;

    public TextAnalysisResult(int wordCount, int charCount, int helloCount, String modifiedText) {
        this.wordCount = wordCount;
        this.charCount = charCount;
        this.helloCount = helloCount;
        this.modifiedText = modifiedText;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getCharCount() {
        return charCount;
    }

    public int getHelloCount() {
        return helloCount;
    }

    public String getModifiedText() {
        return modifiedText;
    }

    // Optional: Override toString() for easy printing of results.
    @Override
    public String toString() {
        return "TextAnalysisResult{" +
                "wordCount=" + wordCount +
                ", charCount=" + charCount +
                ", helloCount=" + helloCount +
                ", modifiedText='" + modifiedText + '\'' +
                '}';
    }
}
