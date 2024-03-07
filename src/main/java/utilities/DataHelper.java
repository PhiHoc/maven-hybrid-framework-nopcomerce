package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
    Faker faker = new Faker(Locale.ENGLISH);
    public static DataHelper getDataHelper(){
        return new DataHelper();
    }

    public String getFirtName(){
        return faker.name().firstName();
    }
    public String getLastName(){
        return faker.name().lastName();
    }

    public String getEmail(){
        return faker.internet().emailAddress();
    }

    public String getCompanyName(){
        return faker.company().name();
    }

    public String getPhoneNumber(){
        return faker.phoneNumber().phoneNumber();
    }

    public String getCity(){
        return faker.address().city();
    }

    public String getPassword(){
        return faker.internet().password(8,16,true,true);
    }
}
