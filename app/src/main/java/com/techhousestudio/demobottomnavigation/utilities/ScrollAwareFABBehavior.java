package com.techhousestudio.demobottomnavigation.utilities;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {

    public ScrollAwareFABBehavior(Context context, AttributeSet attributeSet) {
        super();
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);

        int count = coordinatorLayout.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = coordinatorLayout.getChildAt(i);
            if (view instanceof AppBarLayout) {
                if (view.getBottom() <= view.getHeight() / 2) {
                    if (child.getVisibility() == View.VISIBLE) {
                        child.hide();
                    }
                } else {
                    if (child.getVisibility() == View.GONE) {
                        child.show();
                    }
                }
                break;
            }
        }
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

}
