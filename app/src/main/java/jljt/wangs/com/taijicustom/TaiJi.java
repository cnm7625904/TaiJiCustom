package jljt.wangs.com.taijicustom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/11/30.
 */

public class TaiJi extends View{
    private Paint blackPaint;//黑色画笔
    private Paint whitePaint;//白色画笔
    private float degrees = 0;//旋转角度
    public TaiJi(Context context) {//this在子类中调用构造方法
        this(context,null);
    }

    public TaiJi(Context context, @Nullable AttributeSet attrs) {//this在子类中调用构造方法
        this(context, attrs,0);
    }

    public TaiJi(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();//初始化
    }
    //初始化画笔
    private void initPaint() {
        blackPaint=new Paint();//创建画笔
        blackPaint.setColor(Color.BLACK);//设置颜色
        blackPaint.setAntiAlias(true);//抗锯齿

        whitePaint=new Paint();
        whitePaint.setColor(Color.WHITE);
        whitePaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=canvas.getWidth();//确定画布宽度
        int height=canvas.getHeight();//确定画布高度
        canvas.translate(width/2,height/2);//将canvas坐标原点移动到画布中心
        int radius=Math.min(width,height)/2-100;//获取半径，在长和宽之间选择小的做半径，减去100让它不必顶格
        RectF rectF=new RectF(-radius,-radius,radius,radius);//绘制一个矩形，绘制参数以此是左上右下
        /**
         * rectF:代表绘制区域
         * startAngle开始角度
         * useCenter是否经过圆心
         * sweepAngle扫过角度
         * blackPaint画笔
         */
        canvas.drawArc(rectF, 90, 180, true, blackPaint);//绘制黑色半圆
        canvas.drawArc(rectF, -90, 180, true, whitePaint);//绘制黑色半圆
        //绘制两个小圆
        int smallRadius = radius / 2; //小圆半径为大圆的一半
        canvas.drawCircle(0, -smallRadius, smallRadius, blackPaint);
        canvas.drawCircle(0, smallRadius, smallRadius, whitePaint);

        //绘制鱼眼（两个更小的圆）
        canvas.drawCircle(0, -smallRadius, smallRadius / 4, whitePaint);
        canvas.drawCircle(0, smallRadius, smallRadius / 4, blackPaint);
    }
    public void setRotate(float degrees) {
        this.degrees = degrees;
        invalidate();//重绘界面
    }
}
