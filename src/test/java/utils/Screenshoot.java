package utils;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshoot {

    public static String takeScreenshoot(Page page, String name) {

        String timestamp = new SimpleDateFormat("yyyy MM dd - HH mm ss").format(new Date());
        String path = "test-output/screenshots/" + timestamp + " - " + name + ".png";

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

        return path;
    }
}
