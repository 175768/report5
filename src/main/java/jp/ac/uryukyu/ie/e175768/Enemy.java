package jp.ac.uryukyu.ie.e175768;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing {

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     * @Override
     */
    public void wounded(int damage){
        setHitPoint(getHitPoint() - damage);
        if( getHitPoint() < 1 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }

    public void attack(LivingThing par) {
        if (!isDead()) {
            int damage = (int) (Math.random() * getAttack());
            int l = (int) (Math.random() * 100);
            if (l <= 30 && damage > 0) {
                damage = damage * 2;
                System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), par.getName(), damage);
                par.wounded(damage);
            } else {
                switch (damage) {
                    case 0:
                        System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), par.getName(), damage);
                        break;
                    default:
                        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), par.getName(), damage);
                        par.wounded(damage);
                }
            }
        }
    }
}
