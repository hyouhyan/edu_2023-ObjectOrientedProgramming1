package jp.ac.ait.k22047;

public class Equipment {
    private String name;

    public Equipment(String name){
        this.name = name;
    }

    public Equipment(){
        this.name = "装備";
    }

    public String getName() {return name;}
    public void setName(String name){this.name = name;}
}
