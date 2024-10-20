package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    final private List<Character> delimiter = new ArrayList<Character>();

    public Delimiter() {
        initDelimeter();
    }

    public Delimiter(String operand){
        initDelimeter();
        setDelimiter(operand);
        validateDelimiter();
    }

    private void initDelimeter(){
        delimiter.add(',');
        delimiter.add(':');
    }

    private void validateDelimiter(){
        for (char delimiterChar : delimiter) {
            if (Character.isDigit(delimiterChar)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void setDelimiter(String customDelimeters) {
        for (char customDelimiter : customDelimeters.toCharArray()) {
            delimiter.add(customDelimiter);  // 커스텀 구분자 추가
        }
    }

    // 구분자 리스트를 반환하는 메소드
    public String getDelimiters() {
        StringBuilder regexBuilder = new StringBuilder();

        for (int i = 0; i < delimiter.size(); i++) {
            if (i > 0) {
                regexBuilder.append("|");  // 구분자 사이에 "|" 추가
            }
            regexBuilder.append(String.valueOf(delimiter.get(i)));
        }

        return regexBuilder.toString();  // 최종 정규표현식 반환
    }

}
