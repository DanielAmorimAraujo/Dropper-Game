package com.game.dropper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Button class with declaration and relevant functions
 */
public class Button implements GameObject {

    private int cx;
    private int cy;
    private int radius;
    int color;

    /**
     * Button function used to generate a Button
     *
     * @param cx     x value of button centre
     * @param cy     y value of button centre
     * @param radius radius of button
     * @param color  color of button
     */
    public Button(int cx, int cy, int radius, int color) {
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
        this.color = color;
    }

    /**
     * @return cx - circle centre's x
     */
    public int getCx() {
        return cx;
    }

    /**
     * @return cy - circle centre's y
     */
    public int getCy() {
        return cy;
    }

    /**
     * determines if the point is on the button
     *
     * @param mX user input x value
     * @param mY user input y value
     * @return boolean if the point intersects
     */
    public boolean buttonClick(int mX, int mY) {
        return Math.pow(mX - cx, 2) + Math.pow(mY - cy, 2) <= Math.pow(radius, 2);
    }

    /**
     * update function for Button
     * changes color from BLUE to GREEN or GREEN to BLUE (green is active, blue is unactive)
     */
    @Override
    public void update() {
        if (color == Color.BLUE) {
            color = Color.GREEN;
        } else if (color == Color.GREEN) {
            color = Color.BLUE;
        }
    }

    /**
     * draws the button onto the canvas
     *
     * @param canvas in which the game is drawn on
     */
    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setAlpha(100);
        canvas.drawCircle(cx, cy, radius, paint);
    }
}
