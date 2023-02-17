package kr.ac.cnu.computer.sgne.DataStructure;

public class TFQuiz extends Quiz{

    public TFQuiz() { }

    public boolean isRightAnswer(Boolean answer) {
        return isRightAnswer(answer.toString());
    }
}
