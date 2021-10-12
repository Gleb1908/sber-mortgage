//package BaseTestClass;
//
//import managers.DriverManager;
//import managers.InitManager;
//import managers.PageManager;
//import managers.TestPropManager;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//
//import static utils.PropConst.*;
//
//public class BaseTest {
//
//    /**
//     * Менеджер страничек
//     */
//    protected PageManager app = PageManager.getPageManager();
//
//    /**
//     * Менеджер WebDriver
//     */
//    private final DriverManager driverManager = DriverManager.getDriverManager();
//
//    @BeforeAll
//    public static void beforeAll() {
//        InitManager.initFramework();
//    }
//
//    @BeforeEach
//    public void beforeEach() {
//        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
//    }
//
//    @AfterAll
//    public static void afterAll() {
//        InitManager.quitFramework();
//    }
//
//}
