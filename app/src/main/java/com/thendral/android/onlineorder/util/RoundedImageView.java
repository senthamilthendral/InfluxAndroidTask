package com.thendral.android.onlineorder.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.thendral.android.influx.onlineorder.R;

/**
 * The Custom Image View used to make the image view as top rounded corner
 */
public final class RoundedImageView extends AppCompatImageView {
    private Path mMaskPath;
    private Paint mMaskPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mCornerRadius = 10;

    /**
     * Instantiates a new Rounded image view.
     *
     * @param context the context
     */
    public RoundedImageView(Context context) {
        super(context);

        init(context);
    }

    /**
     * Instantiates a new Rounded image view.
     *
     * @param context      the context
     * @param attributeSet the attribute set
     */
    public RoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        init(context);
    }

    /**
     * Instantiates a new Rounded image view.
     *
     * @param context  the context
     * @param attrs    the attrs
     * @param defStyle the def style
     */
    public RoundedImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init(context);
    }

    private void init(Context context) {
        ViewCompat.setLayerType(this, ViewCompat.LAYER_TYPE_SOFTWARE, null);
        mMaskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        mMaskPaint.setColor(context.getResources().getColor(R.color.colorBlack));

        mCornerRadius = (int) context.getResources().getDimension(R.dimen.density_16);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);

        if (w != oldW || h != oldH) {
            generateMaskPath(w, h);
        }
    }

    private void generateMaskPath(int w, int h) {
        mMaskPath = new Path();
        final float[] radii = new float[8];
        // Make Top Left Rounded Corner
        radii[0] = mCornerRadius;
        radii[1] = mCornerRadius;
        // Make Top Right Rounded Corner
        radii[2] = mCornerRadius;
        radii[3] = mCornerRadius;
        // Make Bottom Left Rounded Corner
        radii[4] = 0;
        radii[5] = 0;
        // Make Bottom right Rounded Corner
        radii[6] = 0;
        radii[7] = 0;
        mMaskPath.addRoundRect(new RectF(0, 0, w, h),
                radii, Path.Direction.CW);

        mMaskPath.setFillType(Path.FillType.INVERSE_WINDING);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (canvas.isOpaque()) { // If canvas is opaque, make it transparent
            canvas.saveLayerAlpha(0, 0, canvas.getWidth(), canvas.getHeight(), 255, Canvas.ALL_SAVE_FLAG);
        }

        super.onDraw(canvas);

        if (mMaskPath != null) {
            canvas.drawPath(mMaskPath, mMaskPaint);
        }
    }
}