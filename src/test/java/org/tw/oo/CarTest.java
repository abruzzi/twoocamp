package org.tw.oo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CarTest {
    private Car car;
    @Before
    public void setup() {
        car = new Car();
    }

    @Test
    public void shouldDisplayFlameout(){
        String status = car.getStatus();
        assertThat(status, is("Flameout"));
    }

    @Test
    public void shouldDisplayStartUpWhenCarIsStarted(){
        car.start();
        String status = car.getStatus();

        assertThat(status, is("StartUp"));
    }

    @Test
    public void shouldChangeStatus(){
        car.start();
        assertThat(car.getStatus(), is("StartUp"));

        car.stop();
        assertThat(car.getStatus(), is("Flameout"));
    }

    @Test
    public void shouldDisplayFlameOutWithGearUpWhenFlameOut(){
        car.gearUp();

        assertThat(car.getStatus(), is("Flameout"));
    }

    @Test
    public void shouldDisplayFlameOutWithGearUpWhenStartUp(){
        car.start();
        car.gearUp();

        assertThat(car.getStatus(), is("Geared"));
    }

    @Test
    public void shouldDisplayFlameOutWithAcceleratorWhenFlameOut(){
        car.accelerate();

        assertThat(car.getStatus(), is("Flameout"));
    }

    @Test
    public void shouldDisplayRotatingWithAcceleratorWhenStatedWithoutGeared(){
        car.start();
        car.accelerate();

        assertThat(car.getStatus(), is("Rotating"));
    }

    @Test
    public void shouldDisplayMovingWhenStartedupWithGearedAndAccelerated(){
        car.start();
        car.gearUp();
        car.accelerate();

        assertThat(car.getStatus(), is("Moving"));
    }
}
