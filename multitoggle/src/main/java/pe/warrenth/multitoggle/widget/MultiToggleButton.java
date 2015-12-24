package pe.warrenth.multitoggle.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;

import java.util.ArrayList;

import pe.warrenth.multitoggle.R;
import pe.warrenth.multitoggle.inter.OnItemChangedListener;
import pe.warrenth.multitoggle.listener.MultiCheckable;

/**
 * Created by 152317 on 2015-12-24.
 */
public class MultiToggleButton extends CompoundButton implements MultiCheckable{

    private int mPosition;
    private ArrayList<Object> items;

    CharSequence[] names;
    private OnItemChangedListener itemChangedListener;

    public void setItemChangedListener(OnItemChangedListener itemChangedListener) {
        this.itemChangedListener = itemChangedListener;
        // test
    }

    public MultiToggleButton(Context context) {
        this(context, null);
    }

    public MultiToggleButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.MultiToggleButton, defStyleAttr, 0);
        names = a.getTextArray(R.styleable.MultiToggleButton_textArray);
        mPosition = a.getInteger(R.styleable.MultiToggleButton_defaultIndex, 0);
        syncTextState();
        a.recycle();
    }

    private void syncTextState() {
        setText(names[mPosition]);
    }

    @Override
    public void setIndex(int index) {
        syncTextState();
        itemChangedListener.onItemChanged((View) items.get(mPosition), index);
    }

    @Override
    public int getIndex() {
        return mPosition;
    }

    @Override
    public void toggle() {
        if(mPosition < names.length) {
            mPosition++;
        } else {
            mPosition = 0;
        }
        setIndex(mPosition);
    }

}
