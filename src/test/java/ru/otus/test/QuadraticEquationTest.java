package ru.otus.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class QuadraticEquationTest {
    @InjectMocks
    QuadraticEquation quadraticEquation;

    @Test
    void solve_return_empty() {
        //Given
        double a = 1, b = 0, c = 1, e = 1e-5;

        //When
        double[] result = quadraticEquation.solve(a, b, c, e);

        //Then
        assertThat(result).isEmpty();
    }

    @Test
    void solve_should_return_two_roots() {
        //Given
        double a = 1, b = 0, c = -1, e = 1e-5;

        //When
        double[] result = quadraticEquation.solve(a, b, c, e);

        //Then
        assertThat(result).hasSize(2);
        assertThat(result).contains(1, -1);
    }

    @Test
    void solve_should_return_one_root() {
        //Given
        double a = 1, b = 2, c = 1, e = 1e-5;

        //When
        double[] result = quadraticEquation.solve(a, b, c, e);

        //Then
        assertThat(result).hasSize(2);
        assertThat(result).contains(-1);
    }

    @Test
    void solve_should_throw_exception_when_b_is_0() {
        //Given
        double a = 1e-7, b = 0, c = -1, e = 1e-5;

        //When
        //Then
        assertThatThrownBy(() -> quadraticEquation.solve(a, b, c, e)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void solve_should_return_one_root_when_D_less_then_e() {
        //Given
        double a = 1, b = 3 * 1e-3, c = 1e-6, e = 1e-5;

        //When
        double[] result = quadraticEquation.solve(a, b, c, e);

        //Then
        assertThat(result).hasSize(2);
        assertThat(result[0]).isEqualTo(result[1]);
    }

    @Test
    void solve_should_throw_exception_when_a_is_nan() {
        //Given
        double a = Double.NaN, b = 0, c = -1, e = 1e-5;

        //When
        //Then
        assertThatThrownBy(() -> quadraticEquation.solve(a, b, c, e)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void solve_should_throw_exception_when_b_is_nan() {
        //Given
        double a = 1, b = Double.NaN, c = -1, e = 1e-5;

        //When
        //Then
        assertThatThrownBy(() -> quadraticEquation.solve(a, b, c, e)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void solve_should_throw_exception_when_c_is_nan() {
        //Given
        double a = 1, b = 0, c =  Double.NaN, e = 1e-5;

        //When
        //Then
        assertThatThrownBy(() -> quadraticEquation.solve(a, b, c, e)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void solve_should_throw_exception_when_a_is_infinity() {
        //Given
        double a = Double.POSITIVE_INFINITY, b = 0, c = -1, e = 1e-5;

        //When
        //Then
        assertThatThrownBy(() -> quadraticEquation.solve(a, b, c, e)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void solve_should_throw_exception_when_b_is_infinity() {
        //Given
        double a = 1, b = Double.POSITIVE_INFINITY, c = -1, e = 1e-5;

        //When
        //Then
        assertThatThrownBy(() -> quadraticEquation.solve(a, b, c, e)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void solve_should_throw_exception_when_c_is_infinity() {
        //Given
        double a = 1, b = 0, c = Double.POSITIVE_INFINITY, e = 1e-5;

        //When
        //Then
        assertThatThrownBy(() -> quadraticEquation.solve(a, b, c, e)).isInstanceOf(IllegalArgumentException.class);
    }
}
