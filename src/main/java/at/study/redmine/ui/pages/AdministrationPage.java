package at.study.redmine.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import at.study.redmine.cucumber.ElementName;
import at.study.redmine.cucumber.PageName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@PageName("Администрирование")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class AdministrationPage extends Page {

    @ElementName("Проекты")
    @FindBy(xpath = "//div[@id='admin-menu']//a[contains(@class,'projects')]")
    public WebElement projects;

    @ElementName("Пользователи")
    @FindBy(xpath = "//div[@id='admin-menu']//a[contains(@class,'users')]")
    public WebElement users;

}
