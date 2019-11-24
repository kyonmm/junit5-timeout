package junit5.timeout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class TimeoutDemo {

  @BeforeEach
  @Timeout(5)
  void setUp() {
    // この中の処理で5秒以上実行してしまったらここでFailする
  }

  @Test
  @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    // unit指定なし => 秒。
    // unit指定 => nano秒から日まで指定できる
  void _100ミリ秒以上かかるとテストが失敗する() {
  }

  @Test
  void 非同期実行におけるタイムアウトはassertTimeoutPreemptivelyを使うと便利() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(1),
        // なにか非同期で実行するもの。Executableをわたす。
        () -> {
        });
  }

}