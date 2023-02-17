package kr.ac.cnu.computer.sgne.DataStructure;

import java.util.InputMismatchException;

public class MultiChoiceQuiz extends Quiz{

    public MultiChoiceQuiz() { }

    public boolean isRightAnswer(Integer answer) {
        if (answer < 1 || answer > 5)
            throw new InputMismatchException("잘못된 객관식 답이 입력됨");
        return isRightAnswer(answer.toString());
    }
}
