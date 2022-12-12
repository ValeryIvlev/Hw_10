package org.zayac;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;

public class TestBase {


    @BeforeAll
    static void BeforeAll() {

        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @BeforeEach
    void setUp() {
       Attachments.screenshotAs("Last screenshot");
       Attachments.addVideo();
       Attachments.browserConsoleLogs();
       Attachments.pageSource();
    }

}

