package com.academy.telesens.demo;

public class ParseHttpLinkDemo {
    public static void main(String[] args) {
        String origin = "<p>Hello Sennikov User AQA,<br /><br /></p>\n" +
                "<p>Thank you for your participation in the Sennikov Verify CPP Accessibility via Selenium Webdriver campaign. In order for us to pay you, please submit your payment and tax information by clicking the button below. The link expires in 48 hours.<br /><br /></p>\n" +
                "<p><a href=\"https://creatojsdjfkjsdfjksdfjksdfjdskjfskjdfjsdkjfsdkjf.com?id=abcd12345\">Provide My Payment Information</a></p>\n" +
                "<p><br />Please contact us if you have any questions.<br /><br /></p>\n" +
                "<p>TEST 21 Partner Den</p>\n" +
                "<p></p>";

        String expected = "https://creatojsdjfkjsdfjksdfjksdfjdskjfskjdfjsdkjfsdkjf.com?id=abcd12345";
        String actual = parseLink(origin);
        System.out.println(actual.equals(expected));
        System.out.println(expected);
        System.out.println(actual);
    }

    private static String parseLink(String origin) {
        int startIndex = origin.indexOf("https");
        int endIndex = origin.indexOf("\"", startIndex);
        return origin.substring(startIndex, endIndex);
    }
}
