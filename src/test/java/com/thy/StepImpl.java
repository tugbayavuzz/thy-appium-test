package com.thy;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import java.util.List;
import java.util.Random;

import static element.element.*;

public class StepImpl extends HookImpl{


    @Step({"<seconds> saniye bekle"})
    public void waitBySecond(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step({"Al butonuna varsa tikla"})
    public void existClickByKey() {
        MobileElement el3 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/acMain_btnBooking");
        el3.click();
    }
    @Step({"Tek Yön Uçuş seç"})
    public void oneWay(){
        MobileElement el1 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_tvOneWay");
        el1.click();
    }
    @Step({"kalkış yeri seç"})
    public void selectDeparture(){
        MobileElement el1 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_tvFromCode");
        el1.click();
    }

    @Step({"Kalkış yerini <key> olarak seç"})
    public void sendKey(String key){
        MobileElement el2 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        el2.sendKeys(key);
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[2]");
        el1.click();

    }

    @Step({"Varış yerini <key> olarak seç"})
    public void sendArrival(String key){
        MobileElement el1 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_llTo");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        el2.sendKeys("ESB");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[2]");
        el3.click();
    }
    @Step({"Tarih seç"})
    public void selectDate(){
        MobileElement el1 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_rlDeparture");
        el1.click();
        List<MobileElement> els7 = (List<MobileElement>) driver.findElementsByXPath("//*[@class=\"android.view.ViewGroup\"]/android.view.ViewGroup/android.widget.FrameLayout");
        els7.get(0).isSelected();
        int index = 0;
        for (MobileElement element: els7) {
            if (element.isSelected()){
                index = els7.indexOf(element) + 2;
            }
        }
        els7.get(index).click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_btnDone");
        el2.click();
    }

    @Step({"Kişi sayısını <key> artır"})
    public void numberOfPassengers(int key){
        MobileElement els9 = (MobileElement)driver.findElementByXPath("//*[@class='android.widget.TextView' and @bounds='[925,1040][1079,1194]']");
        for (int i = 0; i < key; i++){
            els9.click();
        }

    }
    @Step({"Uçuş ara"})
    public void searchFlight(){
        MobileElement el1 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frDashboard_btnSearch");
        el1.click();
    }
    @Step({"Uçuş liste kontrol"})
    public void listControl(){
        MobileElement el1 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frFlightSearch_rvFlight");
        Assert.assertTrue(el1.isDisplayed());
    }
    @Step({"Ekonomik Uçuş seç"})
    public void selectEcoFly(){
        List<MobileElement> els1 = (List<MobileElement>) driver.findElementsByXPath("//*[@class=\"androidx.recyclerview.widget.RecyclerView\"]/android.view.ViewGroup/android.widget.FrameLayout");
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(els1.size());
        els1.get(randomNumber).click();

        List<MobileElement> els2 = (List<MobileElement>) driver.findElementsByXPath("//*[@class=\"android.widget.LinearLayout\"]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup");
        els2.get(0).click();
    }
    @Step({"Devam Butonuna tıklanır"})
    public void pressContinue(){
        MobileElement el1 = (MobileElement) driver.findElementById("com.turkishairlines.mobile:id/frFlightSearch_btnContinue");
        el1.click();
    }






}
