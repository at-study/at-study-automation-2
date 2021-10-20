package at.study.redmine.ui.pages;

import org.openqa.selenium.support.PageFactory;

import at.study.redmine.ui.BrowserManager;
import lombok.SneakyThrows;

public abstract class Page  {

    @SneakyThrows
    public static <T extends Page> T getPage(Class<T> clazz) {
        T page = clazz.getDeclaredConstructor().newInstance();
        PageFactory.initElements(BrowserManager.getBrowser().getDriver(), page);
        return page;
    }

}
