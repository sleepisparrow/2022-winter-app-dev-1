package kr.ac.cnu.computer.quizapp;

public class Quiz {
    int total_questions;
    int correct_answers;
    String library_num = "응시기록";

    public Quiz(int total_questions, int correct_answers, int library_num){
        this.total_questions = total_questions;
        this.correct_answers = correct_answers;
        this.library_num += library_num;
    }

    public String getLibrary_num(){
        return library_num;
    }

    public String getCorrect_answers() {
        return "맞은개수:" + correct_answers;
    }

    public int getTotal_questions(){
        return total_questions;
    }

    public String getWrong_answers(){
        int wrong_answers = total_questions - correct_answers;
        return "틀린개수:" + wrong_answers;
    }
}
