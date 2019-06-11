# f2fentitymodels
f2fentitymodels is a Java utility tool for converting 1.12 Forge entity models to 1.14 Fabric format. The intended use case here is exporting blockbench entity models to 1.12 format, and then converting them for usage in Fabric.

# Usage
To use the program, run the latest release jar:
```java
java -jar f2fentitymodels-[version].jar
```
Enter the path of the file you want to convert (.java and .txt both work), and then copy the output of the program. You may have to import 1 or 2 classes, and you will also have to replace `YourEntity` with your entity class.

MIT license.
