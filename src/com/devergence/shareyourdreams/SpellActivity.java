package com.devergence.shareyourdreams;

import java.util.Random;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class SpellActivity extends CustomActivity {
		
	WebView mSpell;
	
    @SuppressLint("NewApi")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell);
        
        
        mSpell = (WebView)findViewById(R.id.spell_view);
        mSpell.loadUrl("file:///android_asset/spell.gif");
        mSpell.setBackgroundColor(0x00000000);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
        mSpell.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        }
        
    }
    
    public void onBallClick(View v)
    {
    	launchSpell();
    	animateSpell();
    	v.setEnabled(false);
    }
    
    
    /**
     * Absolutely random 
     */
    private void launchSpell()
    {        
    	int randomInt = new Random().nextInt(4);
    	
        TextView text = (TextView)findViewById(R.id.spell_text);
        
        switch(randomInt)
        {
        case 0:
        	text.setText(getString(R.string.spell_text0));
        	break;
        case 1:
        	text.setText(getString(R.string.spell_text1));
        	break;
        case 2:
        	text.setText(getString(R.string.spell_text2));
        	break;
        default:
        	text.setText(getString(R.string.spell_text3));
        	break;
        }
          
    }
        
    private void animateSpell()  
    {
    	TextView textInfo = (TextView)findViewById(R.id.spell_info);
    	textInfo.setVisibility(TextView.INVISIBLE);
    	
		Animation fadeIn = new AlphaAnimation(0, 1);
		fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
		fadeIn.setDuration(1000);
		fadeIn.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationEnd(Animation arg0) {

		    	Animation fadeOut = new AlphaAnimation(1, 0);
		    	fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
		    	fadeOut.setStartOffset(3000);
		    	fadeOut.setDuration(1000);
		    	fadeOut.setAnimationListener(new PostSpellAnimationEndsListener());
		    	
		    	mSpell.setVisibility(WebView.VISIBLE);
		    	mSpell.setAnimation(fadeOut);
		    	
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {	}

			@Override
			public void onAnimationStart(Animation arg0) { }
			
		});

		mSpell.setAnimation(fadeIn);
    }
    

	private class PostSpellAnimationEndsListener implements AnimationListener
	{	
		@Override
		public void onAnimationEnd(Animation arg0) {
			mSpell.setVisibility(WebView.INVISIBLE);
			
			TextView text = (TextView)findViewById(R.id.spell_text);
			text.setVisibility(TextView.VISIBLE);
			
			Animation fadeIn = new AlphaAnimation(0, 1);
			fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
			fadeIn.setDuration(1000);
			
			text.setAnimation(fadeIn);
		}
		
		@Override
		public void onAnimationRepeat(Animation arg0) {}

		@Override
		public void onAnimationStart(Animation arg0) {}
		
	}		

    
    
    
}
