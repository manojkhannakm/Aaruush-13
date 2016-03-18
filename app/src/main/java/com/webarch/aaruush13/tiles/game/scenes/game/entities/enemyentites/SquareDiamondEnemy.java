package com.webarch.aaruush13.tiles.game.scenes.game.entities.enemyentites;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.webarch.aaruush13.tiles.game.GameManager;
import com.webarch.aaruush13.tiles.game.scenes.game.GameScene;
import com.webarch.aaruush13.tiles.game.scenes.game.entities.EnemyEntity;

import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.opengl.texture.region.TextureRegion;

public class SquareDiamondEnemy extends EnemyEntity {

    private int health = 1;

    public SquareDiamondEnemy(GameManager gameManager, GameScene gameScene, float x, float y, TextureRegion textureRegion, float speed, int score) {
        super(gameManager, gameScene, x, y, textureRegion, speed, score);
    }

    @Override
    public Body onCreateBody() {
        return PhysicsFactory.createBoxBody(gameScene.getPhysicsWorld(), getX(), getY(), getWidth() * 0.8f, getHeight() * 0.8f, BodyDef.BodyType.DynamicBody, EnemyEntity.fixtureDef);
    }

    @Override
    public void onDestroy() {
        if (health > 0) {
            gameScene.getEntitySpawner().spawnSmallRing(getX(), getY());

            health--;
        } else {
            super.onDestroy();
        }
    }

    public int getHealth() {
        return health;
    }

}