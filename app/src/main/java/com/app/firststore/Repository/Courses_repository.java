package com.app.firststore.Repository;

import android.net.http.HttpResponseCache;

import com.app.firststore.Model.Courses_2;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Courses_repository {
    /*public static void getAll(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://freevds.dionisiubrovka.online/api/v1/courses/").header("Authorization", "Token 56b9c85926d4bc57aa4e34ede2b92652f221b7c7")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) {
                        throw new IOException("Запрос к серверу не был успешен: " +
                                response.code() + " " + response.message());
                    }

                    // пример получения всех заголовков ответа
                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        // вывод заголовков
                        System.out.println(responseHeaders.name(i) + ": "
                                + responseHeaders.value(i));
                    }
                    // вывод тела ответа
                    System.out.println(responseBody.string());
                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<Courses_2>>() {
                    }.getType();

                    // Преобразуйте JSON список объектов обратно в объекты
                    List<Courses_2> objects = gson.fromJson(responseBody.string(), listType);

                    // Переберите объекты в списке
                    for (Courses_2 obj : objects) {
                        System.out.println(obj.getId() + " - " + obj.getTitle());
                    }
                }
            }
        });
    }*/
}
