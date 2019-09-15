package app;

import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextSimilarityCalculator {
    private static List<Pair<String[], String>> responses;
    private static int largest;

    static {
        responses = new ArrayList<>();
        responses.add(Pair.of(new String[]{"купить", "траву"}, "Травы не завезли"));
        responses.add(Pair.of(new String[]{"инвестировать", "в"}, "Травы не завезли"));
        responses.add(Pair.of(new String[]{"убить", "сару", "коннор"}, "Сара Коннор не мешок - не убьет любой лошок"));
        responses.forEach((it) -> { if (it.getFirst().length > largest) largest = it.getFirst().length; });
    }

    public static int answer(String question, String[] keyTexts) {
        String[] words = splitWords(question);
        double[] requestSimilarities = new double[keyTexts.length];
        int maxI = -1;
        double maxVal = Double.MIN_VALUE;

        for (int i = 0; i < keyTexts.length; i++) {
            String[] keyWords = splitWords(keyTexts[i]);
            requestSimilarities[i] = comparePhrases(words, keyWords);
            if (requestSimilarities[i] > maxVal) {
                maxI = i;
                maxVal = requestSimilarities[i];
            }
        }

        return maxI;
    }

    public static String[] splitWords(String str) {
        return str
            .replace(".", "")
            .replace(",", "")
            .replace("?", "")
            .replace("!","")
            .split(" ");
    }

    public static String answer(String question) {
        String[] words = splitWords(question);
//        Arrays.stream(words).forEach((it) -> {
//            System.out.print("\"" + it + "\" ");
//        });
//        System.out.println();
        double[] requestSimilarities = new double[responses.size()];
        int maxI = 0;

        for (int i = 0; i < responses.size(); i++) {
            requestSimilarities[i] = comparePhrases(words, responses.get(i).getFirst());
//            System.out.println("Answer:'" + responses.get(i).getSecond() + "', similarity=" + requestSimilarities[i]);
            if (requestSimilarities[i] > requestSimilarities[maxI]) maxI = i;
        }

        if (requestSimilarities[maxI] < 0.8) return "Не понял команду";
        else                                 return responses.get(maxI).getSecond();
    }
    
    public static double comparePhrases(String[] words, String[] keyWords) {
        double[][] similarityMat = new double[words.length][keyWords.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < keyWords.length; j++) {
                similarityMat[i][j] = compareWords(words[i], keyWords[j]);
            }
        }

        int mapCount = words.length > keyWords.length ? keyWords.length : words.length;
        int[] alreadyMapped = new int[mapCount];
        double[] similarityVec = new double[mapCount];
        int maxI = 0, maxJ = 0;
        for (int k = 0; k < mapCount; k++) {
            double max = 0;
            for (int i = 0; i < words.length; i++) {
                if (mapCount == words.length && alreadyMapped[i] == 1) continue;
                for (int j = 0; j < keyWords.length; j++) {
                    if (mapCount == keyWords.length && alreadyMapped[j] == 1) continue;
                    if (similarityMat[i][j] > max) {
                        max = similarityMat[i][j];
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
            if (mapCount == keyWords.length) {
                similarityVec[maxJ] = max;
                alreadyMapped[maxJ] = 1;
            } else if (mapCount == words.length) {
                similarityVec[maxI] = max;
                alreadyMapped[maxI] = 1;
            }
        }

        double sum = 0;
        for (int i = 0; i < similarityVec.length; i++) sum += similarityVec[i];

        return sum / mapCount;
    }

    /**
     * Сравнивает два слова. Ищет расстояние Левенштейна (количество операций для преобразования строки у к строке х).
     * Затем преобразует это количество к 'проценту схожести'. Он предстовляет расстояние Левенштейна в нормированном
     * виде.
     *
     * @param x эталонная строка
     * @param y сравниваемая строка
     * @return 'процент схожести' [~0;1]
     *          ~0 - строки не похожи, требуется ∞ количество преобразований
     *          1  - строки идентичны
     */
    public static double compareWords(String x, String y) {
        int[][]dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j]= j;
                }
                else if (j == 0) {
                    dp[i][j]= i;
                }
                else {
                    dp[i][j]= min(dp[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j]+ 1,
                            dp[i][j - 1]+ 1);
                }
            }
        }

        return 1 / (1 + (double)dp[x.length()][y.length()] / x.length());
    }

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }
}
