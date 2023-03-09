package org.prog.pages;

public class WebPageFactory {

    private static final WebDriverFactory webDriverFactory = WebDriverFactory.getInstance();

    public static <T extends AbstractPage> T getPage(DriverName driverName, Pages page, Class<T> type) {
        switch (page) {
            case GOOGLE:
                return (T) new GooglePage(webDriverFactory.getDriver(driverName));
            case ROZETKA:
                return (T) new RozetkaPage(webDriverFactory.getDriver(driverName));
            default:
                throw new RuntimeException("Unknown page");
        }
    }
}
