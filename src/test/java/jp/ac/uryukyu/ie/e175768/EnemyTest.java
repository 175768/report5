package jp.ac.uryukyu.ie.e175768;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {
    /**
     * 「死んでる状態では攻撃できない」ことを確認。
     */

    public void attack () {
        int heroHP=10;
        Hero hero = new Hero("テスト勇者", heroHP, 5);
        Enemy enemy = new Enemy("テストスライム", 6, 3);
        enemy.setDead(true);
        for ( ; ; ) {
            if (hero.getHitPoint()>0) {
                enemy.attack(hero); //乱数で0ダメージとなることもあるため、複数回実行してみる。
            }
            else {
                break;
            }
        }
        assertEquals(heroHP, hero.getHitPoint());
    }
}