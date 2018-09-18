package mybatis.po;

public class OrdersCustom extends Orders {
    //下面添加用户属性
    private String username;
    private String sex;
    private String address;

    public OrdersCustom() {
    }

    public OrdersCustom(String username, String sex, String address) {
        this.username = username;
        this.sex = sex;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrdersCustom{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
