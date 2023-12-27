package jp.ac.ait.k22047;

public class Manager {
    private int count;
    private Answer answer;

    public Manager(){
        count = 0;
        answer = new Answer();
    }

    public int getCount(){
        return count;
    }
    public Answer getAnswer(){
        return answer;
    }
    public Response solve(String in){
        count++;

        int hit = 0, blow = 0;
        for(int i = 0; i < Answer.DIGITS; i++){
            if(answer.get().indexOf(in.charAt(i)) != -1){
                blow++;
            }
            if(answer.get().charAt(i) == in.charAt(i)){
                blow--;
                hit++;
            }
        }

        return new Response(hit, blow);
    }
}
