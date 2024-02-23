package com.hmetao.ticketunion.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.hmetao.ticketunion.utils.LogUtils;

public class NestedScrollView extends androidx.core.widget.NestedScrollView {
    private int height = 0;
    private int originHeight = 0;

    public NestedScrollView(@NonNull Context context) {
        super(context);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        this.originHeight = t;
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        if (target instanceof RecyclerView) {
            LogUtils.d("onNestedPreScroll");
            if (originHeight < height) {
                scrollBy(dx, dy);
                consumed[0] = dx;
                consumed[1] = dy;
            }
        }
        super.onNestedPreScroll(target, dx, dy, consumed, type);
    }
}
