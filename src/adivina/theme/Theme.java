package adivina.theme;

import java.awt.*;

/**
 */
public class Theme
{
    // Font
    public static final String FONT_FAMILY           = "Serif";
    public static final Font FONT_DEFAULT           = new Font(FONT_FAMILY, Font.PLAIN, 18);
    public static final Font FONT_DEFAULT_BOLD      = new Font(FONT_FAMILY, Font.BOLD, 16);
    public static final Font FONT_DEFAULT_SMALL     = new Font(FONT_FAMILY, Font.PLAIN, 12);
    public static final Font FONT_DEFAULT_MEDIUM    = new Font(FONT_FAMILY, Font.PLAIN, 18);
    public static final Font FONT_DEFAULT_LARGE     = new Font(FONT_FAMILY, Font.PLAIN, 32);
    public static final Font FONT_DEFAULT_BIG       = new Font(FONT_FAMILY, Font.PLAIN, 48);

    // Custom Colors
    public static final Color GREEN_EMERALD = new Color(39, 174, 96);
    public static final Color MIDNIGHT_BLUE = new Color(44, 62, 80);
    public static final Color SILVER = new Color(189, 195, 199);
    public static final Color DARKER_MIDNIGHT_BLUE = new Color(27, 54, 80);

    public static final Color BACKGROUND_COLOR = Color.DARK_GRAY;


    // Font Colors
    public static final Color FONT_DEFAULT_COLOR = Color.WHITE;
    public static final Color FONT_INPUT_COLOR = Color.WHITE;
    public static final Color FONT_WARNING_COLOR = Color.RED;
    public static final Color FONT_SUCCESS_COLOR = Color.GREEN;

    // Layout
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;


    // Custom Button properties
    public static final Font BTN_DEFAULT_FONT = FONT_DEFAULT_MEDIUM;
    public static final Color BTN_DEFAULT_COLOR = MIDNIGHT_BLUE;
    public static final Color BTN_DEFAULT_TEXT_COLOR = FONT_DEFAULT_COLOR;
    public static final Color BTN_DEFAULT_TEXT_HOVER_COLOR = FONT_INPUT_COLOR;
    public static final int BTN_DEFAULT_HEIGHT = 28;
    public static final int BTN_DEFAULT_WIDTH = 150;

    public static final int BORDER_PLUS = 4;// border color difference
    public static final int HOVER_PLUS = 20; // color change when hovering

    // TextInputs
    public static final Font INPUT_TEXT_FONT = FONT_DEFAULT_MEDIUM;
    public static final int LABELED_MARGIN = 2;
    public static final int BTN_ICON_SIZE = 84;

    // Custom Settings
}
