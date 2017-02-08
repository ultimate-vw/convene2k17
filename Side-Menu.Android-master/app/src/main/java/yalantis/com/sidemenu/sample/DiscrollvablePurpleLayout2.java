package yalantis.com.sidemenu.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

//import com.flavienlaurent.discrollview.R;
import com.flavienlaurent.discrollview.lib.Discrollvable;

/**
 *
 */
public class DiscrollvablePurpleLayout2 extends LinearLayout implements Discrollvable {

    private static final String TAG = "DiscrollvablePurpleLayout";


    private View mPurpleView5;
    private View mPurpleView6;


    private float mPurpleView5TranslationX;
    private float mPurpleView6TranslationX;



    public DiscrollvablePurpleLayout2(Context context) {
        super(context);
    }

    public DiscrollvablePurpleLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiscrollvablePurpleLayout2(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();


        mPurpleView5 = findViewById(R.id.purpleView5);
        mPurpleView5TranslationX = mPurpleView5.getTranslationX();
        mPurpleView6 = findViewById(R.id.purpleView6);
        mPurpleView6TranslationX = mPurpleView6.getTranslationX();


    }

    @Override
    public void onResetDiscrollve() {

        mPurpleView5.setAlpha(0);
        mPurpleView6.setAlpha(0);


        mPurpleView5.setTranslationX(mPurpleView5TranslationX);
        mPurpleView6.setTranslationX(mPurpleView6TranslationX);



    }

    @Override
    public void onDiscrollve(float ratio) {
        if(ratio <= 0.5f) {

            mPurpleView6.setTranslationX(0);
            mPurpleView6.setAlpha(0.0f);
            float rratio = ratio / 0.5f;

            mPurpleView5.setTranslationX(mPurpleView5TranslationX * (1 - rratio));
            mPurpleView5.setAlpha(rratio);



        } else {

            mPurpleView5.setTranslationX(0);
            mPurpleView5.setAlpha(1.0f);

            float rratio = (ratio - 0.5f) / 0.5f;

            mPurpleView6.setTranslationX(mPurpleView6TranslationX * (1 - rratio));
            mPurpleView6.setAlpha(rratio);

        }
    }
}
