package com.example.admin.myarkanoidgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Brick{
    protected float placementX, placementY;
    protected float bricksH, bricksW;




    public Brick(float x, float y, float w, float h){
        this.placementX = x;
        this.placementY = y;
        this.bricksW = w;
        this.bricksH = h;

    }
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawRect(placementX, placementY, placementX + bricksW, placementY + bricksH, paint);
    }
    public void contactBall(Ball s){
        float x3,x4,y3,y4;
        x3 = s.cx - s.r;
        x4 = s.cx + s.r;
        y3 = s.cy - s.r;
        y4 = s.cy + s.r;
        if(x4 >= placementX && x3 <= placementX + bricksW && y4 <= placementY + bricksH && y3 >= placementY){
        }
    }
    public float getX(){
        return placementX;
    }
    public float getY(){
        return placementY;
    }
    public float getW(){
        return bricksW;
    }
    public float getH(){
        return bricksH;
    }
}

