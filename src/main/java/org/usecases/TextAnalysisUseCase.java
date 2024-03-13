package org.usecases;

public class TextAnalysisUseCase {
    public TextAnalysisResult performTextAnalysis(String inputText) {
        int wordCount = inputText.split("\\s+").length;
        int charCount = inputText.length();
        String modifiedText = inputText.replaceAll("\\bHello\\b", "Goodbye");
        int helloCount = (inputText.length() - modifiedText.length()) / "Hello".length();

        return new TextAnalysisResult(wordCount, charCount, helloCount, modifiedText);
    }
}

