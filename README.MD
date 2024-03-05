Учет Студентов.

Создайте класс Student с полями для имени, возраста, списка предметов, которые студент изучает, и списка оценок (средний балл). 
Используйте коллекции для хранения предметов и оценок.
Сформируйте список студентов, в котором они будут хранитьсч по убыванию среднего балла.

---

## Учёт студентов с использованием коллекций в Java

Наш проект предоставляет систему учёта студентов, позволяя отслеживать их успеваемость по различным предметам. Для реализации используются стандартные коллекции Java, что обеспечивает гибкость и удобство управления данными.

### Класс `Student`

Класс `Student` является основным в нашей системе и содержит следующие поля:

- `StudentName name`: имя студента.
- `Age age`: возраст студента.
- `List<Subject> subjectList`: список предметов, которые изучает студент. Каждый предмет представлен классом `Subject`, содержащим название предмета и оценку.
- `Rating rating`: средний балл студента, вычисляемый на основе оценок по всем предметам.

### Использование коллекций

Для хранения предметов и оценок используется интерфейс `List` из коллекций Java. Это позволяет легко добавлять, удалять и итерировать предметы, а также вычислять средний балл на их основе.

### Функциональность

Класс `Student` предоставляет следующие ключевые функции:

- Добавление предмета с оценкой: метод `addSubjectToLearnSchedule(Subject subject)` позволяет добавлять новые предметы в список изучаемых, автоматически пересчитывая средний балл.
- Расчёт среднего балла: метод `ratingCalculation()` вычисляет средний балл на основе оценок по всем предметам и обновляет поле `rating`.

### Управление списком студентов

Список студентов хранится в коллекции типа `List<Student>`, что позволяет эффективно управлять данными: добавлять новых студентов, удалять, сортировать список по среднему баллу и т.д. Сортировка студентов по убыванию среднего балла может быть выполнена с использованием метода `Collections.sort` с кастомным компаратором, сравнивающим студентов по их среднему баллу.

### Пример использования

```java
import org.domain.Student;
import org.domain.Subject;
import org.domain.valueobjects.Age;
import org.domain.valueobjects.StudentName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        // Создаем студентов
        Student student1 = new Student(new StudentName("Иван Иванов"), new Age(20));
        Student student2 = new Student(new StudentName("Мария Петрова"), new Age(19));
        
        // Добавляем предметы с использованием фабричных методов
        student1.addSubjectToLearnSchedule(Subject.createSubjectWithRating("Математика", 4.5));
        student1.addSubjectToLearnSchedule(Subject.createSubjectWithRating("Физика", 4.0));
        
        student2.addSubjectToLearnSchedule(Subject.createSubjectWithRating("Литература", 4.7));
        student2.addSubjectToLearnSchedule(Subject.createSubjectWithRating("История", 4.8));
        
        // Формируем список студентов
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        
        // Сортировка списка студентов по среднему баллу в убывающем порядке
        Collections.sort(students, (s1, s2) -> Double.compare(s2.getRating().getRatingValue(), s1.getRating().getRatingValue()));
        
        // Вывод отсортированного списка студентов
        System.out.println("Студенты, отсортированные по среднему баллу:");
        for (Student student : students) {
            System.out.println(student.getName().getName() + ", Средний балл: " + student.getRating().getRatingValue());
        }
    }
}
```

В этом примере:
- Мы создаем объекты `Student`, используя конструкторы с объектами `StudentName` и `Age`.
- Используем фабричные методы `createSubjectWithRating` из класса `Subject` для создания предметов с оценками и добавляем их студентам через метод `addSubjectToLearnSchedule`.
- Формируем список студентов и сортируем его по среднему баллу с использованием лямбда-выражения и метода `Collections.sort`.
- Выводим информацию о студентах и их средних баллах на экран.
