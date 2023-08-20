package com.venki.auto.utils.Objects;

import java.util.HashMap;
import java.util.Map;

public class Elements {
    public static String calendarName="h1[class=\"mr-10 text-xl text-gray-500 fond-bold\"]";//Css
    public static String mainMonthLeftButton="//*[@id=\"root\"]/div/header/button[2]/span";//xpath
    public static String mainMonthRighttButton="//*[@id=\"root\"]/div/header/button[3]/span";//xpath

    public static String minorMonthLeftButton="//*[@id=\"root\"]/div/div/aside/div/header/div/button[1]/span";//xpath
    public static String minorMonthRighttButton="//*[@id=\"root\"]/div/div/aside/div/header/div/button[2]/span";//xpath

    public static String createButton="button[class=\"border p-2 rounded-full flex items-center shadow-md hover:shadow-2xl\"]";//css

    public static String mainMonth ="h2[class=\"ml-4 text-xl text-gray-500 font-bold\"]";//css
    public static String miniMonth ="p[class=\"text-gray-500 font-bold\"]";//css
    public static String listOfCalendarDates ="div[class=\"border border-gray-200 flex flex-col\"]";//css
    public static String calendarGrid ="div[class=\"flex-1 grid grid-cols-7 grid-rows-5\"]";//css

    public static String blueCircle="p[class=\"text-sm p-1 my-1 text-center  bg-blue-600 text-white rounded-full w-7\"]";//css input[name="title"]
    public static String eventTextField="input[name=\"title\"]";//css
    public static String eventSaveButton="button[type=\"submit\"]";//css
    public static String eventdescription="input[name=\"description\"]";//css
    public static String listOfdates="//p[contains(@class,'text-center')]";//css

    public static String cursor="//div[contains(@class,'cursor')]";//xpath
    public static String eventCard="//div[contains(@class,'p-1 mr-3')]";//xpath




    public static String getLabelElement(String color){
        Map<String,String> map=new HashMap<String,String>();
        map.put("indigo","//*[@id=\"root\"]/div[1]/form/div/div/div[2]/span[1]");
        map.put("gray","//*[@id=\"root\"]/div[1]/form/div/div/div[2]/span[2]");
        map.put("green","//*[@id=\"root\"]/div[1]/form/div/div/div[2]/span[3]");
        map.put("blue","//*[@id=\"root\"]/div[1]/form/div/div/div[2]/span[4]");
        map.put("red","//*[@id=\"root\"]/div[1]/form/div/div/div[2]/span[5]");
        map.put("purple","//*[@id=\"root\"]/div[1]/form/div/div/div[2]/span[6]");
        return map.get(color);
    }



















}
