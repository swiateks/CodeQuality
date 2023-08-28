package com.github.samples.solid.dip.solution;
public class Program {
    
        public static void Main(string[] args)
        {
            //for production
            Vehicle racingCar = new Vehicle(new RacingCar(100));
    
            //for unit test
            Vehicle racingCarTest = new Student(new RacingCar(120));
        }
    }
