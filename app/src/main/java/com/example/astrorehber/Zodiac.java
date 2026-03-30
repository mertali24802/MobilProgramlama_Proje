package com.example.astrorehber;

import java.io.Serializable; // OOP: Interface kullanımı

// Nesneyi tek parça halinde diğer ekrana yollamak için Serializable implement ettik
public class Zodiac implements Serializable {
    private String name;
    private String dateRange;
    private int iconResId;
    private int coverResId;

    private String dailyComment;
    private String weeklyComment;
    private String monthlyComment;
    private String element;
    private String planet;
    private String luckyNumber;
    private String luckyColor;

    public Zodiac(String name, String dateRange, int iconResId, int coverResId,
                  String dailyComment, String weeklyComment, String monthlyComment,
                  String element, String planet, String luckyNumber, String luckyColor) {
        this.name = name;
        this.dateRange = dateRange;
        this.iconResId = iconResId;
        this.coverResId = coverResId;
        this.dailyComment = dailyComment;
        this.weeklyComment = weeklyComment;
        this.monthlyComment = monthlyComment;
        this.element = element;
        this.planet = planet;
        this.luckyNumber = luckyNumber;
        this.luckyColor = luckyColor;
    }

    public String getName() { return name; }
    public String getDateRange() { return dateRange; }
    public int getIconResId() { return iconResId; }
    public int getCoverResId() { return coverResId; }
    public String getDailyComment() { return dailyComment; }
    public String getWeeklyComment() { return weeklyComment; }
    public String getMonthlyComment() { return monthlyComment; }
    public String getElement() { return element; }
    public String getPlanet() { return planet; }
    public String getLuckyNumber() { return luckyNumber; }
    public String getLuckyColor() { return luckyColor; }
}