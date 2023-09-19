import minitest._
import brush.test.TestUtils._
import brush._

// The tests should be ran on a terminal that supports truecolor.
// You can use FORCE_COLOR=3 to force truecolor support.

object BrushTest extends SimpleTestSuite {
  test("modifiers") {
    expect("reset".reset, "\u001B[0mreset\u001B[0m")
    expect("bold".bold, "\u001B[1mbold\u001B[22m")
    expect("dim".dim, "\u001B[2mdim\u001B[22m")
    expect("italic".italic, "\u001B[3mitalic\u001B[23m")
    expect("underline".underline, "\u001B[4munderline\u001B[24m")
    expect("overline".overline, "\u001B[53moverline\u001B[55m")
    expect("inverse".inverse, "\u001B[7minverse\u001B[27m")
    expect("hidden".hidden, "\u001B[8mhidden\u001B[28m")
    expect("strikethrough".strikethrough, "\u001B[9mstrikethrough\u001B[29m")
  }

  test("text colors") {
    expect("black".black, "\u001B[30mblack\u001B[39m")
    expect("red".red, "\u001B[31mred\u001B[39m")
    expect("green".green, "\u001B[32mgreen\u001B[39m")
    expect("yellow".yellow, "\u001B[33myellow\u001B[39m")
    expect("blue".blue, "\u001B[34mblue\u001B[39m")
    expect("magenta".magenta, "\u001B[35mmagenta\u001B[39m")
    expect("cyan".cyan, "\u001B[36mcyan\u001B[39m")
    expect("white".white, "\u001B[37mwhite\u001B[39m")
    expect("blackBright".blackBright, "\u001B[90mblackBright\u001B[39m")
    expect("gray".gray, "\u001B[90mgray\u001B[39m")
    expect("grey".grey, "\u001B[90mgrey\u001B[39m")
    expect("redBright".redBright, "\u001B[91mredBright\u001B[39m")
    expect("greenBright".greenBright, "\u001B[92mgreenBright\u001B[39m")
    expect("yellowBright".yellowBright, "\u001B[93myellowBright\u001B[39m")
    expect("blueBright".blueBright, "\u001B[94mblueBright\u001B[39m")
    expect("magentaBright".magentaBright, "\u001B[95mmagentaBright\u001B[39m")
    expect("cyanBright".cyanBright, "\u001B[96mcyanBright\u001B[39m")
    expect("whiteBright".whiteBright, "\u001B[97mwhiteBright\u001B[39m")
  }

  test("background text colors") {
    expect("bgBlack".bgBlack, "\u001B[40mbgBlack\u001B[49m")
    expect("bgRed".bgRed, "\u001B[41mbgRed\u001B[49m")
    expect("bgGreen".bgGreen, "\u001B[42mbgGreen\u001B[49m")
    expect("bgYellow".bgYellow, "\u001B[43mbgYellow\u001B[49m")
    expect("bgBlue".bgBlue, "\u001B[44mbgBlue\u001B[49m")
    expect("bgMagenta".bgMagenta, "\u001B[45mbgMagenta\u001B[49m")
    expect("bgCyan".bgCyan, "\u001B[46mbgCyan\u001B[49m")
    expect("bgWhite".bgWhite, "\u001B[47mbgWhite\u001B[49m")
    expect("bgBlackBright".bgBlackBright, "\u001B[100mbgBlackBright\u001B[49m")
    expect("bgGray".bgGray, "\u001B[100mbgGray\u001B[49m")
    expect("bgGrey".bgGrey, "\u001B[100mbgGrey\u001B[49m")
    expect("bgRedBright".bgRedBright, "\u001B[101mbgRedBright\u001B[49m")
    expect("bgGreenBright".bgGreenBright, "\u001B[102mbgGreenBright\u001B[49m")
    expect("bgYellowBright".bgYellowBright, "\u001B[103mbgYellowBright\u001B[49m")
    expect("bgBlueBright".bgBlueBright, "\u001B[104mbgBlueBright\u001B[49m")
    expect("bgMagentaBright".bgMagentaBright, "\u001B[105mbgMagentaBright\u001B[49m")
    expect("bgCyanBright".bgCyanBright, "\u001B[106mbgCyanBright\u001B[49m")
    expect("bgWhiteBright".bgWhiteBright, "\u001B[107mbgWhiteBright\u001B[49m")
  }

  test("rgb") {
    expect("rgb".rgb(255, 0, 0), "\u001B[38;2;255;0;0mrgb\u001B[39m")
    expect("bgRgb".bgRgb(255, 0, 0), "\u001B[48;2;255;0;0mbgRgb\u001B[49m")
    expect("truecolor".truecolor(255, 0, 0), "\u001B[38;2;255;0;0mtruecolor\u001B[39m")
    expect("bgTruecolor".bgTruecolor(255, 0, 0), "\u001B[48;2;255;0;0mbgTruecolor\u001B[49m")
  }

