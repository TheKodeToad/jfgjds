# JFGJDS
A tiny JSON parser in Java, with comparable speeds to GSON.

## Usage
Read JSON file:
```java
JsonValue value = JsonDeserializer.read(new FileInputStream(new File("my/file.json")), StandardCharsets.UTF_8);
System.out.println(value.asObject().get("name").getStringValue());
```

Write JSON file:
```java
JsonSerializer.write(value, new FileOutputStream(new File("output/file.json")), StandardCharsets.UTF_8);
```
