package utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.microsoft.playwright.Page;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshoot {

    public static String takeScreenshoot(Page page, String name) {

        String timestamp = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss").format(new Date());
        String filename = timestamp + " - " + name + ".png";

        Path path = Path.of( "test-output", "screenshots", filename);
        page.screenshot(new Page.ScreenshotOptions().setPath(path).setFullPage(true));

        return filename;
    }

    public static Media buildMedia(Page page, String name) {

        return MediaEntityBuilder.createScreenCaptureFromPath("screenshots/" + takeScreenshoot(page, name), name).build();
    }
}
