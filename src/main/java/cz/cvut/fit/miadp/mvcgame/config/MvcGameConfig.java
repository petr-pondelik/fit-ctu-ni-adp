package cz.cvut.fit.miadp.mvcgame.config;

public class MvcGameConfig 
{
    // Scene config
    public static final int SCENE_WITH = 1280;
    public static final int SCENE_HEIGHT = 720;

    // General config
    public static final int MOVE_STEP = 5;
    public static final int ENEMIES_CNT = 10;
    public static final double GRAVITY = 9.8;

    // Game info properties
    public static final int INFO_POS_X = 10;
    public static final int INFO_POS_Y = 20;

    // Cannons properties
    public static final int CANNON_POS_X = 50;
    public static final int CANNON_POS_Y = SCENE_HEIGHT/2;
    public static final int INIT_POWER = 5;
    public static final int POWER_STEP = 1;
    public static final double INIT_ANGLE = 0;
    public static final double ANGLE_STEP = Math.PI/20;

}