  test("hex") {
    expect("hex".hex("#ff0000"), "\u001B[38;2;255;0;0mhex\u001B[39m")
    expect("hex".hex("ff0000"), "\u001B[38;2;255;0;0mhex\u001B[39m")
    expect("bgHex".bgHex("#ff0000"), "\u001B[48;2;255;0;0mbgHex\u001B[49m")
    expect("bgHex".bgHex("ff0000"), "\u001B[48;2;255;0;0mbgHex\u001B[49m")
  }

  test("multiple colors & modifiers") {
    expect(
      "multi".red.bgGreen.bold.underline,
      "\u001B[4m\u001B[1m\u001B[42m\u001B[31mmulti\u001B[39m\u001B[49m\u001B[22m\u001B[24m"
    )
  }

  test("css named colors") {
    expect("aliceblue".color("aliceblue"), "\u001B[38;2;240;248;255maliceblue\u001B[39m")
    expect("antiquewhite".css("antiquewhite"), "\u001B[38;2;250;235;215mantiquewhite\u001B[39m")
    expect("aqua".bgColor("aqua"), "\u001B[48;2;0;255;255maqua\u001B[49m")
    expect("aquamarine".bgCss("aquamarine"), "\u001B[48;2;127;255;212maquamarine\u001B[49m")
  }

  val redBlueGradientAnsi =
    "\u001B[38;2;255;0;0mg\u001B[39m\u001B[38;2;223;0;31mr\u001B[39m\u001B[38;2;191;0;63ma\u001B[39m\u001B[38;2;159;0;95md\u001B[39m\u001B[38;2;127;0;127mi\u001B[39m\u001B[38;2;95;0;159me\u001B[39m\u001B[38;2;63;0;191mn\u001B[39m\u001B[38;2;31;0;223mt\u001B[39m";
  val redBlueBgGradientAnsi =
    "\u001B[48;2;255;0;0mb\u001B[49m\u001B[48;2;229;0;25mg\u001B[49m\u001B[48;2;204;0;51mG\u001B[49m\u001B[48;2;178;0;76mr\u001B[49m\u001B[48;2;153;0;102ma\u001B[49m\u001B[48;2;127;0;127md\u001B[49m\u001B[48;2;102;0;153mi\u001B[49m\u001B[48;2;76;0;178me\u001B[49m\u001B[48;2;50;0;204mn\u001B[49m\u001B[48;2;25;0;229mt\u001B[49m"

  test("gradient with named css color") {
    expect(
      "gradient".gradient("red", "blue"),
      redBlueGradientAnsi
    )
    expect(
      "bgGradient".bgGradient("red", "blue"),
      redBlueBgGradientAnsi
    )
  }

  test("gradient with hex color") {
    expect(
      "gradient".gradient("#ff0000", "#0000ff"),
      redBlueGradientAnsi
    )
    expect(
      "gradient".gradient("ff0000", "0000ff"),
      redBlueGradientAnsi
    )
    expect(
      "bgGradient".bgGradient("#ff0000", "#0000ff"),
      redBlueBgGradientAnsi
    )
    expect(
      "bgGradient".bgGradient("ff0000", "0000ff"),
      redBlueBgGradientAnsi
    )
  }

  test("gradient with rgb color") {
    expect(
      "gradient".gradient((255, 0, 0), (0, 0, 255)),
      redBlueGradientAnsi
    )
    expect(
      "bgGradient".bgGradient((255, 0, 0), (0, 0, 255)),
      redBlueBgGradientAnsi
    )
  }

  test("gradient with multiple colors") {
    expect(
      "gradient".gradient("red", "blue", "green"),
      "\u001B[38;2;255;0;0mg\u001B[39m\u001B[38;2;191;0;63mr\u001B[39m\u001B[38;2;127;0;127ma\u001B[39m\u001B[38;2;63;0;191md\u001B[39m\u001B[38;2;0;0;255mi\u001B[39m\u001B[38;2;0;32;191me\u001B[39m\u001B[38;2;0;64;127mn\u001B[39m\u001B[38;2;0;96;63mt\u001B[39m"
    )
    expect(
      "bgGradient".bgGradient("red", "blue", "green"),
      "\u001B[48;2;255;0;0mb\u001B[49m\u001B[48;2;204;0;51mg\u001B[49m\u001B[48;2;153;0;102mG\u001B[49m\u001B[48;2;102;0;153mr\u001B[49m\u001B[48;2;50;0;204ma\u001B[49m\u001B[48;2;0;0;255md\u001B[49m\u001B[48;2;0;25;204mi\u001B[49m\u001B[48;2;0;51;153me\u001B[49m\u001B[48;2;0;76;101mn\u001B[49m\u001B[48;2;0;102;50mt\u001B[49m"
    )
  }

  test("avoid wrapping existing ansi codes with gradient ansi codes") {
    expect(
      "gradient".bold.gradient("red", "blue"),
      "\u001B[1m" + redBlueGradientAnsi + "\u001B[22m"
    )
    expect(
      "bgGradient".bold.bgGradient("red", "blue"),
      "\u001B[1m" + redBlueBgGradientAnsi + "\u001B[22m"
    )
  }
}
