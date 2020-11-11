# Task 7 №33
33. (*) Вводится массив целых чисел. Найти такую подпоследовательность длины n (n – задается) подряд идущих элементов массива, которая максимально часто повторяется в исходном массиве (реализовать функцию, которая будет возвращать позицию первого элемента такой подпоследовательности). Если таких подпоследовательностей несколько, вернуть самую первую. При подсчете повторений, учесть, что эти самые повторения не должны накладываться друг на друга. Например, для массива { -3, 7, 3, 4, 8, 4, 8, 4, 7, 3, 4, 8, 0, 6, -1, 4, 7, 3, 3 } и n = 3 две подпоследовательности длины n повторяются по 2 раза – { 7, 3, 4 } и { 3, 4, 8 } (стоит обратить внимание, что c учетом непересечений { 4, 8, 4 } повторяется только 1 раз). Таким образом правильным ответом будет { 7, 3, 4 } (функция вернет 1 – индекс первого элемента первого повторения данной подпоследовательности). 