/**
 * Copyright (C) 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dashbuilder.dataset.def;

import org.dashbuilder.dataprovider.DataSetProviderType;
import org.dashbuilder.dataset.validation.groups.SQLDataSetDefDbSQLValidation;
import org.dashbuilder.dataset.validation.groups.SQLDataSetDefDbTableValidation;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.errai.common.client.api.annotations.Portable;

import javax.validation.constraints.NotNull;

@Portable
public class SQLDataSetDef extends DataSetDef {

    @NotNull(message = "{dataSetApi_sqlDataSetDef_dataSource_notNull}")
    @NotEmpty(message = "{dataSetApi_sqlDataSetDef_dataSource_notNull}")
    protected String dataSource;

    protected String dbSchema;

    @NotNull(message = "{dataSetApi_sqlDataSetDef_dbTable_notNull}", groups = SQLDataSetDefDbTableValidation.class)
    @NotEmpty(message = "{dataSetApi_sqlDataSetDef_dbTable_notNull}", groups = SQLDataSetDefDbSQLValidation.class)
    protected String dbTable;

    @NotNull(message = "{dataSetApi_sqlDataSetDef_dbSQL_notNull}")
    @NotEmpty(message = "{dataSetApi_sqlDataSetDef_dbSQL_notNull}")
    protected String dbSQL;
    
    protected boolean allColumnsEnabled = true;

    public SQLDataSetDef() {
        super.setProvider(DataSetProviderType.SQL);
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDbTable() {
        return dbTable;
    }

    public void setDbTable(String dbTable) {
        this.dbTable = dbTable;
    }

    public String getDbSchema() {
        return dbSchema;
    }

    public void setDbSchema(String dbSchema) {
        this.dbSchema = dbSchema;
    }

    public String getDbSQL() {
        return dbSQL;
    }

    public void setDbSQL(String dbSQL) {
        this.dbSQL = dbSQL;
    }

    public boolean isAllColumnsEnabled() {
        return allColumnsEnabled;
    }

    public void setAllColumnsEnabled(boolean allColumnsEnabled) {
        this.allColumnsEnabled = allColumnsEnabled;
    }

    public boolean isCacheEnabled() {
        return cacheEnabled;
    }

    public void setCacheEnabled(boolean cacheEnabled) {
        this.cacheEnabled = cacheEnabled;
    }

    public Integer getCacheMaxRows() {
        return cacheMaxRows;
    }

    public void setCacheMaxRows(Integer cacheMaxRows) {
        this.cacheMaxRows = cacheMaxRows;
    }

    @Override
    public DataSetDef clone() {
        SQLDataSetDef def = new SQLDataSetDef();
        clone(def);
        def.setDataSource(getDataSource());
        def.setDbSchema(getDbSchema());
        def.setDbTable(getDbTable());
        def.setAllColumnsEnabled(isAllColumnsEnabled());
        return def;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("UUID=").append(UUID).append("\n");
        out.append("Provider=").append(provider).append("\n");
        out.append("Public=").append(isPublic).append("\n");
        out.append("Push enabled=").append(pushEnabled).append("\n");
        out.append("Push max size=").append(pushMaxSize).append(" Kb\n");
        if (refreshTime != null) {
            out.append("Refresh time=").append(refreshTime).append("\n");
            out.append("Refresh always=").append(refreshAlways).append("\n");
        }
        out.append("Data source=").append(dataSource).append("\n");
        if (dbSchema != null) out.append("DB Schema=").append(dbSchema).append("\n");
        out.append("DB Table=").append(dbTable).append("\n");
        out.append("DB SQL=").append(dbSQL).append("\n");
        out.append("Get all columns=").append(allColumnsEnabled).append("\n");
        out.append("Cache enabled=").append(cacheEnabled).append("\n");
        out.append("Cache max rows=").append(cacheMaxRows).append(" Kb\n");
        return out.toString();
    }
}
