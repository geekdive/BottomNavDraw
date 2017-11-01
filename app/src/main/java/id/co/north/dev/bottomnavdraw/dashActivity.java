package id.co.north.dev.bottomnavdraw;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by dev on 01/11/17.
 */

public class dashActivity extends Fragment {

    ListView listItemdata;

    String[] namapemainbola = {
            "hazard",
            "oscar",
            "david luiz",
            "juan mata",
            "dybala",
            "luis suarez",
            "k.mbappe",
            "messi",
            "neymar",
            "ozil",
            "benzema",
            "ronaldo",
            "reus",
            "pogba",
            "muller",
            "jordi alba",
            "de gea",
            "manuel neuer",

    };

    public View onCreateView(
            LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
            View view = layoutInflater.inflate(R.layout.dash_activity, container, false);

            listItemdata = (ListView)view.findViewById(R.id.dataList);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, namapemainbola);
            listItemdata.setAdapter(arrayAdapter);

            listItemdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getActivity(), "Your chose is " + namapemainbola[i], Toast.LENGTH_SHORT).show();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    shopActivity llf = new shopActivity();
                    ft.replace(R.id.rootLayout, llf);
                    ft.commit();
                }
            });
            return view;
    }
}