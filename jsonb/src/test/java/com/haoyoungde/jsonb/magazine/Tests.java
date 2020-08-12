package com.haoyoungde.jsonb.magazine;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.json.bind.config.PropertyOrderStrategy;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.Test;

public class Tests {
    @Test
    public void test() throws MalformedURLException {
        Magazine magazine = new Magazine();
        magazine.setId("id");
        magazine.setTitle("title");
        Author author = new Author();
        author.setFirstName("firstName");
        author.setLastName("lastName");
        magazine.setAuthor(author);
        magazine.setPrice(0.0F);
        magazine.setPages(0);
        magazine.setInPrint(false);
        magazine.setBinding(Binding.HARD_BACK);
        magazine.setLanguages(Arrays.asList("中文", "英文", null));
        magazine.setWebsite(new URL("http://localhost:8080"));
        magazine.setInternalAuditCode("internalAuditCode");
        magazine.setPublished(LocalDate.now());
        magazine.setAlternativeTitle(null);
        String json = JsonbBuilder.create().toJson(magazine);
        System.out.println(json);
        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyOrderStrategy(PropertyOrderStrategy.REVERSE)
                .withNullValues(true);
        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);
        json = jsonb.toJson(magazine);
        System.out.println(json);
    }
}
