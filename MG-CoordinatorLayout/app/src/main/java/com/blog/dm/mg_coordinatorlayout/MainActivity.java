package com.blog.dm.mg_coordinatorlayout;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MainActivity extends ActionBarActivity {

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private View mHeaderLayout;
    private ImageView mImageViewHeader;
    private TextView mHeaderRating;
    private Fragment fragment;

    private static final String FRAGMENT_TAG="dummyFrag";
    public static final String BACKDROP_URL_BASE_PATH="http://image.tmdb.org/t/p/w500/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);
        mHeaderLayout = findViewById(R.id.headerLayout);
        mImageViewHeader = (ImageView) mHeaderLayout.findViewById(R.id.header_img);
        mHeaderRating = (TextView) mHeaderLayout.findViewById(R.id.current_rating);

        //Define o titulo directamente no Collapsible toolbar para poder fazer o efeito de dimunuir e aumentar
        //quando comprimida ou expandida respectivamente
        mCollapsingToolbarLayout.setTitle("Minions");

        //Carrega a imagem para o imageview utilizando o picasso
        String url = BACKDROP_URL_BASE_PATH+"/sLbXneTErDvS3HIjqRWQJPiZ4Ci.jpg";
        Log.i("MainActivity", "Url is: " + url);
        PicassoUtils.with(getApplicationContext()).load(url).into(mImageViewHeader);

        //Define o valor do rating
        mHeaderRating.setText("7.1");

        if(savedInstanceState!=null){
            fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        }
        else{
            fragment = new DummyFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.details_container,fragment,FRAGMENT_TAG).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
