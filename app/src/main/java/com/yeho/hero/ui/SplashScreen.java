package com.yeho.hero.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import com.yeho.hero.R;
import com.yeho.hero.ui.Home.HomeActivity;

public class SplashScreen extends Activity {

  private final int SPLASH_DISPLAY_LENGTH = 2000; // 2 segundos

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_splash_screen);

    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        Intent mainIntent = new Intent(SplashScreen.this, HomeActivity.class);
        SplashScreen.this.startActivity(mainIntent);
        SplashScreen.this.finish();
      }
    }, SPLASH_DISPLAY_LENGTH);
  }
}
