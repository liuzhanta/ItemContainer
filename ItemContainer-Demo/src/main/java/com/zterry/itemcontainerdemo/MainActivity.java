package com.zterry.itemcontainerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zterry.itemcontainer.SingleItemContainer;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity  {

    @OnClick(R.id.single_item_1)void onSingleItem01Click(){
        Toast.makeText(this, "onSingleItem01Click", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.single_item_2) void onSingleItem02Click(){
        Toast.makeText(this, "onSingleItem02Click", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.single_item_3) void onSingleItem03Click(){
        Toast.makeText(this, "onSingleItem03Click", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.single_item_4) void onSingleItem04Click(){
        Toast.makeText(this, "onSingleItem04Click", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.single_item_5) void onSingleItem05Click(){
        Toast.makeText(this, "onSingleItem05Click", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.single_item_6) void onSingleItem06Click(){
        Toast.makeText(this, "onSingleItem06Click", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
     
    }


}
