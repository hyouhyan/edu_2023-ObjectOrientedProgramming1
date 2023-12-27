public class Addresses {
    private String name;
    private String phonenum;

    public Addresses(){}

    public Addresses(String name, String phonenum){
        this.name = name;
        this.phonenum = phonenum;
    }

    public String getName(){
        return name;
    }

    public String getPhonenum(){
        return phonenum;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhonenum(String phonenum){
        this.phonenum = phonenum;
    }
}
