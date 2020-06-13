package kr.ac.jejunu.user;

public class User {
    private Integer id;
    private String name;
    private String status;
    private Integer tired;
    private Integer mental;
    private Integer money;
    private Integer exp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTired() {
        return tired;
    }

    public void setTired(Integer tired) {
        this.tired = tired;
    }

    public Integer getMental() {
        return mental;
    }

    public void setMental(Integer mental) {
        this.mental = mental;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }
}
