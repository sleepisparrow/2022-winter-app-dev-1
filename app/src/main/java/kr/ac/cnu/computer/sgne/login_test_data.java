package kr.ac.cnu.computer.sgne;

import java.util.ArrayList;
import java.util.List;

public class login_test_data {
    public static List<User> list = new ArrayList<>();

    static {
        list.add(new User("normal", "pw", "일반유저", true, false));
        list.add(new User("admin", "pw", "어드민 유저", true, true));
        list.add(new User("unverified", "pw", "미인증", false, false));
    }

    public static int contains(User target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target))
                return i;
        }
        return -1;
    }
}
