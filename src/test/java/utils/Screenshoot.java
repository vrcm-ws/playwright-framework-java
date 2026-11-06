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

        Path path = Path.of(System.getProperty("user.dir"), "test-output", "screenshots", filename);

        page.screenshot(new Page.ScreenshotOptions().setPath(path).setFullPage(true));

        return path.toString();
    }

    public static Media buildMedia(Page page, String name) {

        return MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshoot(page, name), name).build();
    }
}
