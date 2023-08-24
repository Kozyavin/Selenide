package ru.netology.selenidetest;


import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    @Test
    void positiveTest() {
        open("http://localhost:9999");


        $("[data-test-id='city'] input").setValue("Брянск");
        $("[data-test-id='date'] input").setValue("30.08.23");
        $("[data-test-id='name'] input").setValue("Петров-Карпов Владимир");
        $("[data-test-id='phone'] input").setValue("+79012345678");
        $("[data-test-id='agreement'].checkbox").click();
        $(".button").click();
        $(withText("Успешно")).shouldBe(visible, Duration.ofSeconds(12));
    }

    @Test
    void changeDateTest() {
        open("http://localhost:9999");


        $("[data-test-id='city'] input").setValue("Брянск");

        /*Date currentDate = new Date();
        Calendar calendar = new GregorianCalendar();//создаём объект класса Calendar
        calendar.add(Calendar.DAY_OF_MONTH, 7);//к дню текущего месяца прибавляем 7 дней
        int newDay = calendar.get(Calendar.DAY_OF_MONTH);//получить только день месяца после прибавки
        System.out.println(newDay);*/

        $(".icon_name_calendar").click();
        //$("[role='gridcell'].calendar__day").click(String.valueOf(newDay));
        $("[data-test-id='date'] input").setValue("30.08.23");
        $("[data-test-id='name'] input").setValue("Петров-Карпов Владимир");
        $("[data-test-id='phone'] input").setValue("+79012345678");
        $("[data-test-id='agreement'].checkbox").click();
        $(".button").click();
        $(withText("Успешно")).shouldBe(visible, Duration.ofSeconds(12));




    }
}
