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

        //Set First name | Last name
        $("#firstName").setValue("Lea");
        $("#lastName").setValue("Test");
        //set Email | Gender | Phone number
        $("#userEmail").setValue("lea@test.tv");
        $("#gender-radio-1").click(ClickOptions.usingDefaultMethod());
        $("#userNumber").setValue("1234567890");
        // Set Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1977");
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__day.react-datepicker__day--013").click();
        // Set Subject
        $("#subjectsInput").val("Chemistry").pressEnter();
        // Set Hobbies
        $("#hobbies-checkbox-1").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-2").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-3").click(ClickOptions.usingJavaScript());
        // Image upload from local drive
        $("#uploadPicture").uploadFile(new File("/Users/user/Downloads/IMG_1285.jpg"));
        // Set Address and State
        $("#currentAddress").setValue("Very very long address for this test");
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#react-select-4-input").val("Gurgaon").pressEnter();

        $("#submit").click();

        //sleep(500);

        // Check that the form opened
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        // Verify results
        $(".table-responsive").shouldHave(text("Lea Test"), text("lea@test.tv"), text("Male"), text("13 July,1977"), text("Chemistry"), text("Sports, Reading, Music"), text("IMG_1285.jpg"), text("Very very long address for this test"), text("NCR Gurgaon"));

        // Close the form
        $("#closeLargeModal").click();
        sleep(500);



    }
}
