package ge.tbc.testautomation.utils;

import ge.tbc.testautomation.data.Constants;


public class HelperFunc {

    private int width;
    private int height;

    public HelperFunc(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isMobile() {
        return width == Constants.MOBILE_WIDTH && height == Constants.MOBILE_HEIGHT;
    }

    public void run(Runnable mobileAction, Runnable desktopAction) {
        if (isMobile()) {
            if (mobileAction != null) mobileAction.run();
        } else {
            if (desktopAction != null) desktopAction.run();
        }
    }


}
