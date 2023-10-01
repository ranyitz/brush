package brush

private object Gradient {

  /**
   * This function splits the string into three parts:
   *   - the opening ansi code
   *   - the string without ansi codes
   *   - the closing ansi code
   */
  private def splitAnsiCodes(str: String): Option[Seq[String]] = {
    val pattern = "\u001b\\[\\d{1,3}(?:;\\d{1,3}){0,2}m"
    val openingPattern = s"^$pattern".r
    val closingPattern = s"${pattern}$$".r
    val maybeOpening = openingPattern.findFirstIn(str)
    val maybeClosing = closingPattern.findFirstIn(str)

    (maybeOpening, maybeClosing) match {
      case (Some(opening), Some(closing)) => {
        val strWithoutAnsiCodes = str.substring(opening.length, str.length - closing.length)

        Some(Seq(opening, strWithoutAnsiCodes, closing))
      }
      case _ => None
    }
  }

  /**
   * This function interpolates between two colors. It takes two colors and a number between 0 - 1.
   * It returns a color that is between the two colors. The number 0 returns the first color. The
   * number 1 returns the second color. The number 0.5 returns a color that is exactly between them.
   */
  private def interpolateColor(
    start: (Int, Int, Int),
    end: (Int, Int, Int),
    t: Double
  ): (Int, Int, Int) = {
    val (r1, g1, b1) = start
    val (r2, g2, b2) = end

    val r = ((1 - t) * r1 + t * r2).toInt
    val g = ((1 - t) * g1 + t * g2).toInt
    val b = ((1 - t) * b1 + t * b2).toInt

    (r, g, b)
  }

  private def getGradientWithRgb(
    str: String,
    colors: Seq[(Int, Int, Int)],
    bg: Boolean = false
  ): String = {
    if (colors.isEmpty) {
      return str
    }

    // This is a solution to avoid coloring the ansi codes.
    // it happens when using "string".strikethrough.bgGradient(...)
    // and the gradient is applied to the ansi codes of the strikethrough.
    splitAnsiCodes(str) match {
      case Some(ansiCodes) => {
        val (opening, strWithoutAnsiCodes, closing) = (ansiCodes(0), ansiCodes(1), ansiCodes(2))
        val colorizedStr = getGradientWithRgb(strWithoutAnsiCodes, colors, bg)

        return s"$opening$colorizedStr$closing"
      }
      case None => ()
    }

    val numColors = colors.length

    str
      .split("")
      .zipWithIndex
      .map {
        case (char, index) => {
          val colorIndex = index.toDouble / str.length
          val startIndex = (colorIndex * (numColors - 1)).toInt
          val middle = colorIndex * (numColors - 1) - startIndex
          val startColor = colors(startIndex)
          val endColor = colors(startIndex + 1)
          val interpolatedColor = interpolateColor(startColor, endColor, middle)
          val (r, g, b) = interpolatedColor

          if (bg) {
            char.bgRgb(r, g, b)
          } else {
            char.rgb(r, g, b)
          }
        }
      }
      .mkString
  }

  def renderGradient(
    str: String,
    colors: Seq[(Int, Int, Int)]
  ): String = getGradientWithRgb(str, colors)

  def renderBgGradient(
    str: String,
    colors: Seq[(Int, Int, Int)]
  ): String = getGradientWithRgb(str, colors, bg = true)
}
