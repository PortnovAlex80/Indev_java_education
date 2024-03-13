package org.usecases;

import java.util.List;
import java.util.stream.Collectors;

public class OddNumberFilterUseCase {
    public List<Integer> filterOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
    }
}
