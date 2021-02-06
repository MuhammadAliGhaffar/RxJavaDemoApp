package com.example.rxjavademoapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavademoapp.model.Entry;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt1)
    TextView txt1;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewAdapter = new RecyclerViewAdapter();
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        Observable.just("RxJava Demo App").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                txt1.setText(s);
            }
        });

//        Observable.just("Ali","Adil","Anus","Tahir","Moshin","Talha","Riaz","Asif","Ahad","Muqtadir").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Throwable {
//                mRecyclerViewAdapter.addItemList(s);
//            }
//        });
        Entry entry1=new Entry("PS4",1500,new Date());
        Entry entry2=new Entry("PC",2500,new Date());
        Entry entry3=new Entry("Fridge",1500,new Date());
        Entry entry4=new Entry("TV",7500,new Date());
        Entry entry5=new Entry("Phone",1500,new Date());
        Entry entry6=new Entry("Keyboard",1500,new Date());
        Entry entry7=new Entry("Mouse",15500,new Date());
        Entry entry8=new Entry("Light",15300,new Date());
        Entry entry9=new Entry("Sofa",15020,new Date());
        Entry entry10=new Entry("test",15010,new Date());


        Observable.just(entry1,entry2,entry3,entry4,entry5,entry6,entry7,entry8,entry9,entry10).subscribe(new Consumer<Entry>() {
            @Override
            public void accept(Entry entry) throws Throwable {
                mRecyclerViewAdapter.addEntriesItems(entry);
            }
        });

    }
}