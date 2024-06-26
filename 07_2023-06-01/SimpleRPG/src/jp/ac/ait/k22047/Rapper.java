package jp.ac.ait.k22047;
import java.util.Random;

public class Rapper extends Hero implements IHeroJob{
    public Rapper(String name, int hp, int atk, int def, int agi){
        super(name, hp, atk, def, agi);
    }

    @Override
    public String getJobName() {
        return "ラッパー";
    }

    @Override
    public String getSpecialAttackName() {
        return "MCバトルを仕掛ける";
    }

    @Override
    public AttackResult specialAttack(CharacterBase target) {
        System.out.println(this.getName() + "が" + target.getName() +"にMCバトルを仕掛けた!");
        // 引数の攻撃対象に対して与えることのできるダメージを算出
        // 与えるダメージ = 自身の攻撃力 - 敵の防御力 / 2 (小数点以下切り上げ) に、-3〜+3のランダムな値を加算
        int damage = (int)Math.ceil((double)this.getAtk() - (target.getDef() / 2.0))
                + (new java.util.Random().nextInt(7) - 3); // ← −3〜+3のランダムな値

        int successRate = 40;  // 攻撃成功率

        // 上記成功判定で攻撃が成功する(それ以外は失敗)
        if (new Random().nextInt(100) >= successRate) { // 失敗判定
            AttackResult ret = new AttackResult();
            ret.damage = 0;   // ダメージ処理をしないで0を返す
            System.out.println("うまく韻が踏めず、ビミョーな空気になった…");
            return ret;
        }

        // 攻撃成功時は常に4倍のダメージ
        damage *= 4;
        System.out.println("完璧な韻が踏め、会場が沸いた!ダメージが4倍に!");

        // 引数の攻撃対象がダメージを受ける
        boolean isBattleEnd = target.receiveDamage(damage);

        // 攻撃を行ったことによる行動結果を生成して返す
        AttackResult ret = new AttackResult();
        ret.damage = damage;
        if (isBattleEnd) {
            // 戦闘終了の条件を満たす場合、勇者の勝利となる
            ret.state = AttackResult.BATTLE_END;
        }

        return ret;
    }
}
