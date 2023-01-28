package kr.ac.cnu.computer.sgne;

import androidx.annotation.NonNull;

public class WorkBook {
    String name;

    WorkBook(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
