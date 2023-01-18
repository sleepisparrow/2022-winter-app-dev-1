package kr.ac.cnu.computer.sgne.admin_studybookModify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kr.ac.cnu.computer.sgne.R;

public class studybookModifyFrag1_2 extends Fragment {

    public studybookModifyFrag1_2(){

    }

    @Nullable
    @Override
    /**
     * 아래 메서드가 MainActivity에서 하는 onCreate랑 같은 역할임.
     * 나중에 데이터 받아서 문제 받아올 때 해당 코드 아래 메서드 안에 넣으면 됨.
     */
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.studybook_modify_fragment1_2, container, false);
    }

}
