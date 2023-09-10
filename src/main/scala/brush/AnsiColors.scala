package brush

import brush.AnsiUtils._

// Every color is a tuple of two integers,
// the first integer is the color code,
// the second integer is the color close code.
object AnsiColors {
  val RESET = (0, 0)
  val BOLD = (1, 22)
  val DIM = (2, 22)
  val ITALIC = (3, 23)
  val UNDERLINE = (4, 24)
  val OVERLINE = (53, 55)
  val INVERSE = (7, 27)
  val HIDDEN = (8, 28)
  val STRIKETHROUGH = (9, 29)
  val BLACK = (30, TEXT_CLOSE)
  val RED = (31, TEXT_CLOSE)
  val GREEN = (32, TEXT_CLOSE)
  val YELLOW = (33, TEXT_CLOSE)
  val BLUE = (34, TEXT_CLOSE)
  val MAGENTA = (35, TEXT_CLOSE)
  val CYAN = (36, TEXT_CLOSE)
  val WHITE = (37, TEXT_CLOSE)
  val BLACK_BRIGHT = (90, TEXT_CLOSE)
  val GRAY = BLACK_BRIGHT
  val GREY = BLACK_BRIGHT
  val RED_BRIGHT = (91, TEXT_CLOSE)
  val GREEN_BRIGHT = (92, TEXT_CLOSE)
  val YELLOW_BRIGHT = (93, TEXT_CLOSE)
  val BLUE_BRIGHT = (94, TEXT_CLOSE)
  val MAGENTA_BRIGHT = (95, TEXT_CLOSE)
  val CYAN_BRIGHT = (96, TEXT_CLOSE)
  val WHITE_BRIGHT = (97, TEXT_CLOSE)
  val BG_BLACK = (40, BG_CLOSE)
  val BG_RED = (41, BG_CLOSE)
  val BG_GREEN = (42, BG_CLOSE)
  val BG_YELLOW = (43, BG_CLOSE)
  val BG_BLUE = (44, BG_CLOSE)
  val BG_MAGENTA = (45, BG_CLOSE)
  val BG_CYAN = (46, BG_CLOSE)
  val BG_WHITE = (47, BG_CLOSE)
  val BG_BLACK_BRIGHT = (100, BG_CLOSE)
  val BG_GRAY = BG_BLACK_BRIGHT
  val BG_GREY = BG_BLACK_BRIGHT
  val BG_RED_BRIGHT = (101, BG_CLOSE)
  val BG_GREEN_BRIGHT = (102, BG_CLOSE)
  val BG_YELLOW_BRIGHT = (103, BG_CLOSE)
  val BG_BLUE_BRIGHT = (104, BG_CLOSE)
  val BG_MAGENTA_BRIGHT = (105, BG_CLOSE)
  val BG_CYAN_BRIGHT = (106, BG_CLOSE)
  val BG_WHITE_BRIGHT = (107, BG_CLOSE)
}
