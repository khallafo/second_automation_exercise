package org.example;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class SearchProduct {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    private WebElement box;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")
    private WebElement option;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
    private WebElement Item1;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    private WebElement Item2;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cart;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement cartTitle;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-onesie\"]")
    private WebElement remove;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    private WebElement checkout;

    public SearchProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Test
    @Step("Validate filter selection and cart interaction")
    public void validateFilterAndCart() {
        validateFilter();
        validateCart();
        validateItem1();
        validateItem2();
        validateCheckout();
    }

    @Step("Select the Price (low to high) filter")
    private void validateFilter() {
        box.click();
        option.click();
        WebElement actived = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/span"));
        Assert.assertEquals("Price (low to high)", actived.getText());
        Item1.click();
        Item2.click();
        cart.click();
    }

    @Step("Validate item 1")
    private void validateItem1() {
        WebElement chItem1 = driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div"));
        Assert.assertEquals("Sauce Labs Onesie", chItem1.getText());
    }

    @Step("Validate item 2")
    private void validateItem2() {
        WebElement chItem2 = driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div"));
        Assert.assertEquals("Sauce Labs Bike Light", chItem2.getText());
    }

    @Step("Validate cart")
    private void validateCart() {
        Assert.assertEquals("Your Cart", cartTitle.getText());
    }

    @Step("Validate checkout")
    private void validateCheckout() {
        checkout.click();
        WebElement navigate = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals("Checkout: Your Information", navigate.getText());
    }
    public void Checks() {
        validateFilter();
        validateCart();
        validateItem1();
        validateItem2();
        validateCheckout();
    }

}
