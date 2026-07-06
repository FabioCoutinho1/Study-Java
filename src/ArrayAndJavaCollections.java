import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayAndJavaCollections {
    public static void main(String[] args) {
        String[] words = new String[3];
        words[0] = "Hello";
        words[1] = "World";

        char[] chars = new char[3];
        chars[0] = 'a';
        chars[1] = 'b';
        chars[2] = 'c';

        char[] chars2 = {'1', '2', '3'};


        System.out.println(words.length);
        chars[0] = 'd';
        chars2[0] = 'e';
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(chars2));

    }
}
