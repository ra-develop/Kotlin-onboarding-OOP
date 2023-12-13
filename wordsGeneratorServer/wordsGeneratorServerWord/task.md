The **goal** of this step is to implement the `Word` and `WordServices` classes.

First of all, create a value class `Word` with one `String` property `word` to store a word in the `jetbrains.kotlin.course.words.generator.word` package in the `WordModel.kt` file.

Next, find the already added `WordServices` class in the `jetbrains.kotlin.course.words.generator.word` package and modify it:
- Add a companion object to the `WordServices` class and declare the `numberOfWords` variable to store the number
  of words in the game. Initialize this variable as the _size_ of the predefined list of words `words`.
- Implement the `generateNextWord` function: if the `words` list _is empty_, throw an error;
  else, get the first element from the `words` list and remove it from the list, then create a new `Word` and return it.

<div class="hint" title="I press Check and see a compilation error">

  If you have a compilation error and you have not solved this step yet, please solve the task and try again. 
  It is expected behavior, since the code requires the class `Word`, but it does not exist.
</div>

If you have any difficulties, **hints will help you solve this task**.

----

### Hints

<div class="hint" title="Why do we use the value class?">

Of course, we can just use the `String` type or create a type alias for the `String` type.
All of these options will undoubtedly work in our case.
However, the _purpose_ of this course is to show you the power of Kotlin so that you can
choose the option you like best in the future.
</div>

<div class="hint" title="Why does numberOfWords not a const value?">

We cannot mark the `numberOfWords` variable with the `const` keyword, since we use `words.size` of a mutable list `words`,
which potentially can be changed.
</div>

<div class="hint" title="The `isEmpty` built-in function">

If you need to check whether a list is empty or not, you can check its size or use the built-in [isEmpty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/is-empty.html) function:

  ```kotlin
  val numbers = listOf(1, 2, 3)
  if (numbers.size == 0) {
      TODO()
  }
  ```
It is the **same** as

  ```kotlin
  val numbers = listOf(1, 2, 3)
  if (numbers.isEmpty()) {
      TODO()
  }
  ```
</div>

<div class="hint" title="The `removeFirst` built-in function">

If you need to get the first element from a mutable list and next remove it, you can use the built-in [removeFirst](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/remove-first.html) function:

```kotlin
fun main() {
    val numbers = mutableListOf(2, 3, 4, 5)
    val first = numbers.first()
    numbers.drop(1)
    println(first) // 2
    println(numbers) // [3, 4, 5]
}
```
It is the **same** as

```kotlin
fun main() {
    val numbers = mutableListOf(2, 3, 4, 5)
    val first = numbers.removeFirst()
    println(first) // 2
    println(numbers) // [3, 4, 5]
}
```
</div>
