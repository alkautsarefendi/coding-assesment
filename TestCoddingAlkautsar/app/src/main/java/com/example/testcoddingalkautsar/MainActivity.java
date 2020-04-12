package com.example.testcoddingalkautsar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    private final String movieTitle[] = {
            "AQUAMAN", "Ayat-Ayat Cinta",
            "BAD BOYS", "IP MAN 3",
            "IP MAN 4", "JOKER",
            "Laskar Pelangi", "Sang Pemimpi",
            "Dilan", "Warkop Reborn"
    };

    private final int movieImage[] = {
            R.drawable.aquaman, R.drawable.ayatcinta2,
            R.drawable.badboys, R.drawable.ipman3,
            R.drawable.ipman4, R.drawable.joker,
            R.drawable.laskarpelangi, R.drawable.sangpemimpi,
            R.drawable.dilan, R.drawable.warkopreborn

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerViews();
    }

    private void initRecyclerViews() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<AndroidVersion> av = prepareData();
        AndroidDataAdapter mAdapter = new AndroidDataAdapter(getApplicationContext(), av);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                        Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                        intent.putExtra("name",movieTitle[i]);
                        intent.putExtra("image",movieImage[i]);
                        startActivity(intent);

                        /*switch (i) {
                            case 0:
                                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                                intent.putExtra("name",movieTitle[i]);
                                intent.putExtra("image",movieImage[i]);
                                startActivity(intent);
                                break;
                            case 1:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 3:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 4:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 5:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 6:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 7:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 8:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 9:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 10:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                            case 11:
                                Toast.makeText(view.getContext(), "position= " + i, Toast.LENGTH_LONG).show();
                                break;
                        }*/
                    }
                })
        );
    }

    private ArrayList<AndroidVersion> prepareData() {

        ArrayList<AndroidVersion> av = new ArrayList<>();
        for (int i = 0; i < movieTitle.length; i++) {
            AndroidVersion mAndroidVersion = new AndroidVersion();
            mAndroidVersion.setAndroidVersionName(movieTitle[i]);
            mAndroidVersion.setrecyclerViewImage(movieImage[i]);
            av.add(mAndroidVersion);
        }
        return av;
    }

}
