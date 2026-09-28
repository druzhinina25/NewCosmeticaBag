package com.cosmetica.service;

import com.cosmetica.bag.CosmeticsBag;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class FileStorage {
private final ObjectMapper mapper;

    public FileStorage() {
        this.mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    //сохраняем косметичку в файл
    public void save(CosmeticsBag bag, String path) throws IOException {
            mapper.writeValue(new File(path),bag);
            System.out.println("Косметичка загрузилась в файл: "+ path);
    }
    //загружаем косметичку из файла
    public CosmeticsBag loading(String path) throws IOException {
        System.out.println("Загружаем косметичку из файла...");
        return mapper.readValue(new File(path), CosmeticsBag.class);
    }
}
