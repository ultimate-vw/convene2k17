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
public class DiscrollvablePurpleLayout1 extends LinearLayout implements Discrollvable {

    private static final String TAG = "DiscrollvablePurpleLayout";


    private View mPurpleView3;
    private View mPurpleView4;


    private float mPurpleView3TranslationX;
    private float mPurpleView4TranslationX;



    public DiscrollvablePurpleLayout1(Context context) {
        super(context);
    }

    public DiscrollvablePurpleLayout1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiscrollvablePurpleLayout1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();


        mPurpleView3 = findViewById(R.id.purpleView3);
        mPurpleView3TranslationX = mPurpleView3.getTranslationX();
        mPurpleView4 = findViewById(R.id.purpleView4);
        mPurpleView4TranslationX = mPurpleView4.getTranslationX();


    }

    @Override
    public void onResetDiscrollve() {

        mPurpleView3.setAlpha(0);
        mPurpleView4.setAlpha(0);


        mPurpleView3.setTranslationX(mPurpleView3TranslationX);
        mPurpleView4.setTranslationX(mPurpleView4TranslationX);



    }

    @Override
    public void onDiscrollve(float ratio) {
        if(ratio <= 0.5f) {

            mPurpleView4.setTranslationX(0);
            mPurpleView4.setAlpha(0.0f);
            float rratio = ratio / 0.5f;

            mPurpleView3.setTranslationX(mPurpleView3TranslationX * (1 - rratio));
            mPurpleView3.setAlpha(rratio);



        } else {

            mPurpleView3.setTranslationX(0);
            mPurpleView3.setAlpha(1.0f);

            float rratio = (ratio - 0.5f) / 0.5f;

            mPurpleView4.setTranslationX(mPurpleView4TranslationX * (1 - rratio));
            mPurpleView4.setAlpha(rratio);

        }
    }
}
