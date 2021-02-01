package tests;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {


    @Test
    void dataAppearsInForm() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Lea");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("lea@test.tv");
        $("#gender-radio-1").click(ClickOptions.usingDefaultMethod());
        $("#userNumber").setValue("1234567890");
        // Date of Birth
        //Subjects

        $("#hobbies-checkbox-1").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-2").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-3").click(ClickOptions.usingJavaScript());
        //Picture
        $("#currentAddress").setValue("Very very long address for this test");
        //State and City

        $("#submit").click();




    }
}
