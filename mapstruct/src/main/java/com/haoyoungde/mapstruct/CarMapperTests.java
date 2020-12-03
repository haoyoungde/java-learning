package com.haoyoungde.mapstruct;

public class CarMapperTests {
  public static void main(String[] args) {
    Car car = new Car( "Morris", 5, CardType.BENZ );

    CarDto carDto = CarMapper.INSTANCE.carToCarDto( car );

    System.out.println(carDto);
    System.out.println(car);
  }
}
