package co.iteo.rxlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.databinding.DataBindingUtil;

import java.util.ArrayList;

import co.iteo.rxlist.databinding.ActivityMainBinding;
import rx.Observable;
import rx.Observer;
import rx.Subscription;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ArrayList list;
    private ListAdapter adapter;
    private Observer<Item> listObserver;
    private ArrayList<Item> items;
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        list = new ArrayList();
        adapter = new ListAdapter(this, list);
        binding.lvExample.setAdapter(adapter);

        items = new ArrayList<>();
        items.add(new Item(1, "pierwszy"));
        items.add(new Item(2, "drugi"));

    }


    private void listObserver() {
        listObserver = new Observer<Item>() {
            @Override
            public void onCompleted() {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Item item) {
                list.add(item);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        listObserver();
        subscription = Observable.from(items).subscribe(listObserver);
    }

    @Override
    protected void onPause() {
        super.onPause();
        subscription.unsubscribe();
    }
}
