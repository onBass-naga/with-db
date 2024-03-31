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
dataset.get(Person).filter([lastName("Nobi")]).count()
dataset.get(Person).filter([lastName("Nobi")]).list()
dataset.get(Person).filter([lastName("Nobi")]).one()
dataset.get(Person).filter([lastName("Nobi")]).optional()

※ 比較したくないものはany指定できるようにする。
条件を複数指定した場合に後勝ちにすることでDB内で生成されたIDや日付を比較対象から除外する


// Predicateによる条件指定
dataset.get(Person).filter([it -> it.lastName().is("Nobi")]).count()

// 生の値と比較したい場合
dataset.get(Person).filter([it -> it.lastName().value().equals("Nobi")]).count()

