package com.zjgt.thirdpay.v2.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

public class GsonUtil
{
  private static Gson gson = null;

  public static <T> T fromJsonUnderScoreStyle(String json, Class<T> classOfT)
  {
    return gson.fromJson(json, classOfT);
  }

  public static <T> T fronJson2Map(String json)
  {
    return gson.fromJson(json, new TypeToken() {  }
    .getType());
  }

  public static String toJson(Object src)
  {
    return gson.toJson(src);
  }

  static
  {
    gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
  }
}