# Паттерны

Паттерн "Состояние" – яркий пример замены условных конструкций на полиморфизм подтипов. 
Он довольно широко используется и способен по-настоящему снизить сложность кода. 
В этом упражнении вам предстоит отработать его на примере протокола TCP.

HTTP – протокол без состояния, то есть после запроса получается ответ и на этом всё заканчивается. 
Не все протоколы так работают. Например, TCP, на базе которого работает интернет, устроен значительно сложнее. 
В нём сначала происходит соединение между программами на разных компьютерах, затем обмен данными. 
В конце выполняется разрыв соединения.

В этом задании TcpConnection не настоящий. Он эмулирует то поведение, которого достаточно для отработки паттерна Состояние, 
все остальное убрано чтобы не отвлекать от идей ООП.

Объект соединения ведёт себя по-разному, в зависимости от того, установлено соединение или нет. 
Например, если попробовать отправить данные, когда соединения нет, то на экран выводится сообщение об ошибке. 
То же самое касается попытки установить соединение в той ситуации, 
когда оно уже установлено или разорвать уже разорванное соединение. Сообщение об ошибке должно содержать слово "Error".

```java
// На вход принимаются ip-адрес и порт
TcpConnection connection = new TcpConnection("132.223.243.88", 2342);
connection.connect();
connection.getCurrentState(); // "connected"
connection.write("data");
connection.disconnect();
connection.getCurrentState(); // "disconnected"
// Выводит на экран сообщение об ошибке
connection.disconnect(); // => "Error! Connection already disconnected"
```

## main/java/exercise/TcpConnection.java

* Реализуйте класс `TcpConnection` в соответствии с примером выше.  
* Конструктор класса принимает в качестве аргументов ip-адрес (строка) и порт (целое число). 
* Класс содержит следующие интерфейсные методы:

  * `getCurrentState()` — возвращает текущее состояние в виде строки
  * `connect()` — устанавливает новое соединение
  * `disconnect()` — разрывает установленное соединение
  * `write()` — добавляет текстовые данные в буфер

  Все варианты поведения можно увидеть в тестах. Для изменения состояния вам понадобится дополнительная внутренняя логика. 
* Реализуйте её по своему усмотрению.

## main/java/exercise/connections/Connection.java; main/java/exercise/connections/Connected.java; main/java/exercise/connections/Disconnected.java

* Реализуйте интерфейс `Connection` и классы состояний `Connected`, `Disconnected`, которые его реализуют.Сделайте это так, как считаете нужным.