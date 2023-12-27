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

    SelenideElement firstName = $("[id=firstName]");
    @Test
    void fillRegistrationForm(){

        open("https://demoqa.com/automation-practice-form");
        firstName.sendKeys("SomeText");


        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov88@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9119991919");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption(88);
        $(".react-datepicker__day--023").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
//        $("#uploadPicture").uploadFromClasspath("screen.jpg");
        $("#currentAddress").setValue("Test");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

//check
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("ivanov88@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9119991919"));
        $(".table-responsive").shouldHave(text("23 August,1988"));
        $(".table-responsive").shouldHave(text("Test"));
//        $(".table-responsive").shouldHave(text("screen.jpg"));
        $(".table-responsive").shouldHave(text("Test"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));

    }


}


// $("[name=q]").setValue("selenide").pressEnter();
// $("[id=search]").shouldHave(text("https://selenide.org"));