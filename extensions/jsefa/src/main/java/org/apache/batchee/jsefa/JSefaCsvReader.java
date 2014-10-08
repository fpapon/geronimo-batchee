/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.batchee.jsefa;

import net.sf.jsefa.Deserializer;
import net.sf.jsefa.csv.CsvIOFactory;

import javax.batch.api.BatchProperty;
import javax.inject.Inject;

public class JSefaCsvReader extends JSefaReader {
    @Inject
    @BatchProperty
    private String lineFilter;

    @Inject
    @BatchProperty
    private String lowLevelConfiguration;

    @Inject
    @BatchProperty
    private String lineFilterLimit;

    @Inject
    @BatchProperty
    private String specialRecordDelimiter;

    @Inject
    @BatchProperty
    private String lineBreak;

    @Inject
    @BatchProperty
    private String defaultNoValueString;

    @Inject
    @BatchProperty
    private String defaultQuoteMode;

    @Inject
    @BatchProperty
    private String fieldDelimiter;

    @Inject
    @BatchProperty
    private String quoteCharacter;

    @Inject
    @BatchProperty
    private String quoteCharacterEscapeMode;

    @Inject
    @BatchProperty
    private String useDelimiterAfterLastField;

    @Override
    protected Deserializer initDeserializer() throws Exception {
        return CsvIOFactory.createFactory(
            JsefaConfigurations.newCsvConfiguration(
                defaultNoValueString, defaultQuoteMode, fieldDelimiter, lineBreak, quoteCharacter,
                quoteCharacterEscapeMode, useDelimiterAfterLastField, validationMode, validationProvider,
                lineFilter, lowLevelConfiguration, lineFilterLimit, objectAccessorProvider,
                specialRecordDelimiter, simpleTypeProvider, typeMappingRegistry),
            JsefaConfigurations.createObjectTypes(objectTypes)).createDeserializer();
    }
}
