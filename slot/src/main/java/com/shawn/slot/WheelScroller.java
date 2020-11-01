package com.shawn.slot;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class WheelScroller {

    public interface ScrollingListener {
        void onScroll(int distance);

        void onStarted();

        void onFinished();

        void onJustify();
    }

    private static final int SCROLLING_DURATION = 400;

    public static final int MIN_DELTA_FOR_SCROLLING = 1;

    private ScrollingListener listener;

    private Context context;

    private Scroller scroller;
    private int lastScrollY;
    private boolean isScrollingPerformed;

    public WheelScroller(Context context, ScrollingListener listener) {
        scroller = new Scroller(context);

        this.listener = listener;
        this.context = context;
    }

    public void setInterpolator(Interpolator interpolator) {
        scroller.forceFinished(true);
        scroller = new Scroller(context, interpolator);
    }

    public void scroll(int distance, int time) {
        scroller.forceFinished(true);

        lastScrollY = 0;

        scroller.startScroll(0, 0, 0, distance, time != 0 ? time : SCROLLING_DURATION);
        setNextMessage(MESSAGE_SCROLL);

        startScrolling();
    }

    public void stopScrolling() {
        scroller.forceFinished(true);
    }

    private final int MESSAGE_SCROLL = 0;
    private final int MESSAGE_JUSTIFY = 1;

    private void setNextMessage(int message) {
        clearMessages();
        animationHandler.sendEmptyMessage(message);
    }

    private void clearMessages() {
        animationHandler.removeMessages(MESSAGE_SCROLL);
        animationHandler.removeMessages(MESSAGE_JUSTIFY);
    }

    private Handler animationHandler = new Handler() {
        public void handleMessage(Message msg) {
            scroller.computeScrollOffset();
            int currY = scroller.getCurrY();
            int delta = lastScrollY - currY;
            lastScrollY = currY;
            if (delta != 0) {
                listener.onScroll(delta);
            }

            // scrolling is not finished when it comes to final Y
            // so, finish it manually 
            if (Math.abs(currY - scroller.getFinalY()) < MIN_DELTA_FOR_SCROLLING) {
                currY = scroller.getFinalY();
                scroller.forceFinished(true);
            }
            if (!scroller.isFinished()) {
                animationHandler.sendEmptyMessage(msg.what);
            } else if (msg.what == MESSAGE_SCROLL) {
                justify();
            } else {
                finishScrolling();
            }
        }
    };

    private void justify() {
        listener.onJustify();
        setNextMessage(MESSAGE_JUSTIFY);
    }

    private void startScrolling() {
        if (!isScrollingPerformed) {
            isScrollingPerformed = true;
            listener.onStarted();
        }
    }

    private void finishScrolling() {
        if (isScrollingPerformed) {
            listener.onFinished();
            isScrollingPerformed = false;
        }
    }
}
