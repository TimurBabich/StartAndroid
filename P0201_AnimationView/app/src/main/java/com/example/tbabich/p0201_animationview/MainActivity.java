package com.example.tbabich.p0201_animationview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int MENU_SCALE_ID = 1;
    private static final int MENU_ROTATE_ID = 2;
    private static final int MENU_ALPHA_ID = 3;
    private static final int MENU_TRANSLATE_ID = 4;
    private static final int MENU_SET_ID = 5;

    TextView textMain;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMain = (TextView) findViewById(R.id.textMain);
        registerForContextMenu(textMain);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, MENU_SCALE_ID, 0, "Масштабировать");
        menu.add(0, MENU_ROTATE_ID, 0, "Вращать");
        menu.add(0, MENU_ALPHA_ID, 0, "Прозрачность");
        menu.add(0, MENU_TRANSLATE_ID, 0, "Переместить");
        menu.add(0, MENU_SET_ID, 0, "Комбо");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_SCALE_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case MENU_ROTATE_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
            case MENU_ALPHA_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
            case MENU_TRANSLATE_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.mytranslate);
                break;
            case MENU_SET_ID:
                animation = AnimationUtils.loadAnimation(this, R.anim.myset);
                break;
        }

        textMain.startAnimation(animation);
        return super.onContextItemSelected(item);
    }
}
