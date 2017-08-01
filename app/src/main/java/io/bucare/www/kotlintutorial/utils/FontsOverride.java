package io.bucare.www.kotlintutorial.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import java.lang.reflect.Field;

public final class FontsOverride {
  public static final String TAG = "FontsOverride";

  private FontsOverride() {
  }

  public static void overrideNormalFonts(Context context, String normalFontFilename,
                                         String italicFontFileName, String boldFontFilename,
                                         String boldItalicFontFilename)
      throws IllegalAccessException {
    Log.v(TAG,
          "overrideNormalFonts bold with : " + boldFontFilename);
    final Typeface bold = Typeface.createFromAsset(context.getAssets(),
                                                   boldFontFilename);

    Log.v(TAG,
          "overrideNormalFonts italic with : " + italicFontFileName);
    final Typeface italic = Typeface.createFromAsset(context.getAssets(),
                                                     italicFontFileName);

    Log.v(TAG,
          "overrideNormalFonts bold italic with : " + boldItalicFontFilename);
    final Typeface boldItalic = Typeface.createFromAsset(context.getAssets(),
                                                         boldItalicFontFilename);

    Log.v(TAG,
          "overrideNormalFonts normal with : " + normalFontFilename);
    final Typeface normal = Typeface.createFromAsset(context.getAssets(),
                                                     normalFontFilename);

    Field defaultField = null;
    try {
      defaultField = Typeface.class.getDeclaredField("DEFAULT");
      defaultField.setAccessible(true);
      defaultField.set(null,
                       normal);

      Field defaultBoldField = Typeface.class.getDeclaredField("DEFAULT_BOLD");
      defaultBoldField.setAccessible(true);
      defaultBoldField.set(null,
                           bold);

      Field sDefaults = Typeface.class.getDeclaredField("sDefaults");
      sDefaults.setAccessible(true);
      sDefaults.set(null,
                    new Typeface[] { normal, bold, italic, boldItalic });
    } catch (NoSuchFieldException e) {
      Log.e(TAG,
            e.getMessage(),
            e.getCause());
    }
  }
}
