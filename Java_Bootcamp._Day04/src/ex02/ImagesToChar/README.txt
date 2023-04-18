
Извлекаем файлы
cd target
jar xf ../lib/jcommander-1.72.jar
jar xf ../lib/JCDP-4.0.0.jar
rm -rf META-INF
cd ..

# Для компиляции использовать след.:
javac -d target -sourcepath src/java -cp lib/\* src/java/edu/school21/printer/app/Program.java src/java/edu/school21/printer/logic/*.java
# копируем фото в ресурсы
cp -R src/resources ./target/resources

# создаем архив
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

# доступ к архиву
chmod u+x target/images-to-chars-printer.jar

# запуск
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN
