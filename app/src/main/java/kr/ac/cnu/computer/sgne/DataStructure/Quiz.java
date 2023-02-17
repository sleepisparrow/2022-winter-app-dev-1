package kr.ac.cnu.computer.sgne.DataStructure;

public abstract class Quiz {
    String _id;
    String problem;
    String answer;

    public Quiz() {

    }

    boolean isRightAnswer(String answer) {
        return this.answer.equals(answer);
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
