import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;

public class UpTests {
    @Test
    public void testHashSetOperations() {

        HashSet<Character> charSet = new HashSet<>();
        //Эта строка создает HashSet для хранения уникальных символов строки.
//HashSet<Character>charSet = new HashSet<>()
        charSet.add('b');
        charSet.add('c');

        assertTrue(charSet.contains('1'));
        assertTrue(charSet.contains('2'));
        charSet.add('a'); // Повторное добавление
        assertEquals(3, charSet.size()); // Должно остаться 3 элемента

        // Удаляем символ
        charSet.remove('b');
        assertFalse(charSet.contains('b'));
        assertEquals(2, charSet.size());

    }
}