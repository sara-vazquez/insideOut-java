# My diary: A Personal Moments Manager

## Project Description
My Diary is a console application designed to help users manage and remember their life moments. The tool allows you to register each moment with a title, a description, and an assigned emotion, making it easy to review and organize them later. The program supports various functionalities, such as adding new moments, viewing all registered entries, deleting entries, and filtering them by emotion or date.

## Prerequisites
To run this project, you need the following installed on your system:
- Java Development Kit (JDK): Version 21.
- Maven: Version 2.8.1 or higher. The project was created using the maven-archetype-quickstart archetype.

## Class diagram
```mermaid
---
config:
  theme: 'base'
  themeVariables:
    primaryColor: '#E2E882'
    primaryTextColor: '#66693E'
    primaryBorderColor: '#66693E'
    lineColor: '#D1E8CF'
    secondaryColor: '#D776E5'
    tertiaryColor: '#635066'
---
classDiagram
direction TB
    class HomeController {
        +HomeController()
        +void index()
    }

    class MomentController {
        -MomentRepository repository
        +void storeMoment(MomentDTO momentDTO)
        +List~MomentResponseDTO~ getAllMoments()
        +void deleteMoment(int id)
        +List~MomentResponseDTO~ getMomentsByEmotion(Emotion emotion)
        +List~MomentResponseDTO~ getMomentsByDate(int month, int year)
    }

    class MomentRepository {
        -InterfaceDatabase~Moment~ db
        +void save(Moment moment)
        +List~Moment~ getAllMoments()
        +void deleteMoment(int id)
        +List~Moment~ filterByEmotion(Emotion emotion)
        +List~Moment~ filterByDate(int month, int year)
    }

    class DiaryDatabase {
        -List~Moment~ moments
        +void store(Moment moment)
        +List~Moment~ getAll()
        +void deleteMoment(int id)
        +List~Moment~ filterByEmotion(Emotion emotion)
        +List~Moment~ filterByDate(int month, int year)
    }

    class InterfaceDatabase {
        <<interface>>
        +void store(T t)
        +List~T~ getAll()
        +void deleteMoment(int id)
        +List~T~ filterByEmotion(Emotion emotion)
        +List~T~ filterByDate(int month, int year)
    }

    class MomentMapper {
        +static Moment toEntity(MomentDTO dto)
        +static MomentResponseDTO toDto(Moment entity)
    }

    class Moment {
        -int id
        -String momentTitle
        -String momentDescription
        -Emotion emotion
        -LocalDate momentDate
        -LocalDateTime creationDate
        -LocalDateTime modDate
        +Moment(String, String, Emotion, LocalDate)
    }

    class MomentDTO {
        <<record>>
        -int id
        -String momentTitle
        -String momentDescription
        -Emotion emotion
        -LocalDate momentDate
    }

    class MomentDTOResponse {
        <<record>>
        -int id
        -String momentTitle
        -String momentDescription
        -Emotion emotion
        -LocalDate momentDate
    }

    class Emotion {
        <<enumeration>>
        -int emotionNumber
        +ALEGRIA(1)
        +TRISTEZA(2)
        +IRA(3)
        +ASCO(4)
        +MIEDO(5)
        +ANSIEDAD(6)
        +ENVIDIA(7)
        +VERGUENZA(8)
        +ABURRIMIENTO(9)
        +NOSTALGIA(10)
        +int getEmotionNumber()
    }
    
    class View {
        +static Scanner SCANNER
    }

    class FilterDateView {
        -MomentController controller
        +static void filterByDate()
    }

    class FilterEmotionView {
        -MomentController controller
        +static void filterByEmotion()
    }

    class FilterView {
        -MomentController controller
        +static void printFilterMenu()
    }

    class HomeView {
        -MomentController controller
        +static void printMenu()
    }

    class MomentDeleteView {
        -MomentController controller
        +static void printDeleteMoment()
    }

    class MomentPostView {
        -MomentController controller
        +static void storeMoment()
    }

    class MomentGetView {
        -MomentController controller
        +static void viewAllMoments()
    }

    MomentController o-- MomentRepository
    MomentController ..> MomentMapper
    MomentController ..> MomentDTO
    MomentController ..> MomentDTOResponse
    MomentRepository o-- InterfaceDatabase
    MomentRepository o-- Moment
    DiaryDatabase ..|> InterfaceDatabase
    MomentMapper ..> Moment
    MomentMapper ..> MomentDTO
    MomentMapper ..> MomentDTOResponse
    Moment o-- Emotion
    InterfaceDatabase o-- Emotion
    MomentDTO o-- Emotion
    MomentDTOResponse o-- Emotion
    
    HomeView o-- MomentController
    HomeView ..> FilterDateView
    HomeView ..> FilterEmotionView
    HomeView ..> FilterView
    HomeView ..> MomentDeleteView
    HomeView ..> MomentPostView
    HomeView ..> MomentGetView
    
    FilterDateView o-- MomentController
    FilterEmotionView o-- MomentController
    MomentDeleteView o-- MomentController
    MomentPostView o-- MomentController
    MomentGetView o-- MomentController
    
    HomeView <|-- View
    FilterDateView <|-- View
    FilterEmotionView <|-- View
    FilterView <|-- View
    MomentDeleteView <|-- View
    MomentPostView <|-- View
    MomentGetView <|-- View
```
## Installation and Execution Steps
Follow these steps to get the project up and running:

1. Clone the Repository: Open your terminal and clone the project using the following command:
 ```
   git clone [https://github.com/sara-vazquez/insideOut-java]
   cd [isideout-directory]
 ```

2. Compile the Project: Use Maven to compile the source code.
```
mvn clean install
```

3. Run the Application: Once compiled, you can run the console application.
```
java -jar target/my-diario.jar
```

## Test coverage
![test coverage](coverage-insideout.png)

## How to Run Tests
To run the project's unit tests and generate the coverage report, use the following Maven command:
mvn test
```
mvn test
```

