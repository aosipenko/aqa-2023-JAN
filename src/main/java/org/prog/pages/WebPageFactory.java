package org.prog.pages;

public class WebPageFactory {

    private static final WebDriverFactory webDriverFactory = WebDriverFactory.getInstance();

    public static AbstractPage getWebPage(Pages pages){
        switch (pages){
            case GOOGLE:
                return new GooglePage(null);
            case ROZETKA:
                return new RozetkaPage(null);
            default:
                throw new RuntimeException("Unkown page");
        }
    }

    //TODO: Read about generic types and methods
    public static <T extends AbstractPage> T getPage(DriverName driverName, Pages page) {
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
