package at.tests.ui;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import at.study.redmine.model.User;

import static at.study.redmine.ui.BrowserUtils.getElementsText;
import static at.study.redmine.utils.CompareUtils.assertListSortedByDateAsc;
import static at.study.redmine.utils.CompareUtils.assertListSortedByDateDesc;

public class UsersTableDateSortingTest extends BaseUITest {

    @BeforeMethod
    public void prepareFixtures() {
        User admin = new User() {{
            setIsAdmin(true);
        }}.create();

        openBrowser();
        headerPage.loginButton.click();
        loginPage.login(admin);
        headerPage.administration.click();
        administrationPage.users.click();
    }

    @Test
    public void testUsersTableDateSorting() {
        userTablePage.button("Создано").click();
        List<String> creationDatesByDesc = getElementsText(userTablePage.creationDates);
        assertListSortedByDateDesc(creationDatesByDesc);

        userTablePage.button("Создано").click();
        List<String> creationDatesByAsc = getElementsText(userTablePage.creationDates);
        assertListSortedByDateAsc(creationDatesByAsc);
    }


}
