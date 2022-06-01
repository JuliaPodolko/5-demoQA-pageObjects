
import com.codeborne.selenide.Selenide;
        import com.codeborne.selenide.WebDriverRunner;
        import org.junit.jupiter.api.*;

public class Simple {
    @BeforeAll
    void openYaPage() {
        Selenide.open ("https://ya.ru");
    }
    @AfterAll
    void close () {
        WebDriverRunner.closeWindow();
    }
    @Test
    void assertTest() {

//.......


    }
}
