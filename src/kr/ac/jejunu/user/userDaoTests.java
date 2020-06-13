package kr.ac.jejunu.user;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class userDaoTests {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Integer id = 1;
        String name = "jinsu";
        String status = "normal";
        Integer tired = 0;
        Integer mental  = 0;
        Integer money = 0;
        Integer exp = 0;
        UserDao userDao = new UserDao();
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getStatus(), is(status));
        assertThat(user.getTired(), is(tired));
        assertThat(user.getMental(), is(mental));
        assertThat(user.getMoney(), is(money));
        assertThat(user.getExp(), is(exp));
    }
}
