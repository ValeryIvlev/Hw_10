package org.zayac;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;
import static java.nio.channels.SocketChannel.open;

public class TestBase {


    @BeforeAll
    static void BeforeAll() throws IOException {

        WebDriverManager.chromedriver().setup();
        Configuration.timeout = 60000;
        Configuration.headless = false;
        Configuration.webdriverLogsEnabled = true;
        Configuration.browser = Browsers.CHROME;
        open();

    }

    @BeforeEach
    void setUp() {
       Attachments.screenshotAs("Last screenshot");
       Attachments.addVideo();
       Attachments.browserConsoleLogs();
       Attachments.pageSource();
    }

}

