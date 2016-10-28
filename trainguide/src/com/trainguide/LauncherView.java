package com.trainguide;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Path;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LauncherView extends RelativeLayout{

	private int mHeight;
    private int mWidth;
	private int dp50 = Utils.dp2px(getContext(), 50);
	private int dp1 = Utils.dp2px(getContext(), 1);
	
	public LauncherView(Context context) {
		super(context ,null);
	}
	
	public LauncherView(Context context, AttributeSet attrs) {
		this(context, attrs ,0);
	}
	
	public LauncherView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}
	
	ImageView citybg, pathway, train, cloud , guardbar ,shadow ,bird;
	
	public void init(){
		LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT);
		lp.addRule(CENTER_HORIZONTAL, TRUE);
        lp.addRule(CENTER_VERTICAL, TRUE);
        lp.setMargins(0, 0, 0, dp50);
        
        
        ImageView bg = new ImageView(getContext());
        bg.setLayoutParams(lp);
        bg.setImageResource(R.mipmap.bg);
        //addView(bg);
        
        citybg = new ImageView(getContext());
        citybg.setLayoutParams(lp);
        citybg.setImageResource(R.mipmap.bg_city);
        addView(citybg);
        
        pathway = new ImageView(getContext());
        pathway.setLayoutParams(lp);
        pathway.setImageResource(R.mipmap.ic_pathway);
        //pathway.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_pathway));
        addView(pathway);
        
        train = new ImageView(getContext());
        train.setLayoutParams(lp);
        train.setImageResource(R.mipmap.ic_train);
        //train.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_train));
        addView(train);
        
        cloud = new ImageView(getContext());
        cloud.setLayoutParams(lp);
        cloud.setImageResource(R.mipmap.ic_could);
        //cloud.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_could));
        addView(cloud);
        
        guardbar = new ImageView(getContext());
        guardbar.setLayoutParams(lp);
        guardbar.setImageResource(R.mipmap.ic_guardbar);
        //guardbar.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_guardbar));
        addView(guardbar);
        
        shadow = new ImageView(getContext());
        shadow.setLayoutParams(lp);
        shadow.setImageResource(R.mipmap.bg_shadow);
        //shadow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.bg_shadow));
        addView(shadow);
        
        
        if(android.os.Build.VERSION.SDK_INT > 21){
        	LayoutParams lp1 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT);
    		lp1.addRule(CENTER_HORIZONTAL, TRUE);
            lp1.addRule(CENTER_VERTICAL, TRUE);
            lp1.setMargins(0, 0, 0, 80);
        	
        	bird = new ImageView(getContext());
        	bird.setLayoutParams(lp1);
        	bird.setImageResource(R.drawable.bird_fly);
            addView(bird);
        }
	}
	
	@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    start();
                }
            },500);
        }
    }
    
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	public void start() {
    	 
    	ObjectAnimator citybgAnimator = ObjectAnimator.ofFloat(citybg,View.TRANSLATION_X, 0,-100);
    	citybgAnimator.setRepeatCount(ObjectAnimator.INFINITE);
    	citybgAnimator.setRepeatMode(ObjectAnimator.RESTART);
    	//mLayerAnimator.setInterpolator();
    	citybgAnimator.setDuration(5*1000);
    	citybgAnimator.start();
    	
    	
    	final Path path = new Path();
        path.lineTo(0.25f, 0.25f);
        path.lineTo(0.5f, -0.25f);
        path.lineTo(0.7f, 0.5f);
        path.lineTo(0.9f, -0.75f);
        path.lineTo(1f, 1f);
 
        // Create the ObjectAnimatpr
        ObjectAnimator trainAnimator = ObjectAnimator.ofFloat(train, View.TRANSLATION_Y,-dp1,0);
        trainAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        trainAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        trainAnimator.setDuration(2*1000);
        // Use the PathInterpolatorCompat
        trainAnimator.setInterpolator(PathInterpolatorCompat.create(path));
        trainAnimator.start();
    	
    	
    	ObjectAnimator cloudAnimator = ObjectAnimator.ofFloat(cloud,View.TRANSLATION_X, 0,-200);
    	cloudAnimator.setRepeatCount(ObjectAnimator.INFINITE);
    	cloudAnimator.setRepeatMode(ObjectAnimator.RESTART);
    	//mLayerAnimator.setInterpolator();
    	cloudAnimator.setDuration(5*1000);
    	cloudAnimator.start();
    	
    	ObjectAnimator guardbarAnimator = ObjectAnimator.ofFloat(guardbar,View.TRANSLATION_X, 100,-400);
    	guardbarAnimator.setRepeatCount(ObjectAnimator.INFINITE);
    	guardbarAnimator.setRepeatMode(ObjectAnimator.RESTART);
    	//mLayerAnimator.setInterpolator();
    	guardbarAnimator.setDuration(1*1000);
    	guardbarAnimator.start();
    	
    	if(android.os.Build.VERSION.SDK_INT > 21){
    		ObjectAnimator birdAnimator = ObjectAnimator.ofFloat(bird,View.TRANSLATION_X, 100,-400);
    		birdAnimator.setRepeatCount(ObjectAnimator.INFINITE);
    		birdAnimator.setRepeatMode(ObjectAnimator.RESTART);
        	//mLayerAnimator.setInterpolator();
    		birdAnimator.setDuration(5*1000);
    		
    		Drawable drawable = bird.getDrawable();
    	    if (drawable instanceof Animatable) {
    	      ((Animatable) drawable).start();
    	    }
    		
    		birdAnimator.start();
    		
    		
    	}
    }
}
