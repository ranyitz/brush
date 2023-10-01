package brush

import brush.AnsiColors._
import brush.AnsiUtils._
import brush.Gradient._

import scala.language.implicitConversions

class Brush {
  private def render(str: String, color: (Int, Int)): String =
    ColorSupport.getLevel match {
      case 0 => str
      case 1 | 2 | 3 => s"$ESCAPE${color._1}m$str$ESCAPE${color._2}m"
    }

  private def render256(str: String, color: (Int, Int)): String = {
    ColorSupport.getLevel match {
      case 0 => str
      case 1 => str
      case 2 | 3 => s"${ESCAPE}38;5;${color._1}m$str$ESCAPE${color._2}m"
    }
  }

  private def renderBg256(str: String, color: (Int, Int)): String = {
    ColorSupport.getLevel match {
      case 0 => str
      case 1 => str
      case 2 | 3 => s"${ESCAPE}48;5;${color._1}m$str$ESCAPE${color._2}m"
    }
  }

  private def renderTruecolor(str: String, rgb: (Int, Int, Int)): String = {
    ColorSupport.getLevel match {
      case 0 => str
      case 1 => str
      case 2 => render256(str, (rgbToAnsi256(rgb), TEXT_CLOSE))
      case 3 => s"${ESCAPE}38;2;${rgb._1};${rgb._2};${rgb._3}m$str$ESCAPE${TEXT_CLOSE}m"
    }
  }

  private def renderBgTruecolor(str: String, rgb: (Int, Int, Int)): String = {
    ColorSupport.getLevel match {
      case 0 => str
      case 1 => str
      case 2 => renderBg256(str, (rgbToAnsi256(rgb), BG_CLOSE))
      case 3 => s"${ESCAPE}48;2;${rgb._1};${rgb._2};${rgb._3}m$str$ESCAPE${BG_CLOSE}m"
    }
  }

  /* add an implicit method to String to allow chaining of colors */
  implicit def decorate(str: String): BrushMethods =
    new BrushMethods(str)

  protected class BrushMethods(str: String) {
    // modifiers
    def reset: String = render(str, RESET)
    def bold: String = render(str, BOLD)
    def dim: String = render(str, DIM)
    def italic: String = render(str, ITALIC)
    def underline: String = render(str, UNDERLINE)
    def overline: String = render(str, OVERLINE)
    def inverse: String = render(str, INVERSE)
    def hidden: String = render(str, HIDDEN)
    def strikethrough: String = render(str, STRIKETHROUGH)

    // text colors
    def black: String = render(str, BLACK)
    def red: String = render(str, RED)
    def green: String = render(str, GREEN)
    def yellow: String = render(str, YELLOW)
    def blue: String = render(str, BLUE)
    def magenta: String = render(str, MAGENTA)
    def cyan: String = render(str, CYAN)
    def white: String = render(str, WHITE)
    def blackBright: String = render(str, BLACK_BRIGHT)
    def gray: String = blackBright
    def grey: String = blackBright
    def redBright: String = render(str, RED_BRIGHT)
    def greenBright: String = render(str, GREEN_BRIGHT)
    def yellowBright: String = render(str, YELLOW_BRIGHT)
    def blueBright: String = render(str, BLUE_BRIGHT)
    def magentaBright: String = render(str, MAGENTA_BRIGHT)
    def cyanBright: String = render(str, CYAN_BRIGHT)
    def whiteBright: String = render(str, WHITE_BRIGHT)

    // background colors
    def bgBlack: String = render(str, BG_BLACK)
    def bgRed: String = render(str, BG_RED)
    def bgGreen: String = render(str, BG_GREEN)
    def bgYellow: String = render(str, BG_YELLOW)
    def bgBlue: String = render(str, BG_BLUE)
    def bgMagenta: String = render(str, BG_MAGENTA)
    def bgCyan: String = render(str, BG_CYAN)
    def bgWhite: String = render(str, BG_WHITE)
    def bgBlackBright: String = render(str, BG_BLACK_BRIGHT)
    def bgGray: String = bgBlackBright
    def bgGrey: String = bgBlackBright
    def bgRedBright: String = render(str, BG_RED_BRIGHT)
    def bgGreenBright: String = render(str, BG_GREEN_BRIGHT)
    def bgYellowBright: String = render(str, BG_YELLOW_BRIGHT)
    def bgBlueBright: String = render(str, BG_BLUE_BRIGHT)
    def bgMagentaBright: String = render(str, BG_MAGENTA_BRIGHT)
    def bgCyanBright: String = render(str, BG_CYAN_BRIGHT)
    def bgWhiteBright: String = render(str, BG_WHITE_BRIGHT)

    // rgb/truecolor
    def rgb(red: Int, green: Int, blue: Int): String = renderTruecolor(str, (red, green, blue))
    def bgRgb(red: Int, green: Int, blue: Int): String =
      renderBgTruecolor(str, (red, green, blue))
    def truecolor(red: Int, green: Int, blue: Int): String = rgb(red, green, blue)
    def bgTruecolor(red: Int, green: Int, blue: Int): String = bgRgb(red, green, blue)

    // hex
    def hex(colorHex: String): String = {
      val rgb = hexToRgb(colorHex)
      renderTruecolor(str, rgb)
    }
    def bgHex(colorHex: String): String = {
      val rgb = hexToRgb(colorHex)
      renderBgTruecolor(str, rgb)
    }

    // css named colors
    def color(colorName: String): String = {
      val rgb = ColorMap.getRgb(colorName)
      renderTruecolor(str, rgb)
    }
    def css(colorName: String): String = color(colorName)
    def bgColor(colorName: String): String = {
      val rgb = ColorMap.getRgb(colorName)
      renderBgTruecolor(str, rgb)
    }
    def bgCss(colorName: String): String = bgColor(colorName)

    // gradients
    def gradient[A](colors: A*)(implicit color: Color[A]): String = {
      val rgbColors = colors.map(color.toRGB)
      renderGradient(str, rgbColors)
    }

    def bgGradient[A](colors: A*)(implicit color: Color[A]): String = {
      val rgbColors = colors.map(color.toRGB)
      renderBgGradient(str, rgbColors)
    }
  }
}

object Brush extends Brush
