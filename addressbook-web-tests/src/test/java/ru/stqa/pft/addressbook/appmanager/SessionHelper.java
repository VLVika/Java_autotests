package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.xpath("//input[@value='Login']"));
    }

    public void logOut() {
        click(By.linkText("Logout"));
    }

    public void waitSecond() {
        WebDriverWait wait = new WebDriverWait(wd, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='content']/div")));

    }


    }



