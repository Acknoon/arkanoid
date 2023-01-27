package com.example.admin.myarkanoidgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ball {

    protected float r, dx, dy;
    protected float cx, cy;
    private int wScreen, hScreen;
    protected float x3;
    protected float x4;
    protected float y3;
    protected float y4;


    public Ball(int wScreen, int hScreen) {
        this.wScreen = wScreen;
        this.hScreen = hScreen;
        cx = wScreen / 2;
        r = 15;
        cy = hScreen / 2;
        dx = 10;
        dy = 10;
        x3 = cx - r;
        x4 = cx + r;
        y3 = cy - r;
        y4 = cy + r;

    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(cx, cy, r, paint);
    }

    public void move(Racket s) {
        cx += dx;
        cy += dy;
        if(gameOver()){
            cx = wScreen/2;
            cy = hScreen/2;
        }
        if(glichWall())
            dx = -dx;
        if(glichCeiling())
            dy = -dy;
        if(cRacket(s))
            dy = -dy;
    }
    public boolean glichWall() {
        if (cx + r >= wScreen)
            return true;
        if (cx - r <= 0)
            return true;
        return false;
    }
    public boolean glichCeiling(){
        if(cy - r <= 0)
            return true;
        return false;
    }
    public boolean cRacket(Racket k){
        float x1 = k.getX1();
        float x2 = k.getX2();
        float y1 = k.getY1();
        float y2 = k.getY2();
        if(y4 >= y1 && x3 <= x2 && x4 >= x1 && y3 <= y2)
            return true;
        return false;
    }
    public boolean cBrick(Brick b){
        float x1 = b.getX();
        float x2 = b.getX() + b.getW();
        float y1 = b.getY();
        float y2 = b.getY() + b.getH();
        if(y4 >= y1 && x3 <= x2 && x4 >= x1 && y3 <= y2)
            return true;
        return false;
    }
    private boolean gameOver(){
        if(cy + r >= hScreen)
            return true;
        return false;
    }
    public float getX(){
        return cx;
    }
    public float getY(){
        return cy;
    }
    public float getRadius(){
        return r;
    }
 }

