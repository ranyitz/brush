package brush

// - `0` - All colors disabled.
// - `1` - Basic 16 colors support.
// - `2` - ANSI 256 colors support.
// - `3` - Truecolor 16 million colors support.
object ColorSupport {
  def getLevel(): Int = {
    val colorTermType = sys.env.getOrElse("COLORTERM", "")
    val termType = sys.env.getOrElse("TERM", "")
    val noColor = sys.env.getOrElse("NO_COLOR", "")
    val forceColor = sys.env.getOrElse("FORCE_COLOR", "")

    if (forceColor.nonEmpty) {
      forceColor match {
        case "0" => return 0
        case "1" => return 1
        case "2" => return 2
        case "3" => return 3
        case _ => ()
      }
    }

    if (noColor.nonEmpty) {
      return 0
    }

    if (colorTermType.contains("truecolor") || termType == "xterm-kitty") {
      return 3
    }

    if (termType.contains("256")) {
      return 2
    }

    return 1
  }
}
