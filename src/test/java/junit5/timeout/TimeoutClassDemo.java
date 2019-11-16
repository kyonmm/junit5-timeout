package junit5.timeout;

import org.junit.jupiter.api.*;

import static java.lang.Thread.sleep;

// ClassにもTimeoutをつけられる
@Timeout(2)
public class TimeoutClassDemo {

    @BeforeEach
    void setup() throws InterruptedException {
        sleep(1_000);
    }

    @Test
    void some_spec_1() throws InterruptedException {
        sleep(1_000);

    }

    @Test
    void some_spec_2() throws InterruptedException {
        // Timeoutよりおおきいので失敗する
        sleep(2_100);
    }

    // Nestedの中でもClassにつけたTimeoutは有効
    @Nested
    class SomeContext {
        @BeforeEach
        void setup() throws InterruptedException {
            sleep(500);
        }
        @Test
        void some_spec_3() throws InterruptedException {
            sleep(1_000);
        }
        @Test
        void some_spec_4() throws InterruptedException {
            // Timeoutよりおおきいので失敗する
            sleep(2_100);
        }
    }
}
