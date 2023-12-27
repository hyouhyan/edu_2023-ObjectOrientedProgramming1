package jp.ac.ait.k22047;

public class Response {
    private int hit;
    private int blow;

    public Response(int hit, int blow){
        this.hit = hit;
        this.blow = blow;
    }
    public Response(){
        this(0, 0);
    }

    public int getHit(){
        return hit;
    }
    public void setHit(int hit){
        this.hit = hit;
    }
    public int getBlow(){
        return blow;
    }
    public void setBlow(int blow){
        this.blow = blow;
    }
}
