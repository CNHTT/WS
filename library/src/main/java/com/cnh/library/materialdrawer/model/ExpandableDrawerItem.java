package com.cnh.library.materialdrawer.model;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.v4.view.ViewCompat;
import android.view.View;

import com.mikepenz.fastadapter.utils.ViewHolderFactory;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.view.IconicsImageView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.R;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialdrawer.model.*;
import com.mikepenz.materialdrawer.model.BaseViewHolder;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.List;

/**
 * Created by mikepenz on 03.02.15.
 * NOTE: The arrow will just animate (and rotate) on APIs higher than 11 as the ViewCompat will skip this on API 10
 */
public class ExpandableDrawerItem extends BaseDescribeableDrawerItem<ExpandableDrawerItem, ExpandableDrawerItem.ViewHolder> {

    private Drawer.OnDrawerItemClickListener mOnDrawerItemClickListener;

    protected ColorHolder arrowColor;

    protected int arrowRotationAngleStart = 0;

    protected int arrowRotationAngleEnd = 180;

    public ExpandableDrawerItem withArrowColor(@ColorInt int arrowColor) {
        this.arrowColor = ColorHolder.fromColor(arrowColor);
        return this;
    }

    public ExpandableDrawerItem withArrowColorRes(@ColorRes int arrowColorRes) {
        this.arrowColor = ColorHolder.fromColorRes(arrowColorRes);
        return this;
    }

    public ExpandableDrawerItem withArrowRotationAngleStart(int angle) {
        this.arrowRotationAngleStart = angle;
        return this;
    }

    public ExpandableDrawerItem withArrowRotationAngleEnd(int angle) {
        this.arrowRotationAngleEnd = angle;
        return this;
    }

    @Override
    public int getType() {
        return R.id.material_drawer_item_expandable;
    }

    @Override
    @LayoutRes
    public int getLayoutRes() {
        return R.layout.material_drawer_item_expandable;
    }

    @Override
    public ExpandableDrawerItem withOnDrawerItemClickListener(Drawer.OnDrawerItemClickListener onDrawerItemClickListener) {
        mOnDrawerItemClickListener = onDrawerItemClickListener;
        return this;
    }

    @Override
    public Drawer.OnDrawerItemClickListener getOnDrawerItemClickListener() {
        return mOnArrowDrawerItemClickListener;
    }

    /**
     * our internal onDrawerItemClickListener which will handle the arrow animation
     */
    private Drawer.OnDrawerItemClickListener mOnArrowDrawerItemClickListener = new Drawer.OnDrawerItemClickListener() {
        @Override
        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
            if (drawerItem instanceof com.mikepenz.materialdrawer.model.AbstractDrawerItem && drawerItem.isEnabled()) {
                if (((com.mikepenz.materialdrawer.model.AbstractDrawerItem) drawerItem).getSubItems() != null) {
                    if (((com.mikepenz.materialdrawer.model.AbstractDrawerItem) drawerItem).isExpanded()) {
                        ViewCompat.animate(view.findViewById(R.id.material_drawer_arrow)).rotation(ExpandableDrawerItem.this.arrowRotationAngleEnd).start();
                    } else {
                        ViewCompat.animate(view.findViewById(R.id.material_drawer_arrow)).rotation(ExpandableDrawerItem.this.arrowRotationAngleStart).start();
                    }
                }
            }

            return mOnDrawerItemClickListener != null && mOnDrawerItemClickListener.onItemClick(view, position, drawerItem);
        }
    };

    @Override
    public void bindView(ViewHolder viewHolder, List payloads) {
        super.bindView(viewHolder, payloads);

        Context ctx = viewHolder.itemView.getContext();
        //bind the basic view parts
        bindViewHelper(viewHolder);

        //make sure all animations are stopped
        viewHolder.arrow.setColor(this.arrowColor != null ? this.arrowColor.color(ctx) : getIconColor(ctx));
        viewHolder.arrow.clearAnimation();
        if (!isExpanded()) {
            ViewCompat.setRotation(viewHolder.arrow, this.arrowRotationAngleStart);
        } else {
            ViewCompat.setRotation(viewHolder.arrow, this.arrowRotationAngleEnd);
        }

        //call the onPostBindView method to trigger post bind view actions (like the listener to modify the item if required)
        onPostBindView(this, viewHolder.itemView);
    }

    @Override
    public ViewHolderFactory<ViewHolder> getFactory() {
        return new ItemFactory();
    }

    public static class ItemFactory implements ViewHolderFactory<ViewHolder> {
        public ViewHolder create(View v) {
            return new ViewHolder(v);
        }
    }

    public static class ViewHolder extends BaseViewHolder {
        public IconicsImageView arrow;

        public ViewHolder(View view) {
            super(view);
            arrow = (IconicsImageView) view.findViewById(R.id.material_drawer_arrow);
            arrow.setIcon(new IconicsDrawable(view.getContext(), MaterialDrawerFont.Icon.mdf_expand_more).sizeDp(16).paddingDp(2).color(Color.BLACK));
        }
    }
}
