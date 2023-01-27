package com.example.admin.myarkanoidgame;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;


public class BricksCollection{

    private int wScreen, hScreen;
    public Brick[] list;
    private int counter;
    private int rows, cols;

    public BricksCollection(int wScreen, int hScreen){
        this.wScreen = wScreen;
        this.hScreen = hScreen;
        counter = 0;

    }

    private void level1() {

        rows = 4;
        cols = 8;
        list = new Brick[rows * cols];
        counter = list.length;
        float wTotal = wScreen / cols;
        float w = wTotal * 0.9f;
        float wSpace = wTotal * 0.1f;
        float h = w / 4;
        float hSpace = wSpace;
        float x = wSpace / 2;
        float y = 100;

        for (int i = 0; i < rows * cols; i++) {
            list[i] = new Brick(x, y, w, h);
            x += wTotal;
            if ((i + 1) % cols == 0) {
                x = wSpace / 2;
                y += h + hSpace;
            }
        }
    }


    public void draw(Canvas canvas)
    {
        for (int i = 0; i < list.length; i++)
        {
            if (list[i] != null)
                list[i].draw(canvas);
        }
    }


}
