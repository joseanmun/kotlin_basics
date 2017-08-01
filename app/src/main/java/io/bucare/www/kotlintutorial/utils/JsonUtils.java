package io.bucare.www.kotlintutorial.utils;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public final class JsonUtils {
  private static final String JSON_FOLDER = "jsons/";
  private static final String JSON_EXTENSION = ".json";

  private JsonUtils() {
  }

  public static <T> T fileToClass(Context context, String fileName, Class<T> object)
      throws IOException {

    JsonReader jsonReader = readJsonFile(context,
                                         fileName);
    return new Gson().fromJson(jsonReader,
                               object);
  }

  public static <T> T fileToClass(Context context, String fileName, Type type) throws IOException {

    JsonReader jsonReader = readJsonFile(context,
                                         fileName);
    return new Gson().fromJson(jsonReader,
                               type);
  }

  private static JsonReader readJsonFile(Context context, String fileName) throws IOException {
    String fileNameConcat = "";
    if (!fileName.endsWith(JSON_EXTENSION)) {
      fileNameConcat = fileName.concat(JSON_EXTENSION);
    }
    InputStreamReader inputStreamReader;
    JsonReader jsonReader;
    try {
      inputStreamReader = new InputStreamReader(context.getAssets()
                                                    .open(fileName));
      jsonReader = new JsonReader(inputStreamReader);
      return jsonReader;
    } catch (IOException ex) {
      Log.w("Couldn't read file: " + fileNameConcat + JSON_EXTENSION + " inside assets folder",
            ex);
      throw ex;
    }
  }
}

