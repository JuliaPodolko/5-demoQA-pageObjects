import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

public class simple {
    @BeforeEach
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
