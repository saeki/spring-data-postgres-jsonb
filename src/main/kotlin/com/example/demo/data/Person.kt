package com.example.demo.data

import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "person")
@TypeDefs(
        TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
)
data class Person(
        @Id var id: UUID? = null,
        var name: String? = null,
        @Type(type = "jsonb") var metadata: Metadata? = null,
        @Type(type = "jsonb") var params: List<Parameter>? = null
) {

    data class Metadata(
            var dob: LocalDate? = null,
            var bloodType: String? = null,
            var tags: List<String>? = null
    )

    data class Parameter(
            var name: String? = null,
            var value: String? = null
    )
}
