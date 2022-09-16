Moved to Codeberg @ https://codeberg.org/TheKodeToad/jfgjds.
Reason: GitHub isn't the best and it looks "kinda neat" and a want to try it out.

# JFGJDS
A lightweight JSON parser in Java, with comparable speeds to GSON.

## Examples
### JSON deserializer
```java
JsonValue value = JsonDeserializer.read(new FileInputStream(new File("my/file.json")), StandardCharsets.UTF_8);
System.out.println(value.asObject().get("name").getStringValue());
```

### JSON serializer
```java
JsonSerializer.write(value, new FileOutputStream(new File("output/file.json")), StandardCharsets.UTF_8);
```

### Coercion
```java
JsonValue.coerce(null);          // -> JSON null
JsonValue.coerce(40);            // -> JSON number
JsonValue.coerce(aMapSomewhere); // -> JSON object
```

### Clean object creation
```java
JsonObject.of(
    "name", "Jason",
    "age", JsonObject.of(
        "value", 42,
        "can_drive", true
    )
);
// -> {"name":"Jason","age":{"value":42.0,"can_drive":true}}
```
