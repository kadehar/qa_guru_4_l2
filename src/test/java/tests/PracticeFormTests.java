package tests;

import com.codeborne.selenide.ClickOptions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
     //Variables
    String firstName = "Lea",
            lastName = "Test",
            email = "lea@test.tv",
            phone = "1234567890",
            month = "6",
            year = "1977",
            day = "13",
            state = "NCR",
            city = "Gurgaon",
            subject = "Chemistry";

    @Test
    void dataAppearsInForm() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        //Set First name | Last name
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        //set Email | Gender | Phone number
        $("#userEmail").setValue(email);
        $("#gender-radio-1").click(ClickOptions.usingDefaultMethod());
        $("#userNumber").setValue(phone);
        // Set Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1977");
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__day.react-datepicker__day--013").click();
        // Set Subject
        $("#subjectsInput").val(subject).pressEnter();
        // Set Hobbies
        $("#hobbies-checkbox-1").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-2").click(ClickOptions.usingJavaScript());
        $("#hobbies-checkbox-3").click(ClickOptions.usingJavaScript());
        // Image upload from local drive
        $("#uploadPicture").uploadFile(new File("/Users/user/Downloads/IMG_1285.jpg"));
        // Set Address and State
        $("#currentAddress").setValue("Very very long address for this test");
        $("#react-select-3-input").val(state).pressEnter();
        $("#react-select-4-input").val(city).pressEnter();

        $("#submit").click();

        // Check that the form opened
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        // Verify results
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(email),
                text(phone),
                text("Male"),
                text("13 July,1977"),
                text(subject),
                text("Sports, Reading, Music"),
                text("IMG_1285.jpg"),
                text("Very very long address for this test"),
                text(state + " " + city));

        // Close the form
        $("#closeLargeModal").click();
        sleep(500);
    }
}
