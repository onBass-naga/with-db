package ${packageName};

import com.example.with_db.database.Records;

import java.util.List;

public class ${table.upperCamelCaseSingularName()}Records extends Records<${table.upperCamelCaseSingularName()}Entity, ${table.upperCamelCaseSingularName()}Records> {
    public ${table.upperCamelCaseSingularName()}Records(final List<${table.upperCamelCaseSingularName()}Entity> values) {
        super.values = values;
    }

    @Override
    protected Class<${table.upperCamelCaseSingularName()}Records> getRecordsClass() {
        return ${table.upperCamelCaseSingularName()}Records.class;
    }
}
