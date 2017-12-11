package jp.ac.uryukyu.ie.e175768;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead(){
        return  dead;
    }

    public String getName(){
        return name;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getAttack() { return attack; }

    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }


    /**
     * 攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param
     */
    public void attack(LivingThing opponent) {
        if (hitPoint > 0) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name,opponent.name, damage);
        opponent.wounded(damage);
        }
    }

/**
 * 攻撃されたときのダメージ処理をするメソッド。
 * 指定されたダメージを hitPoint から引き、死亡判定を行う。
 * @param damage 受けたダメージ
 */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 1 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}