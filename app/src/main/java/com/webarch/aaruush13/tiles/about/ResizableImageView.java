package com.webarch.aaruush13.tiles.about;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ResizableImageView extends ImageView {

    public ResizableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        Drawable drawable = getDrawable();
        setMeasuredDimension(width, (int) Math.ceil(width * drawable.getIntrinsicHeight() / drawable.getIntrinsicWidth()));
    }

}