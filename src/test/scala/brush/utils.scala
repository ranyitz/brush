package brush.test

import minitest.api._

object TestUtils {
  def getRawANSICodes(input: String): String = {
    input.replace("\u001B", "\\u001B")
  }

  def expect(received: String, expected: String)(implicit pos: SourceLocation): Unit = {
    if (received != expected)
      throw new AssertionException(
        Asserts.format(
          "received {0} != expected {1}",
          s"${received} (${getRawANSICodes(received)})",
          s"${expected} (${getRawANSICodes(expected)})"
        ),
        pos
      )
  }
}
