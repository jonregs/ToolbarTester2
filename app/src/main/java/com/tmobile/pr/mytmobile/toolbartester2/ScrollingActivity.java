package com.tmobile.pr.mytmobile.toolbartester2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerViewScrollListener scrollListener;
    private Toolbar toolbar;
    private float computedValue;
    private float cardHeight;
    private float scrollY;

    String TAG = "ToolbarTester2";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        setUpToolbar();

        recyclerView = findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        scrollListener = new RecyclerViewScrollListener();

        List<Model> dataModel = new ArrayList<>();

        dataModel.add(new Model("Hello World", "inge all your favorite shows at no extra charge when you sign up for 2+ lines of T-Mobile ONE.\n" +
                "        Offer subject to change. Receive Netflix Standard 2-screen (up to $9.99/mo. value) while you maintain\n" +
                "        2+ qual’g T-Mobile ONE lines in good standing. Netflix account  compatible device required."));
        dataModel.add(new Model("Hello World", "inge all your favorite shows at no extra charge when you sign up for 2+ lines of T-Mobile ONE.\n" +
                "        Offer subject to change. Receive Netflix Standard 2-screen (up to $9.99/mo. value) while you maintain\n" +
                "        2+ qual’g T-Mobile ONE lines in good standing. Netflix account  compatible device required."));
        dataModel.add(new Model("Hello World", "inge all your favorite shows at no extra charge when you sign up for 2+ lines of T-Mobile ONE.\n" +
                "        Offer subject to change. Receive Netflix Standard 2-screen (up to $9.99/mo. value) while you maintain\n" +
                "        2+ qual’g T-Mobile ONE lines in good standing. Netflix account  compatible device required."));
        dataModel.add(new Model("Hello World", "inge all your favorite shows at no extra charge when you sign up for 2+ lines of T-Mobile ONE.\n" +
                "        Offer subject to change. Receive Netflix Standard 2-screen (up to $9.99/mo. value) while you maintain\n" +
                "        2+ qual’g T-Mobile ONE lines in good standing. Netflix account  compatible device required."));
        dataModel.add(new Model("Hello World", "inge all your favorite shows at no extra charge when you sign up for 2+ lines of T-Mobile ONE.\n" +
                "        Offer subject to change. Receive Netflix Standard 2-screen (up to $9.99/mo. value) while you maintain\n" +
                "        2+ qual’g T-Mobile ONE lines in good standing. Netflix account  compatible device required."));
        dataModel.add(new Model("Hello World", "inge all your favorite shows at no extra charge when you sign up for 2+ lines of T-Mobile ONE.\n" +
                "        Offer subject to change. Receive Netflix Standard 2-screen (up to $9.99/mo. value) while you maintain\n" +
                "        2+ qual’g T-Mobile ONE lines in good standing. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required."));
        dataModel.add(new Model("Hello World", "inge all your favorite shows at no extra charge when you sign up for 2+ lines of T-Mobile ONE.\n" +
                "        Offer subject to change. Receive Netflix Standard 2-screen (up to $9.99/mo. value) while you maintain\n" +
                "        2+ qual’g T-Mobile ONE lines in good standing. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required."));
        dataModel.add(new Model("Hello World", "inge all your favorite shows at no extra charge when you sign up for 2+ lines of T-Mobile ONE.\n" +
                "        Offer subject to change. Receive Netflix Standard 2-screen (up to $9.99/mo. value) while you maintain\n" +
                "        2+ qual’g T-Mobile ONE lines in good standing. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required."));
        dataModel.add(new Model("Hello World", "inge all your favorite shows at no extra charge when you sign up for 2+ lines of T-Mobile ONE.\n" +
                "        Offer subject to change. Receive Netflix Standard 2-screen (up to $9.99/mo. value) while you maintain\n" +
                "        2+ qual’g T-Mobile ONE lines in good standing. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required."));
        dataModel.add(new Model("Hello World", "inge all your favorite shows at no extra charge when you sign up for 2+ lines of T-Mobile ONE.\n" +
                "        Offer subject to change. Receive Netflix Standard 2-screen (up to $9.99/mo. value) while you maintain\n" +
                "        2+ qual’g T-Mobile ONE lines in good standing. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required."));
        dataModel.add(new Model("Hello World", "inge all your favorite shows at no extra charge when you sign up for 2+ lines of T-Mobile ONE.\n" +
                "        Offer subject to change. Receive Netflix Standard 2-screen (up to $9.99/mo. value) while you maintain\n" +
                "        2+ qual’g T-Mobile ONE lines in good standing. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required.g. Netflix account  compatible device required."));



        myAdapter = new MyAdapter(dataModel);
        recyclerView.setAdapter(myAdapter);
    }

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.getBackground().setAlpha(0);
    }

    private class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            scrollY = recyclerView.computeVerticalScrollOffset();
            cardHeight = 419;
            computedValue = ((Math.abs(scrollY)/Math.abs(cardHeight))*(229-51))+51;

            Log.i(TAG, "cardHeight: " + cardHeight);
            Log.i(TAG, "scrollY: " + scrollY);
            Log.i(TAG, "computedValue: " + (int) computedValue);

            if (scrollY <= cardHeight) {
                toolbar.getBackground().mutate().setAlpha((int) computedValue);
            } else if (cardHeight > scrollY)
            {
                computedValue = 229;
                toolbar.getBackground().mutate().setAlpha((int) computedValue);
            }

        }
    }

    private int getCardHeight() {
        int viewHeight = myAdapter.getViewHeight();
        return viewHeight;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnScrollListener(scrollListener);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume: computedValue" + computedValue );
        Log.i(TAG, "onResume: scrollY" + scrollY );
        Log.i(TAG, "onResume: cardHeight" + cardHeight );

        recyclerView.addOnScrollListener(scrollListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (recyclerView == null) {
            return;
        }
        recyclerView.removeOnScrollListener(scrollListener);
    }
}
