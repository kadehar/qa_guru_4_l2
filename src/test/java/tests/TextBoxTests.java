package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
     void dataAppearsInOutputBlockTest() {
        open("https://demoqa.com/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("Leanid Tryfanau");
        $("#userEmail").setValue("Leanid@Tryfanau.cc");
        $("#currentAddress").setValue("Minsk");
        $("#permanentAddress").setValue("Belarus");
        $("#submit").click();

        $("#output").shouldHave(text("Leanid Tryfanau"), text("Leanid@Tryfanau.cc"), text("Minsk"), text("Belarus"));
    }
}
