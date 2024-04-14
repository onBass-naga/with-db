# with-db

こんな感じで使えるライブラリを目指す
（サンプルコードはGroovyっぽい仮想言語で記述している）

### setup

var default = Person.build(builder -> builder.firstName("Nobita").lastName("Nobi").age("10"))
var son = default.copy(builder -> builder.firstName("Sewashi"))

var operation = new Operation(connection)
operation.insert([default, son])

### assert

var dataset = DataSet.load(connection, [Table.Person, Table.Role])

// データ投入のモデルから条件を生成して比較
dataset.get(Person).filter(son.predicates()).exists()
dataset.get(Person).filter(son.predicates()).notExist()

// 自動生成によるタイプセーフな値指定
dataset.get(Person).filter(lastName("Nobi")).count()
dataset.get(Person).filter(lastName("Nobi")).list()
dataset.get(Person).filter(lastName("Nobi")).one()
dataset.get(Person).filter(lastName("Nobi")).optional()

※ 比較したくないものはany指定できる。
dataset.get(Person).filter(lastName(any())).count()


// Predicateによる条件指定
dataset.get(Person).filter(it -> it.lastName().is("Nobi")).count()

// 生の値と比較したい場合
dataset.get(Person).filter(it -> it.lastName().value().equals("Nobi")).count()

## IntelliJ の Data Extractor

下記のコードでレコードからSetupModel生成文を作成できる

```groovy
import java.lang.reflect.Method

File jarFile = new File("/path/to/with-db/generator/build/libs/generator.jar")
def urls = [new URL("jar:${jarFile.toURI().toURL()}!/")] as URL[]
Class clazz = Class.forName("com.example.with_db.generator.utils.Inflector", true, new URLClassLoader(urls));
inflector = clazz.getDeclaredMethod("getInstance").invoke(null)
//OUT.append(inflector.singularize("people"))

DOUBLE_QUOTE = '"'
NEWLINE = System.getProperty("line.separator")

KEYWORDS_LOWERCASE = com.intellij.database.util.DbSqlUtil.areKeywordsLowerCase(PROJECT)
KW_NULL = KEYWORDS_LOWERCASE ? "null" : "NULL"

def lowerCamelCase(String value) {
    inflector.lowerCamelCase(value.toLowerCase());
}

def upperCamelCaseSingular(String value) {
    inflector.singularize(inflector.upperCamelCase(value.toLowerCase()))
}

def record(columns, dataRow) {

    OUT.append("${upperCamelCaseSingular(TABLE.getName())}.builder()")

    columns.eachWithIndex { column, idx ->
        def value = dataRow.value(column)
        def stringValue = value == null ? KW_NULL : FORMATTER.formatValue(value, column)
        def isStringLiteral = value != null && FORMATTER.isStringLiteral(value, column)
        def quote = isStringLiteral ? DOUBLE_QUOTE : ""
        if (isStringLiteral && DIALECT.getDbms().isMysql()) stringValue = stringValue.replace("\\", "\\\\")

        OUT.append(".${lowerCamelCase(column.name())}($quote$stringValue$quote)")
    }
    OUT.append(".build();").append(NEWLINE)
}

ROWS.each { row -> record(COLUMNS, row) }
```
