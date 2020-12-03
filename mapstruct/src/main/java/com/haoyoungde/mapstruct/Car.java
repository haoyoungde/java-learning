package com.haoyoungde.mapstruct;

public class Car {
  private String make;
  private int numberOfSeats;
  private CardType Type;

  public Car(String make, int numberOfSeats, CardType type) {
    this.make = make;
    this.numberOfSeats = numberOfSeats;
    Type = type;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public CardType getType() {
    return Type;
  }

  public void setType(CardType type) {
    Type = type;
  }

  @Override
  public String toString() {
    return "Car{" +
            "make='" + make + '\'' +
            ", numberOfSeats=" + numberOfSeats +
            ", Type=" + Type +
            '}';
  }
}
