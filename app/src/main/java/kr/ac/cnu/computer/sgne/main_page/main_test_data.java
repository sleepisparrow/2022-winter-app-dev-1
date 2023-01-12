package kr.ac.cnu.computer.sgne.main_page;

import java.util.ArrayList;
import java.util.List;

public class main_test_data {
    static List<problem_set> unTested = new ArrayList<>();
    static List<problem_set> tested = new ArrayList<>();

    static {
        unTested.add(new problem_set(false, "안친 시험 1회", 0, 10));
        unTested.add(new problem_set(false, "안친 시험 2회=", 0, 10));

        tested.add(new problem_set(true, "친 시험 1회", 8, 10));
        tested.add(new problem_set(true, "친 시험 2회", 9, 10));
    }
}

