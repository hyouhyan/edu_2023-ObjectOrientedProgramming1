package jp.ac.ait.k22047;

import java.util.Random;
import java.util.Scanner;

public class SimpleRPG {

    // このクラスでは、画面からの入力をいろいろなメソッドで行うため、
    // フィールド化しておく
    final static Scanner scanner = new Scanner(System.in);

    Hero hero;
    Enemy enemy;

    /**
     * 勇者を生成して返すメソッド
     * @return
     */
    Hero createHero() {

        //勇者の名前を入力させます
        System.out.println("勇者の名前を入力");
        String name = scanner.nextLine();

        // 以下の表に従ってパラメータを生成
        Hero hero = new Hero( // パラメータ	ランダム範囲
                name,
                new Random().nextInt(41) + 80,  // HP	80 〜 120
                new Random().nextInt(8) + 8,   // ATK	8 〜 15
                new Random().nextInt(8) + 8,   // DEF	8 〜 15
                new Random().nextInt(8) + 8);  // AGI	8 〜 15

        hero.setWeapon(new Weapon("黒板消し", 3));
        return hero;
    }

    Enemy createEnemy() {

        final String[] ENEMY_NAMES = {"Java", "C-Lang", "Python", "Ruby", "Mojo"};

        // 上記配列から、ランダムに1つだけの名前を抽出して敵の名前とする。
        String name = ENEMY_NAMES[new Random().nextInt(ENEMY_NAMES.length)];

        Enemy enemy = new Enemy( // パラメータ	ランダム範囲
                name,
                new Random().nextInt(151) + 50,  // HP  	50 〜 200
                new Random().nextInt(11) + 10,  // ATK	10 〜 20
                new Random().nextInt(11) + 5,   // DEF	5 〜 15
                new Random().nextInt(11) + 10); // AGI	10 〜 20

        return enemy;

    }

    /**
     *  勇者の行動
     * @return falseの場合続行不能
     */
    boolean heroAction() {
        // 勇者の1回分の行動決定と行動を行わせるメソッド

        // 画面より、攻撃か逃亡かを選択させ、その行動結果を画面に表示します
        System.out.println(hero.getName() + "の行動を決めてください(1: 攻撃, それ以外: 逃亡)");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            // 攻撃だった場合
            AttackResult ret = hero.attack(enemy);
            System.out.println(enemy.getName() + "に" + ret.damage + "のダメージ");
            if (ret.state == AttackResult.BATTLE_END) {
                // 戦闘終了
                System.out.println(enemy.getName() + "を倒しました。ゲームクリア。");
                return false; // 続行不能
            }
            showHp();
            // 戻り値は、行動により戦闘続行可否をbooleanで返します
            return true;
        } else {
            // 逃亡だった場合
            System.out.println(hero.getName() + "は逃亡しました。ゲームオーバー");
            return false; // 続行不能
        }
    }

    void showHp(){
        System.out.println("残りHP, " + hero.getName() + ": " + hero.getHp() + ", " + enemy.getName() + ": " + enemy.getHp());
    }

    boolean enemyAction() {
        // 敵の1回分の攻撃行動を行わせるメソッド（敵は攻撃の行動のみ行います）
        // 攻撃だった場合
        AttackResult ret = enemy.attack(hero);
        System.out.println(hero.getName() + "に" + ret.damage + "のダメージ");
        if (ret.state == AttackResult.BATTLE_END) {
            // 戦闘終了
            System.out.println(hero.getName() + "は無残にも倒れてしまった。ゲームオーバー");
            return false; // 続行不能
        }
        showHp();
        // 戻り値は、行動により戦闘続行可否をbooleanで返します
        return true;
    }

    void battleLoop() {
        //戦闘処理の無限ループを用意します
        while(true) {
            // 無限ループ内では、勇者と敵の素早さを比較し行動順序を入れ替え、それぞれの行動を行います
            // 行動により戦闘続行不可能になった場合は、その場で無限ループを抜け、メソッドを終了します
            if (hero.getAgi() >= enemy.getAgi()) {
                // 勇者のほうが早い
                if (!heroAction()) return;
                if (!enemyAction()) return;
            } else {
                if (!enemyAction()) return;
                if (!heroAction()) return;
            }
        }
    }

    public static void main(String[] args) {
        SimpleRPG app = new SimpleRPG();

        app.hero = app.createHero();
        System.out.println(app.hero.toString());
//        System.out.println("勇者: " + app.hero.getName() + " HP:" + app.hero.getHp() + " ATK:" + app.hero.getAtk() + " DEF:" + app.hero.getDef() + " AGI:" + app.hero.getAgi());
        app.enemy = app.createEnemy();
        System.out.println(app.enemy.toString());
//        System.out.println("敵  : " + app.enemy.getName() + " HP:" + app.enemy.getHp() + " ATK:" + app.enemy.getAtk() + " DEF:" + app.enemy.getDef() + " AGI:" + app.enemy.getAgi());

        app.battleLoop();
    }


}
