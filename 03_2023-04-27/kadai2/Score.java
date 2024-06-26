public class Score {
    static int id;
    static String name;
    static int [] subjects = new int[5];

    static String [] subNames = {"国語", "数学", "理科", "社会", "英語"};

    static int getJapanese(){
        return subjects[0];
    }

    static int getMathmatics(){
        return subjects[1];
    }

    static int getScience(){
        return subjects[2];
    }

    static int getSocialStudies(){
        return subjects[3];
    }

    static int getEnglish(){
        return subjects[4];
    }


    static void setJapanese(int value){
        subjects[0] = value;
    }

    static void setMathmatics(int value){
        subjects[1] = value;
    }

    static void setScience(int value){
        subjects[2] = value;
    }

    static void setSocialStudies(int value){
        subjects[3] = value;
    }

    static void setEnglish(int value){
        subjects[4] = value;
    }

    static int getTotal(){
        int sum = 0;
        // for(int i = 0; i < subjects.length; i++) sum += subjects[i];
        for(int point : subjects) sum += point;
        return sum;
    }

    static double getAverage(){
        int sum = getTotal();
        return (double)sum / subjects.length;
    }

    static int getHighScore(){
        int max = 0;
        // for(int i = 0; i < subjects.length; i++) if(subjects[i] > max) max = subjects[i];
        for(int point : subjects) if(point > max) max = point;

        return max;
    }

    static String getHighScoreSubject(){
        String ret = "";
        int max = getHighScore();

        for(int i = 0; i < subjects.length; i++) if(subjects[i] == max){
            if(ret == "") ret = subNames[i];
            else ret += ("," + subNames[i]);
        }
        return ret;
    }

    static int getLowScore(){
        int min = getHighScore();
        for(int point : subjects) if(point < min) min = point;

        return min;
    }

    static String getLowScoreSubject(){
        String ret = "";
        int min = getLowScore();

        for(int i = 0; i < subjects.length; i++) if(subjects[i] == min){
            if(ret == "") ret = subNames[i];
            else ret += ("," + subNames[i]);
        }
        return ret;
    }

    static void printInfo(){
        System.out.println(id + " " + name + " " + "国語" + getJapanese() + "点,数学" + getMathmatics() + "点,理科" + getScience() + "点,社会" + getSocialStudies() + "点,英語" + getEnglish() + "点 合計" + getTotal() + "点 平均" + getAverage() + "点 得意科目" + getHighScoreSubject() + getHighScore() + "点 苦手科目" + getLowScoreSubject() + getLowScore() + "点");
    }
}
