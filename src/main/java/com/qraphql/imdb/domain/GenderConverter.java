package com.qraphql.imdb.domain;

import org.apache.commons.lang3.StringUtils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

/**
 * @author : mohammad
 * @since : 10/6/2021 10:08 PM , Wed
 * graphql-imdb
 **/
//@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<ActorsEntity.Gender, String>
{

    @Override
    public String convertToDatabaseColumn(ActorsEntity.Gender gender)
    {
        return gender == null ? null : gender.getValue();
    }

    @Override
    public ActorsEntity.Gender convertToEntityAttribute(String v)
    {
        if (StringUtils.isEmpty(v)) return null;

        return Stream.of(ActorsEntity.Gender.values())
                     .filter(c -> c.getValue().equals(v))
                     .findFirst()
                     .orElseThrow(IllegalArgumentException::new);
    }
}
