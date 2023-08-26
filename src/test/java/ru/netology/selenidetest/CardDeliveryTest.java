package ru.netology.selenidetest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest {


    @Test
    void positiveTest() {
        GenerateDay day = new GenerateDay();
        int dayX = 4;
        String planningDate = day.generateDay(dayX);

        open("http://localhost:9999");

        $("[data-test-id='city'] input").setValue("Брянск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);//очистка поля даты
        $("[data-test-id='date'] input").setValue(planningDate);//ввод даты(со смещением на +4 дня) с применением метода
        $("[data-test-id='name'] input").setValue("Петров-Карпов Владимир");
        $("[data-test-id='phone'] input").setValue("+79012345678");
        $("[data-test-id='agreement'].checkbox").click();
        $(".button").click();

        $(".notification__content")
                .shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
        //Condition - метод , для проверки различных свойств элементов  определённым условиям,в начале вызвать метод should()
        //Condition.text - проверка, что элемент содержит текст
        //Condition.visible - проверка, что элемент видимый на странице

    }

    @Test
    void changeDateTestBryansk() {
        GenerateDay day = new GenerateDay();
        int dayX = 7;
        String planningDate = day.generateDay(dayX);


        open("http://localhost:9999");

        $("[data-test-id='city'] input").click();
        $("[data-test-id='city'] input").setValue("Бр");
        $$(".menu-item__control").find(exactText("Брянск")).click();


        $(".icon_name_calendar").click();
        $(".calendar").click();
        for (int i = 0; i < (dayX - 3); i++) {
            Selenide.actions().sendKeys(Keys.ARROW_RIGHT).perform();
        }

        $("[data-test-id='name'] input").setValue("Петров-Карпов Владимир");
        $("[data-test-id='phone'] input").setValue("+79012345678");
        $("[data-test-id='agreement'].checkbox").click();
        $(".button").click();

        $(".notification__content")
                .shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);

    }

    @Test
    void changeDateTestKazan() {
        GenerateDay day = new GenerateDay();
        int dayX = 13;
        String planningDate = day.generateDay(dayX);


        open("http://localhost:9999");

        $("[data-test-id='city'] input").click();
        $("[data-test-id='city'] input").setValue("Ка");
        $$(".menu-item__control").find(exactText("Казань")).click();

        $(".icon_name_calendar").click();
        $(".calendar").click();
        for (int i = 0; i < (dayX - 3); i++) {
            Selenide.actions().sendKeys(Keys.ARROW_RIGHT).perform();
        }


        $("[data-test-id='name'] input").setValue("Петров-Карпов Владимир");
        $("[data-test-id='phone'] input").setValue("+79012345678");
        $("[data-test-id='agreement'].checkbox").click();
        $(".button").click();

        $(".notification__content")
                .shouldHave(text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);


    }
}
