public enum Browser
{
    CHROME("chrome"),
    FIREFOX("firefox");//not supporting it on this exercise

    String browser;

    Browser(String browser)
    {
        this.browser = browser;
    }

    public String getBrowser()
    {
        return browser;
    }
}
