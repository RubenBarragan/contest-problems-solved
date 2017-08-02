# 4 Keys Keyboard

## Problem
In a 4-keys keyboard and a textbox, the only operations that can be performed by these keys are:

1. `A`: Prints one 'A' on the screen.
2. `Ctrl-A`: Select the whole text of the screen.
3. `Ctrl-C`: Copy the selection to the buffer.
4. `Ctrl-V`: Paste the buffer on the textbox appending it after what is already there.

The four keys can only be pressed for *n* times. You have to find the maximum number of 'A's you can print on the textbox (screen).

## Examples
For *n* = 4, the number of As I can print is 4. Two ways of use those *n* operations are:

1. `A`, then `Ctrl-A`+`Ctrl-C`+`Ctrl-V`. With this the result is only one A = 1.
2. `A`+`A`+`A`+`A`. In this case, the result is AAAA = 4.

Which option is better? Number two.

For *n* = 7, the result is 9. This is because the sequence of operations is `A`+`A`+`A`+`Ctrl-A`+`Ctrl-C`+`Ctrl-V`+`Ctrl-V`, giving a result of AAAAAAAAA = 9.

## Source
[Leetcode](https://leetcode.com)