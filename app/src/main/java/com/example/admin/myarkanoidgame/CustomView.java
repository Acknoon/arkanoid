package com.example.admin.myarkanoidgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class  CustomView extends View {

    private int sWidth, sHeight;
    private Racket racket;
    private Ball ball;
    private BricksCollection bCollection;
    private Brick brick;
    CountDownTimer ct;
    protected CountDownTimer mTimer;


    public CustomView(Context context) {
        super(context);
        ct = new CountDownTimer(20,30) {
            @Override
            public void onTick(long l) {

            }
            @Override
            public void onFinish() {
                invalidate();
                start();
            }
        }.start();


    }

    public void onDraw(Canvas canvas) {
        // updates
        ball.move(racket);
        // draw
        racket.draw(canvas);
        ball.draw(canvas);
    }

    public boolean onTouchEvent(MotionEvent event) {
        float ex = event.getX();
        racket.setCenterX(ex);
        if(racket.getX1()<0)
            racket.setX1(0);
        if(racket.getX2()>sWidth)
            racket.setX1(sWidth-racket.getW());
//        switch ( event.getAction())
//        {
//            case MotionEvent.ACTION_DOWN:
//                break;
//            case MotionEvent.ACTION_MOVE:
//                racket.setX(ex);
//                if(racket.getX1()<0)
//                    racket.setX(0);
//                if(racket.getX2()>sWidth)
//                    racket.setX(sWidth-racket.getW());
//                break; case MotionEvent.ACTION_UP:
//            break;
//         }
        invalidate();
        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        sWidth = w;
        sHeight = h;
        racket = new Racket(sWidth,sHeight);
        ball = new Ball(sWidth, sHeight);
        bCollection = new BricksCollection(sWidth,sHeight);
    }
}
