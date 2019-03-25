package spring.struts.springdatamongo.common.json;

import java.sql.Timestamp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
/**
 * 转json
 * @author 开发
 *
 */
public class GsonJson {

	private static final Gson gson;
	static {
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter())
				.registerTypeAdapter(java.sql.Date.class, new SQLDateTypeAdapter()).create();
	}

	public static String parseDataToJson(Object obj) {
		return gson.toJson(obj);
	}

	public static <T> T parseJsonToData(String json, Class<T> cls) {
		T t = gson.fromJson(json, cls);
		return t;
	}

	@SuppressWarnings("unchecked")
	public static <T> T parseJsonToData(String json, TypeToken<T> token) {
		T obj = (T) gson.fromJson(json, token.getType());
		return obj;
	}

	public static <T> T parseJsonToData(JsonElement element, Class<T> c) {
		return gson.fromJson(element, c);
	}

}
