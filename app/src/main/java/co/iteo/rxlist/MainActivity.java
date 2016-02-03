package co.iteo.rxlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.databinding.DataBindingUtil;

import java.util.ArrayList;

import co.iteo.rxlist.databinding.ActivityMainBinding;
import rx.Observable;
import rx.Observer;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ArrayList list;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main);
        list = new ArrayList();
        adapter = new ListAdapter(this, list);
        binding.lvExample.setAdapter(adapter);
        listObserver();
    }


    private void listObserver() {
        Observer<Item> listObserver = new Observer<Item>() {
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
        Item[] item = {new Item(1, "pierwszy"), new Item(2, "drugi")};
        Observable.from(item).subscribe(listObserver);
    }

}
