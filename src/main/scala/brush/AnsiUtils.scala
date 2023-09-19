package brush

object AnsiUtils {
  val ESCAPE = "\u001b["
  val BG_CLOSE = 49
  val TEXT_CLOSE = 39

  def rgbToAnsi256(rgb: (Int, Int, Int)): Int = {
    val (r, g, b) = rgb
    if (r == g && g == b) {
      if (r < 8) {
        16
      } else if (r > 248) {
        231
      } else {
        Math.round(((r - 8).toFloat / 247) * 24).toInt + 232
      }
    } else {
      16 + (36 * Math.round(r / 255.0 * 5).toInt) +
        (6 * Math.round(g / 255.0 * 5).toInt) +
        Math.round(b / 255.0 * 5).toInt
    }
  }

  def hexToRgb(hex: String): (Int, Int, Int) = {
    val cleanHex = if (hex.startsWith("#")) hex.substring(1) else hex

    val red = Integer.parseInt(cleanHex.substring(0, 2), 16)
    val green = Integer.parseInt(cleanHex.substring(2, 4), 16)
    val blue = Integer.parseInt(cleanHex.substring(4, 6), 16)

    (red, green, blue)
  }

  def isHex(maybeHex: String): Boolean = {
    maybeHex.matches("^#?([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")
  }
}
