
# Для компиляции использовать след.:
javac -d ./target -sourcepath src/java src/java/edu/school21/printer/app/Program.java

# копируем фото в ресурсы
cp -R src/resources target/.

# создаем архив
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

# доступ к архиву
chmod u+x target/images-to-chars-printer.jar

# запуск
java -jar target/images-to-chars-printer.jar _ #