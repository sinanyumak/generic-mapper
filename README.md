
## Generic Mapper

A helper project to access Mapstruct created mapper s with source and target types. 

### Usage


- Create model and dto objects.

```java
public class Fruit {
}

public class FruitDto {
}

```


- Create a `Mapstruct` mapper which extends `GenericMapper` interface. 

```java
@Mapper( componentModel="spring" )
public interface FruitMapper extends GenericMapper<Fruit, FruitDto> {
}
```


- Inject `GenericMapperService` to your service and lookup for the mapper.

```java
@Autowired
private GenericMapperService mapperService;

GenericMapper<Fruit, FruitDto> mapper = mapperService.getMapper( Fruit.class, FruitDto.class );
```

