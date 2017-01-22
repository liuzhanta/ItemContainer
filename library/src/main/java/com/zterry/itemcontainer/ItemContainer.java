package com.zterry.itemcontainer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Desc:单条目布局
 * Author: Terry
 * Date:2016-05-16
 */
public class ItemContainer extends RelativeLayout {

    private static final String TAG = "ItemContainer";
    private int lineDirection = -1;
    private int lineLeftMargins;

    private View topLineView;
    private View bottomLineView;

    /**
     * 单行
     */
    public static final int SINGLE = 0;

    /**
     * 表示item在顶部
     */
    public static final int TOP = 1;

    /**
     * 表示item在中部
     */
    public static final int MIDDLE = 2;

    /**
     * 表示item在底部
     */
    public static final int BOTTOM = 3;
    public static final int NONE = -1;

    private boolean hasLine = true;
    /**
     * 默认位置类型：单条目
     */
    private int defaultLocation = NONE;
    private int TOP_LINE_MARGIN = 0;
    private int BOTTOM_LINE_MARGIN = 1;

    private int location = defaultLocation;

    private int lineHeight = 0;
    private int minHeight = 0;

    public ItemContainer(Context context) {
        super(context);
    }

    private static final int ATTR_ARRAY[] = new int[]{R.attr.ItemLocationType, R.attr.lineMarginDirection, R.attr.hasLine};
    private static final int ATTR_INDEX_ITEMLOCATION = 0;
    private static final int ATTR_INDEX_LINEMARGIN = 1;
    private static final int ATTR_INDEX_HAS_LINE = 2;

    public ItemContainer(Context context, AttributeSet attrs) {
        super(context, attrs);

        lineLeftMargins = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics());
        lineHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, getResources().getDisplayMetrics());
        minHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, getResources().getDisplayMetrics());
        initView();

        final TypedArray taOther = context.obtainStyledAttributes(attrs, ATTR_ARRAY);
        location = taOther.getInteger(ATTR_INDEX_ITEMLOCATION, NONE);
        lineDirection = taOther.getInteger(ATTR_INDEX_LINEMARGIN, -1);
        hasLine = taOther.getBoolean(ATTR_INDEX_HAS_LINE, true);

        taOther.recycle();
        setLineMargins();
    }

    public ItemContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static final String VIEW_TAG_TOP_LINE = "top_line";
    public static final String VIEW_TAG_BOTTOM_LINE = "bottom_line";

    private void initView() {
        if (getLayoutId() != 0) {
            View.inflate(getContext(), getLayoutId(), this);
        }
        addLine();
        setMinimumHeight(minHeight);
        setBackgroundResource(R.drawable.bg_selector_white_to_eee);
    }

    private void addLine() {
        topLineView = new View(getContext());
        addView(topLineView);
        topLineView.setBackgroundColor(getResources().getColor(R.color.divider_color_light));
        topLineView.setTag(VIEW_TAG_TOP_LINE);
        topLineView.setLayoutParams(getLineLayoutParams(topLineView));

        bottomLineView = new View(getContext());
        addView(bottomLineView);
        bottomLineView.setBackgroundColor(getResources().getColor(R.color.divider_color_light));
        bottomLineView.setTag(VIEW_TAG_BOTTOM_LINE);
        bottomLineView.setLayoutParams(getLineLayoutParams(bottomLineView));
    }


    public int getLayoutId() {
        return 0;
    }

    private RelativeLayout.LayoutParams getLineLayoutParams(View view) {
        RelativeLayout.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, lineHeight);
        if (view != null) {
            if (VIEW_TAG_TOP_LINE.equals(view.getTag())) {
                lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            } else {
                lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            }
        }
        return lp;
    }


    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
        setLineMargins();
    }

    protected void setLineMargins() {
        switch (location) {
            case TOP:
                bottomLineView.setLayoutParams(generateLineParam(bottomLineView, true));
                break;
            case MIDDLE:
                topLineView.setVisibility(View.GONE);
                bottomLineView.setVisibility(View.VISIBLE);
                bottomLineView.setLayoutParams(generateLineParam(bottomLineView, true));
                break;
            case BOTTOM:
                topLineView.setVisibility(View.GONE);
                bottomLineView.setVisibility(View.VISIBLE);
                bottomLineView.setLayoutParams(generateLineParam(bottomLineView, false));
                break;
            case SINGLE:
                if (lineDirection == TOP_LINE_MARGIN) {
                    topLineView.setLayoutParams(generateLineParam(topLineView, true));
                } else if (lineDirection == BOTTOM_LINE_MARGIN) {
                    bottomLineView.setLayoutParams(generateLineParam(bottomLineView, true));
                } else {
                    topLineView.setVisibility(View.VISIBLE);
                    bottomLineView.setVisibility(View.VISIBLE);
                    bottomLineView.setLayoutParams(generateLineParam(bottomLineView, false));
                    topLineView.setLayoutParams(generateLineParam(topLineView, false));
                }
                break;
            case NONE:
                topLineView.setVisibility(View.GONE);
                bottomLineView.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    private ViewGroup.LayoutParams generateLineParam(View line, boolean shouldMargin) {
        final LayoutParams layoutParams = (LayoutParams) line.getLayoutParams();
        layoutParams.setMargins(shouldMargin ? lineLeftMargins : 0, 0, 0, 0);
        return layoutParams;
    }

}
