package brush

private trait Color[A] {
  def toRGB(param: A): (Int, Int, Int)
}

private object Color {
  implicit object StringColor extends Color[String] {
    def toRGB(param: String): (Int, Int, Int) = {
      if (AnsiUtils.isHex(param)) {
        AnsiUtils.hexToRgb(param)
      } else {
        ColorMap.getRgb(param)
      }
    }
  }

  implicit object RGBColor extends Color[(Int, Int, Int)] {
    def toRGB(param: (Int, Int, Int)): (Int, Int, Int) = param
  }
}
