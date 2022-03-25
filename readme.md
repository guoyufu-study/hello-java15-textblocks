# 文本块

> [文本块程序员指南](https://docs.oracle.com/en/java/javase/18/text-blocks/index.html)
> 
> [JEP 378：文本块](https://openjdk.java.net/jeps/378)
>

文本块是一个多行字符串文字，它避免了大多数转义序列的需要，以可预测的方式自动格式化字符串，并在需要时让开发人员控制格式。

## 介绍

原则：通过最小化呈现跨越多行的字符串所需的 Java 语法来提供清晰度

文本块是 Java 字符串表示的另一种形式，可以在任何可以使用传统双引号字符串文字的地方使用。比如：字符串连接表达式、方法参数、字符串方法

从文本块生成的对象`java.lang.String` 与传统的双引号字符串具有相同的特征。这包括对象表示和扣押`intern`。

使用字符串文字表示多行字符串时，可以使用文本块代替字符串文字，以提高代码的可读性和清晰度。 因为在这种情况下，引号、换行符转义和连接运算符会造成相当大的混乱，而使用文本块消除了很多混乱。

## 使用文本块

### 文本块语法

**文本块以三个双引号字符开头，后跟一个行终止符**。您不能将文本块放在单行上，文本块的内容也不能在没有中间行终止符的情况下跟随三个开始的双引号。这样做的原因是文本块主要设计用于支持多行字符串，并且要求初始行终止符**简化了缩进处理规则**。 无需转义嵌入的双引号。

### 最后的新行

将结束分隔符放在最后一个可见行上会有效地删除最后一个`\n`.

### 附带的空白

理想情况下，文本块将缩进以匹配周围代码的缩进。

为了解决这个问题，文本块将偶然的空白与必要的空白区分开来。Java 编译器会自动去除附带的空白。

JEP 378 中详细描述了用于确定偶然空白的算法。然而，最终效果非常简单。文本块的全部内容向左移动，直到前导空白最少的行没有前导空白。

要保留一些空白而不将其视为偶然空白，只需将文本块的内容行向右移动，同时将结束的三引号分隔符保留在适合周围代码的缩进处。因此，文本块可以通过将结束分隔符放置在源行的第一个字符位置来选择不附带的空白剥离。

这种用于控制保留的缩进量的技术仅在文本块的最后一行以行终止符结尾时才有效。如果最后一行没有以行终止符结尾，则需要使用`String::indent`显式控制缩进。要在字符串内容中包含一些缩进，请在文本块上调用该方法。

### 尾随空格

文本块中每一行的尾随空白也被认为是偶然的，并被 Java 编译器删除。这样做是为了使文本块的内容始终在视觉上可辨别。如果不这样做，自动去除尾随空格的文本编辑器可能会无形地更改文本块的内容。

如果需要在文本块中包含尾随空格，有多种策略：`replace`的字符替换和字符栅栏、空白的八进制转义序列`\040`。

> 注意： `\u0020`不能使用，因为 Unicode 转义在源文件读取过程中，在词法分析之前被翻译。相比之下，诸如`\040` 在词法分析将源文件划分为标记并识别字符串文字和文本块之后处理的字符和字符串转义。
> 

### 检测空白区域的潜在问题

混合空白字符可能会产生不一致和意想不到的效果。

通过使用 Java 编译器 lint 标志 `-Xlint:text-blocks` 打开文本块 lint 检测，可以检测与偶然空白相关的问题，并生成警告“不一致的空白缩进”。
此 lint 标志还启用另一个警告，“将删除尾随空格”，如果文本块内的任何行上有尾随空格，则会发出该警告。

### 行终止符的归一化

多行字符串文字的复杂性之一是源文件中使用的行终止符（`\n`、`\r`或`\r\n`）因平台而异。不同平台的编辑器可能会无形地更改行终止符。或者，如果在不同平台上编辑源文件，则文本块可能包含不同行终止符的混合。这可能会产生令人困惑和不一致的结果。

为了避免这些问题，Java 编译器将文本块中的所有行终止符规范化为`\n`，而不管源文件中实际出现什么行终止符。

如果需要平台行终止符，则可以使用 `String::replaceAll("\n", System.lineSeparator())`。

### 转义序列的翻译

与字符串文字一样，文本块识别转义序列 `\b`, `\f`, `\n`, `\t`, `\r`, `\"`, `\'`, `\\` 和八进制转义。与字符串文字不同，通常不需要转义序列。在大多数情况下，可以使用实际字符 `\n`, `\t, `\"` 和 `\'` 来代替转义序列。

当三个或更多双引号连续出现时需要转义。

转义翻译发生在 Java 编译器处理的最后一步，因此您可以使用显式转义序列绕过行终止符规范化和空格剥离步骤。

### 新转义序列

为了更好地控制换行符和空格的处理，引入了两个新的转义序列。

`\<line-terminator>` 明确禁止插入换行符，仅适用于文本块。

> 通常的做法是将非常长的字符串文字拆分为较小子字符串的串联，然后将生成的字符串表达式硬包装到多行

`\s` 简单地转换为单个空格，可用于文本块、传统字符串文字和字符文字。

转义序列直到附带的空格剥离后才会被翻译，因此\s可以充当栅栏以防止尾随空格的剥离。

## 样式指南

1. 当文本块会提高代码的清晰度时，应该使用文本块，尤其是多行字符串。
2. 如果字符串适合单行，没有连接和转义换行符，应该继续使用字符串文字。
3. 在保持可读性时使用嵌入式转义序列
4. 对于大多数多行字符串，将开始分隔符放置在前一行的右端，并将结束分隔符放置在其自己的行上，即文本块的左边距。
5. 避免对齐开始和结束分隔符和文本块的左边距。如果变量名或修饰符被更改，这需要重新缩进文本块。
6. 避免复杂表达式中的内嵌文本块，因为这样做会扭曲可读性。考虑重构为局部变量或静态最终字段。
7. 仅使用空格或仅使用制表符来缩进文本块。混合空白将导致不规则缩进的结果。
8. 当文本块包含三个或更多双引号的序列时，请转义每次运行三个双引号的第一个双引号。
9. 大多数文本块应该缩进以与相邻的 Java 代码对齐。
10. 建议将宽字符串完全左对齐以避免水平滚动或换行。
11. 当高行数导致关闭分隔符可能垂直滚动到视图之外时，将文本块完全左对齐也是合理的。这允许读者在关闭分隔符不在视线范围内时使用左边距跟踪缩进。
12. 当需要排除文本块的最后一个新行时，应使用`\<line-terminator>`转义序列。这可以更好地框住文本块并允许关闭分隔符管理缩进。

## 相关字符串方法

* `String formatted(Object... args)` 简化文本块中的值替换。 
相当于 `String.format(this, args)`。优点是，作为实例方法，它可以链接到文本块的末尾。

* `String stripIndent()` 用于从文本块内容中去除偶然的空白。
使用 Java 编译器使用的相同算法从多行字符串中删除附带的空格。如果有一个程序将文本作为输入数据读取，并且希望以与文本块相同的方式去除缩进，这将非常有用。

* `String translateEscapes()` 用于翻译转义序列。 
执行转义序列（`\b`, `\f`, `\n`, `\t`, `\r`, `\"`, `\'`, `\\` 和八进制转义）的翻译，并被 Java 编译器用于处理文本块和字符串文字。如果有一个程序将文本作为输入数据读取并且想要执行转义序列处理，这将非常有用。请注意，Unicode 转义 (`\uNNNN`)不会被处理。