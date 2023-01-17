package kr.ac.cnu.computer.sgne.main_page;

public class problem_set {
    boolean is_tested = false;
    String test_name = "테스트";
    int correct = 0, problems = 10;

    problem_set() { }

    public problem_set(boolean is_tested, String test_name, int correct, int problems) {
        this.is_tested = is_tested;
        this.test_name = test_name;
        this.correct = correct;
        this.problems = problems;
    }
}
