package com.academy.telesens.lesson04;

public class StringExc {
    public static void main(String[] args) {
        String[] tracks={
                "track_01", "track_03", "track_21", "track_15",
                "track_12", "track_99", "track_11", "track_10"};

        // Перебираем все треки
        // Извлекаем для каждого номер и выводим на консоль номера (oт 10 до 15)
        for (int i=0; i < tracks.length; i++) {
            int indexStart = tracks[i].indexOf('_'); // индекс символа '_'
            String digits = tracks[i].substring(indexStart + 1); // извлекаем подстроку цифр
            int number = Integer.parseInt(digits); // цифры из строки приводим к целому (числовому) типу
            if (number >= 10 && number <= 15) // проверяем на диапазон
                System.out.println(tracks[i]);
        }

        String demo = "Abcd djl wcdel dc cd;";
        String subs = "cd";
    }
}
