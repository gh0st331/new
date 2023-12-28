import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class StudentRegistrationFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillRegistrationForm(){

        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Test");
        $("#lastName").setValue("User");
        $("#userEmail").setValue("testuser@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9197768011");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption(88);
        $(".react-datepicker__day--023").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("[id=uploadPicture]").uploadFromClasspath("test.jpeg");
        $("#currentAddress").setValue("Test");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

//check
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Test User"));
        $(".table-responsive").shouldHave(text("testuser@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9197768011"));
        $(".table-responsive").shouldHave(text("23 August,1988"));
        $(".table-responsive").shouldHave(text("Test"));
        $(".table-responsive").shouldHave(text("test.jpeg"));
        $(".table-responsive").shouldHave(text("Test"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));

    }


}


// $("[name=q]").setValue("selenide").pressEnter();
// $("[id=search]").shouldHave(text("https://selenide.org"));