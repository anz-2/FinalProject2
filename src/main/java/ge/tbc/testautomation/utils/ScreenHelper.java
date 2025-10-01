package ge.tbc.testautomation.utils;

import org.testng.ITestContext;
import org.testng.Reporter;

public class ScreenHelper {
    private Integer width;
    private Integer height;
    private HelperFunc helperFunc;

    private void initParams() {
        if (width == null || height == null) {
            ITestContext context = Reporter.getCurrentTestResult().getTestContext();
            width = Integer.parseInt(context.getCurrentXmlTest().getParameter("width"));
            height = Integer.parseInt(context.getCurrentXmlTest().getParameter("height"));
            helperFunc = new HelperFunc(width, height);
        }
    }

    public int getWidth() {
        initParams();
        return width;
    }

    public int getHeight() {
        initParams();
        return height;
    }

    public HelperFunc getHelperFunc() {
        initParams();
        return helperFunc;
    }
}

