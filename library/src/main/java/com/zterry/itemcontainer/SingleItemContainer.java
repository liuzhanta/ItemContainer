package com.zterry.itemcontainer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Desc:单条目布局
 * Author: Terry
 * Date:2016-05-16
 */
public class SingleItemContainer extends ItemContainer {

    private static final String TAG = "SingleItemContainer";

    /**
     * Define the text size of title
     */
    private float titleTextSize;

    /**
     * Whether the right black arrow is visible
     */
    private boolean noArrow;

    /**
     * Define the text color of title
     */
    private int titleColorId = Color.WHITE;

    /**
     * Define the left drawable id of title
     */
    private int titleDrawableLeftId;


    /**
     * Define the value of title
     */
    private String itemName;

    private TextView mSingleItemTitleTextView;

    private View rightArrowView;

    private FrameLayout contentContainer;


    public SingleItemContainer(Context context) {
        super(context);
    }

    private int contentLayoutId;

    public SingleItemContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        final TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SingleItemContainer, 0, 0);

        try {
            itemName = ta.getString(R.styleable.SingleItemContainer_title);
            titleColorId = ta.getColor(R.styleable.SingleItemContainer_titleTextColor, Color.WHITE);
            titleTextSize = ta.getDimension(R.styleable.SingleItemContainer_titleTextSize, 16);
            contentLayoutId = ta.getResourceId(R.styleable.SingleItemContainer_contentLayout, 0);
            titleDrawableLeftId = ta.getResourceId(R.styleable.SingleItemContainer_titleDrawableLeft, 0);
            noArrow = ta.getBoolean(R.styleable.SingleItemContainer_noArrow, false);

            initView();
            setItemName(itemName);
            setTitleDrawable(titleDrawableLeftId);
            addContentLayout();

            mSingleItemTitleTextView.setTextColor(titleColorId);
            mSingleItemTitleTextView.setTextSize(titleTextSize);
        } finally {
            ta.recycle();
        }
    }

    private void addContentLayout() {
        if (contentLayoutId == 0) {
            contentContainer.setVisibility(View.GONE);
        } else {
            contentContainer.setVisibility(View.VISIBLE);
            contentContainer.removeAllViews();
            View contentChildView = View.inflate(getContext(), contentLayoutId, null);
            contentContainer.addView(contentChildView);
        }
    }

    public SingleItemContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_single_item_container;
    }

    public void setItemName(String itemName) {
        if (mSingleItemTitleTextView == null) {
            mSingleItemTitleTextView = (TextView) findViewById(R.id.tv_single_item_name);
        }
        mSingleItemTitleTextView.setText(itemName);
    }


    private void setTitleDrawable(int titleDrawableLeftId) {
        if (titleDrawableLeftId != 0) {
            mSingleItemTitleTextView.setCompoundDrawablesWithIntrinsicBounds(titleDrawableLeftId, 0, 0, 0);
            mSingleItemTitleTextView.setCompoundDrawablePadding(10);
        }
    }

    private void initView() {
        contentContainer = (FrameLayout) findViewById(R.id.fl_single_item_content);
        rightArrowView = findViewById(R.id.iv_single_item_right_arrow);
        rightArrowView.setVisibility(noArrow ? View.GONE : View.VISIBLE);
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isNoArrow() {
        return noArrow;
    }

    public void setNoArrow(boolean noArrow) {
        this.noArrow = noArrow;
        rightArrowView.setVisibility(noArrow ? View.GONE : View.VISIBLE);
    }

    public FrameLayout getContentContainer() {
        return contentContainer;
    }

    public void setContentContainer(FrameLayout contentContainer) {
        this.contentContainer = contentContainer;
    }


}
