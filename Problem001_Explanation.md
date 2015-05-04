# Problem 1 - Multiples of 3 and 5  

_If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9._  
_The sum of these multiples is 23._  
_Find the sum of all the multiples of 3 or 5 below 1000._  
<br /><br />
Using the probability theory,  
multiple (3 or 5) = multiple(3) + multiple(5) - multiple (3 and 5)  
Since the sum of consecutive integers from 1 to n is (n)(n+1)/2  
multiple(3) = 3 + 6 + 9 + 12 + 15 + ... = 3 * (1 + 2 + 3 + 4 + 5 + ...)  
= 3 * (n)(n+1)/2  
multiple (3 or 5) = 166833 + 99500 - 33165 = 233168  

