package cz.cvut.fit.miadp.mvcgame.config;

public class MvcGameConfig 
{

    // Scene config
    public static final int SCENE_WITH = 1280;
    public static final int SCENE_HEIGHT = 720;

    // General config
    public static final int MOVE_STEP = 5;
    public static final double GRAVITY = 3.5;

    // Enemies config
    public static final int ENEMIES_CNT = 10;
    public static final int ENEMIES_MIN_X = 300;
    public static final int ENEMIES_MAX_X = 1180;
    public static final int ENEMIES_MIN_Y = 100;
    public static final int ENEMIES_MAX_Y = 620;
    public static final int ENEMIES_MIN_DISTANCE = 100;
    public static final double ENEMY_B_PROBABILITY = 0.5;

    // Game info properties
    public static final int INFO_POS_X = 10;
    public static final int INFO_POS_Y = 20;

    // Cannons properties
    public static final int CANNON_POS_X = 50;
    public static final int CANNON_POS_Y = SCENE_HEIGHT/2;
    public static final double INIT_POWER = 5.0;
    public static final double POWER_STEP = 0.5;
    public static final double INIT_ANGLE = 0;
    public static final double ANGLE_STEP = Math.PI/20;

    // Collision properties
    public static final long COLLISION_LIFETIME = 1000;
    public static final int HITBOX_SIZE = 20;

}