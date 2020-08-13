package com.haoyoungde.jsonb.book;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.junit.Assert;
import org.junit.Test;

public class Tests {
    @Test
    public void test(){
        Jsonb jsonb = JsonbBuilder.create();
        Book book = new Book();
        book.setId("1");
        book.setTitle("title");
        book.setAuthor("author");
        System.out.println(book);
        String jsonStr = jsonb.toJson(book);
        Book book1 = jsonb.fromJson(jsonStr, Book.class);
        Assert.assertSame(book,book1);

    }
}
