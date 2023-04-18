package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int count = 0;

        String number = "1234567";
        String resultString = "";

        int cursor = 0;
        int length = 0;

        while (!number.equals(resultString)) {

            // 1들어옴
            String partString = number.charAt(cursor) + "";
            count++;

            if (!partString.equals("0")) {
//                partString += (number.charAt(0) + 1) - '0';

                // 숫자 + 1
                int tempNumber = Integer.parseInt(String.valueOf(partString));
                tempNumber++;
                partString += tempNumber;

                resultString = resultString.concat(partString);
                length = resultString.length();

                // 백스페이스
                if ( length > number.length() || !resultString.equals(number.substring(0, length)) ) {
                    resultString = resultString.substring(0, resultString.length() - 1);
                    cursor--;
                    count++;

                }

                cursor += 2;

            } else { // 0일 경우
                resultString = resultString.concat("0");
                cursor++;
            }



        }

        System.out.println(count);


    }

}