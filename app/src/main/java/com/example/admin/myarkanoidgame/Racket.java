package com.example.admin.myarkanoidgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class Racket{
    protected float x, y, w, h, centerX;
    private int wScreen, hScreen;

    public Racket(int wScreen, int hScreen){
        this.wScreen = wScreen;
        this.hScreen = hScreen;
        w = wScreen/3; // width of the Racket
        h = hScreen/30; // Height of the Racket
        x = (wScreen-w)/2; // x1
        y = 4*hScreen/5-h;  // y1
        centerX = x+w/2;
    }
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(x, y, x+w, y+h, paint); // (x1,y1,x2,y2,paint)
    }
    public void setX1(float newX){
        x = newX;
    }
    public void setCenterX(float newX)
    {
        x = newX-w/2;
    }
    public float getX1(){
        return x;
    }
    public float getX2(){
        return (x+w);
    }
    public float getW(){
        return w;
    }
    public float getY1(){
        return y;
    }
    public float getY2() {
        return y + h;
    }
}
