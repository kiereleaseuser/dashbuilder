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
package org.dashbuilder.dataset;

import java.util.List;

/**
 * A data set is a matrix of values composed by a fixed number of columns.
 */
public interface DataColumn {

    /**
     * @return The DataSet instance associated to this this DataColumn.
     * @see org.dashbuilder.dataset.DataSet
     */
    DataSet getDataSet();

    /**
     * @return The identifier of this DataColumn
     */
    String getId();

    /**
     * @return The column's type.
     * @see org.dashbuilder.dataset.ColumnType
     */
    ColumnType getColumnType();

    /**
     * @return A List of the values for this DataColumn.
     */
    List getValues();
}