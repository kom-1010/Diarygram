package kr.ac.jejunu.post;

public class DaoFactory {
    public PostDao getPostDao() {
        return new PostDao(getConnectionMaker());
    }

    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }

    private JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }


}
