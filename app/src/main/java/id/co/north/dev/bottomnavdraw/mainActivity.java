package id.co.north.dev.bottomnavdraw;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class mainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavigationView();
    }

    public void setupNavigationView(){
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bndUtama);
        if(bottomNavigationView != null){
            Menu menu = bottomNavigationView.getMenu();
            selectFragment(menu.getItem(0));

            bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        selectFragment(item);
                        return false;
                    }
            });
        }
    }

    protected void selectFragment(MenuItem item){
        item.setChecked(true);

        switch (item.getItemId()){
            case R.id.itemDash:
                pushFragment(new dashActivity());
                break;
            case R.id.itemShop:
                pushFragment(new shopActivity());
                break;
            case R.id.itemTrans:
                pushFragment(new transActivity());
                break;
        }
    }

    protected void pushFragment(Fragment fragment){
        if(fragment == null)
            return;

        FragmentManager fragmentManager = getFragmentManager();
        if(fragmentManager != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (fragmentTransaction != null){
                fragmentTransaction.replace(R.id.rootLayout, fragment);
                fragmentTransaction.commit();
            }
        }
    }
}