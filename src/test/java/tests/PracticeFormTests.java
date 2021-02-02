package tests;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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
        $("#subjectsInput").val("Chemistry").pressEnter();
        $("#hobbies-checkbox-1").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-2").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-3").click(ClickOptions.usingJavaScript());
        $("#uploadPicture").uploadFile(new File("/Users/user/Downloads/IMG_1285.jpg"));
        $("#currentAddress").setValue("Very very long address for this test");
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#react-select-4-input").val("Gurgaon").pressEnter();
        sleep(200);


        $("#submit").click();




    }
}
