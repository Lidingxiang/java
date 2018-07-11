import org.junit.Test;

public class TmpTest {

    @Test
    public void subTest() {

        String path = "//aaa/bbb/ccc/ddd";

        int pos = 1;
        do {
            int tmpIndex = pos + 1;
            pos = path.indexOf('/', tmpIndex);

            if (pos == -1) {
                pos = path.length();
            }

            String subPath = path.substring(0, pos);
            System.out.println(subPath);

        } while (pos < path.length());

    }
}
