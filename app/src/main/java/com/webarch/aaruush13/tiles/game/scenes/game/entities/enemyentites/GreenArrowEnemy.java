package com.webarch.aaruush13.tiles.game.scenes.game.entities.enemyentites;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.webarch.aaruush13.tiles.game.GameManager;
import com.webarch.aaruush13.tiles.game.scenes.game.GameScene;
import com.webarch.aaruush13.tiles.game.scenes.game.entities.EnemyEntity;

import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.opengl.texture.region.TextureRegion;

public class GreenArrowEnemy extends EnemyEntity {

    public GreenArrowEnemy(GameManager gameManager, GameScene gameScene, float x, float y, TextureRegion textureRegion, float speed, int score) {
        super(gameManager, gameScene, x, y, textureRegion, speed, score);
    }

    @Override
    public Body onCreateBody() {
        return PhysicsFactory.createBoxBody(gameScene.getPhysicsWorld(), getX(), getY(), getWidth() * 0.7f, getHeight() * 0.7f, BodyDef.BodyType.DynamicBody, EnemyEntity.fixtureDef);
    }

}