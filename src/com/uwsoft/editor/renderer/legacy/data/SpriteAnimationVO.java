package com.uwsoft.editor.renderer.legacy.data;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.uwsoft.editor.renderer.components.spine.SpineDataComponent;
import com.uwsoft.editor.renderer.components.sprite.SpriteAnimationComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpriteAnimationVO extends MainItemVO {

    public String animationName = "";
    public int fps = 24;
    public String currentAnimation;
    public HashMap<String, FrameRange> frameRangeMap = new HashMap<>();
    public int playMode = 0;

    public SpriteAnimationVO() {

    }

    public SpriteAnimationVO(SpriteAnimationVO vo) {
        super(vo);
        animationName = vo.animationName;
        fps = vo.fps;
        frameRangeMap = vo.frameRangeMap;
    }

    @Override
    public void loadFromEntity(Entity entity) {
        super.loadFromEntity(entity);

        SpriteAnimationComponent spriteAnimationComponent = entity.getComponent(SpriteAnimationComponent.class);
        animationName = spriteAnimationComponent.animationName;
        fps = spriteAnimationComponent.fps;
        frameRangeMap = spriteAnimationComponent.frameRangeMap;
        currentAnimation = spriteAnimationComponent.currentAnimation;
        if(spriteAnimationComponent.playMode == Animation.PlayMode.NORMAL) playMode = 0;
        if(spriteAnimationComponent.playMode == Animation.PlayMode.REVERSED) playMode = 1;
        if(spriteAnimationComponent.playMode == Animation.PlayMode.LOOP) playMode = 2;
        if(spriteAnimationComponent.playMode == Animation.PlayMode.LOOP_REVERSED) playMode = 3;
        if(spriteAnimationComponent.playMode == Animation.PlayMode.LOOP_PINGPONG) playMode = 4;
        if(spriteAnimationComponent.playMode == Animation.PlayMode.LOOP_RANDOM) playMode = 5;
        if(spriteAnimationComponent.playMode == Animation.PlayMode.NORMAL) playMode = 6;
    }
}
