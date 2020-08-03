package com.haoyoungde.joda.money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class Main {
  public static void main(String[] args) {
    //create a monetary value
    Money money = Money.parse("USD 23.87");
    System.out.println(money);

    //add another amount with safe
    CurrencyUnit usd = CurrencyUnit.of("USD");
    money = money.plus(Money.of(usd, 12.43d));
    System.out.println(money);

    //substract an amount in dollars
    money = money.minusMajor(2);
    System.out.println(money);

    //multiplies by 3.5 with rounding
    money = money.multipliedBy(3.5d, RoundingMode.DOWN);
    System.out.println(money);

    //compare two amounts
    boolean bigAmount = money.isGreaterThan(Money.parse("USD 1"));
    System.out.println(bigAmount);

    //convert to GBP using a supplied rate
    BigDecimal conversionRate = BigDecimal.valueOf(7);
    Money moneyCNY = Money.parse("USD 1").convertedTo(CurrencyUnit.of(Locale.CHINA), conversionRate, RoundingMode.HALF_UP);
    System.out.println(moneyCNY);

    //use a BigMoney for more complex calculations where scale matters
    BigMoney bigMoney = money.toBigMoney();
    System.out.println(bigMoney);
  }
}
