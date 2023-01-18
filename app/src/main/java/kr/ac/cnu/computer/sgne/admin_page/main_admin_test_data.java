package kr.ac.cnu.computer.sgne.admin_page;

import java.util.ArrayList;
import java.util.List;

public class main_admin_test_data {
    static List<Group> list = new ArrayList<>();

    static {
        list.add(new Group("주간 A 분반", 48));
        list.add(new Group("야간 A 분반", 50));
    }
}
