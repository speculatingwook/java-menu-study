package menu.exception;

import java.util.*;
import java.util.stream.Collectors;

public class InputValidation {
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static List<String> isValid(String names) {
        try {
            return Arrays.stream(names.split(","))
                    .map(String::trim)
                    .distinct()  // 중복 제거
                    .collect(Collectors.toList());

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "입력값에 오류가 있습니다.");
        }
    }

    public static Optional<List<String>> foodInputValid(String input) {
        if (input == null || input.isEmpty()) {
            return Optional.empty(); // 입력값이 없으면 Optional.empty() 반환
        }
        try {
            List<String> resultList = new ArrayList<>();
            resultList.addAll(
                    List.of(input.split(","))
                            .stream()
                            .map(String::trim)
                            .collect(Collectors.toList())
            );

            return Optional.of(resultList);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "입력값에 오류가 있습니다.");
        }
    }
}
