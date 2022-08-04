
@org.hibernate.annotations.TypeDef(
        name = "JsonbType"
        , typeClass = JsonbType.class
        , defaultForType = com.fasterxml.jackson.databind.JsonNode.class
        , parameters = {}
        )

package org.acme.getting.started.db;