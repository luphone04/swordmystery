package com.myjavaproject.swordmystery.logic.objects;

public class CharacterRecord {

    public final int levelsForHpUpgrade;
    public final int levelsForHpRegenUpgrade;
    public final int levelsForAttackUpgrade;
    public final int levelsForBonusSpawnUpgrade;
    public final String name;

    public CharacterRecord(int lvlHp, int lvlRegen, int lvlAttack, int lvlBonus, String _name)
    {
        levelsForHpUpgrade = lvlHp;
        levelsForHpRegenUpgrade = lvlRegen;
        levelsForAttackUpgrade = lvlAttack;
        levelsForBonusSpawnUpgrade = lvlBonus;
        name = _name;
    }

    public static String CHAR_NAME_HUMAN = "Human";
    public static String CHAR_NAME_SPIDER = "Spider";
    public static String CHAR_NAME_SKELETON = "Mr.Skeletal";
    public static String CHAR_NAME_GHOST = "Ghost";
    public static String CHAR_NAME_SLIME = "Slimey";

    public static CharacterRecord CHARACTERS[] = {
        new CharacterRecord(2, 2, 4, 4, CHAR_NAME_HUMAN),
        new CharacterRecord(3, 6, 3, 3, CHAR_NAME_SPIDER),
        new CharacterRecord(6, 12, 1, 3, CHAR_NAME_SKELETON),
        new CharacterRecord(4, 4, 2, 4, CHAR_NAME_GHOST),
        new CharacterRecord(3, 3, 4, 1, CHAR_NAME_SLIME)
    };

    public int getMaxHp(int level)
    {
        return 3 + level / levelsForHpUpgrade;
    }

    public int getDmg(int level)
    {
        return 1 + level / levelsForAttackUpgrade;
    }

    public int getHpRestored(int level)
    {
        return 1 + level / levelsForHpRegenUpgrade;
    }

    public float getBonusSpawnReduction(int level)
    {
        int bonusSpawnLvl = level / levelsForBonusSpawnUpgrade;
        return bonusSpawnLvl / (30 + bonusSpawnLvl); // 30 enables diminishing returns, x / ( x + 30 ) < 1
    }

}
