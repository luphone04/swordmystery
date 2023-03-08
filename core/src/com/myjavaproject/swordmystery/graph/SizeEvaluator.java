package com.myjavaproject.swordmystery.graph;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.myjavaproject.swordmystery.Resources;


public class SizeEvaluator {
    private Stage measuredStage;
    private Resources resources;

    public static final int BASE_MARGIN = 3;

    // 4x4
    private final int maxTileBaseX;
    private final int maxTileBaseY;

    private float rightSideX;

    public SizeEvaluator(Stage _stage,
                         Resources _res,
                         int maxBaseX,
                         int maxBaseY,
                         float _rightSideX)
    {
        measuredStage = _stage;
        resources = _res;
        maxTileBaseX = maxBaseX;
        maxTileBaseY = maxBaseY;
        rightSideX = _rightSideX;
    }

    // 4x4
    // x (0 -> 3), 0 at the left, maxTileBaseX at the right
    // y (0 -> 3), 0 at the bottom, maxTileBaseY at the top

    public float getBaseScreenX(int baseX) // 0 .. 3
    {
        return measuredStage.getWidth() / 2
                - (resources.TILE_SIZE + BASE_MARGIN)
                * (maxTileBaseX + 1 - baseX);
        // TILE SIZE = 16 px;
        // baseX = 0
    }

    public float getBaseScreenY(int baseY)
    {
        return measuredStage.getHeight() / 2
                - ((resources.TILE_SIZE + BASE_MARGIN) * 2 / 3)
                * ((maxTileBaseY + 1) / 2 - baseY);
    }

    public float getEnemyX(Sprite enemy)
    {
        return (measuredStage.getWidth() * 3 / 4) - enemy.getWidth() / 2;
    }

    public float getEnemyY(Sprite enemy)
    {
        return measuredStage.getHeight() / 2 - enemy.getHeight() / 2;
    }

    public void setRightSideX(float value)
    {
        rightSideX = value;
    }

    public float getRightSideX() {
        return rightSideX;
    }
}
